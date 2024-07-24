package com.yunyd.common.config;

import cn.hutool.core.util.ObjectUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.yunyd.common.Constants;
import com.yunyd.common.enums.ResultCodeEnum;
import com.yunyd.common.enums.RoleEnum;
import com.yunyd.entity.Account;
import com.yunyd.exception.CustomException;
import com.yunyd.service.AdminService;
import com.yunyd.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.TimeUnit;

/**
 * jwt拦截器
 * @lyd
 * @date 2024/7/12
 */
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(JwtInterceptor.class);

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;
    @Resource
    private RedisTemplate redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 1. 从http请求的header中获取token
        String token = request.getHeader(Constants.TOKEN);
        if (ObjectUtil.isEmpty(token)) {
            // 如果没拿到，从参数里再拿一次
            token = request.getParameter(Constants.TOKEN);
        }
        // 2. 开始执行认证
        if (ObjectUtil.isEmpty(token)) {
            throw new CustomException(ResultCodeEnum.TOKEN_INVALID_ERROR);
        }
        Account account = null;
        try {
            // 解析token获取存储的数据
            String userRole = JWT.decode(token).getAudience().get(0);
            String userId = userRole.split("-")[0];
            String role = userRole.split("-")[1];
            // 根据userId查询数据库
            if (RoleEnum.ADMIN.name().equals(role)) {
                account = adminService.selectById(Integer.valueOf(userId));
            }else if (RoleEnum.USER.name().equals(role)){
                account = userService.selectById(Integer.valueOf(userId));
            }
        } catch (Exception e) {
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        if (ObjectUtil.isNull(account)) {
            throw new CustomException(ResultCodeEnum.USER_NOT_EXIST_ERROR);
        }
        try {
            // 用户密码加签验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(account.getPassword())).build();
            jwtVerifier.verify(token);// 验证token
        } catch (JWTVerificationException e) {
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        String redisToken = (String)redisTemplate.opsForValue().get(Constants.REDIS_TOKEN_ADMIN + account.getId());
        if (redisToken == null || !redisToken.equals(token)){
            throw new CustomException(ResultCodeEnum.TOKEN_CHECK_ERROR);
        }
        Long expire = redisTemplate.getExpire(Constants.REDIS_TOKEN_ADMIN + account.getId(), TimeUnit.MINUTES);
        if (expire != null && expire == -2) {
            // 键已过期  如果 expire为1 则没设置有效期
            throw new CustomException(ResultCodeEnum.TOKEN_EXPIRED_ERROR);
        }
        // 距离还剩过期时间的百分之二十
        if (expire <= Constants.THRESHOLD * Constants.EXPIRED_TIME){
            // 键还未过期，重新设置过期时间 -> 续签
            redisTemplate.opsForValue().set(Constants.REDIS_TOKEN_ADMIN + account.getId(),token,Constants.EXPIRED_TIME, TimeUnit.MINUTES);
        }

        return true;
    }
}