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
        // 解析token获取存储的数据
        String userRole = JWT.decode(token).getAudience().get(0);
        String userId = userRole.split("-")[0];
        String role = userRole.split("-")[1];
        // 根据userId查询数据库,如果用户角色是admin，则查询redis中admin对应的 token
        if (RoleEnum.ADMIN.name().equals(role)) {
            account = adminService.selectById(Integer.valueOf(userId));
            String redisAdminToken = (String)redisTemplate.opsForValue().get(Constants.REDIS_TOKEN_ADMIN + account.getId());
            if (redisAdminToken == null || !redisAdminToken.equals(token)){
                throw new CustomException(ResultCodeEnum.TOKEN_EXPIRED_ERROR);
            }
            //判断redis中的key是否过期，并根据条件 对token续期
            renewal(Constants.REDIS_TOKEN_ADMIN, account.getId(), token);
        }else if (RoleEnum.USER.name().equals(role)){  //如果用户角色是user，则查询redis中user对应的 token
            account = userService.selectById(Integer.valueOf(userId));
            String redisUserToken = (String)redisTemplate.opsForValue().get(Constants.REDIS_TOKEN_USER + account.getId());
            if (redisUserToken == null || !redisUserToken.equals(token)){
                throw new CustomException(ResultCodeEnum.TOKEN_EXPIRED_ERROR);
            }
            //判断redis中的key是否过期，并根据条件 对token续期
            renewal(Constants.REDIS_TOKEN_USER, account.getId(), token);
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
        return true;
    }

    // redis中token 续期
    public void renewal(String key, Integer id, String token){
        Long expire = redisTemplate.getExpire(key + id, TimeUnit.MINUTES);
        if (expire != null && expire == -2) {
            // 键已过期  如果 expire为1 则没设置有效期
            throw new CustomException(ResultCodeEnum.TOKEN_EXPIRED_ERROR);
        }
        // 距离还剩过期时间的百分之二十
        if (expire <= Constants.THRESHOLD * Constants.EXPIRED_TIME){
            // 键还未过期，重新设置过期时间 -> 续签
            redisTemplate.opsForValue().set(key + id, token, Constants.EXPIRED_TIME, TimeUnit.MINUTES);
        }
    }
}