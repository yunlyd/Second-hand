package com.yunyd.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.yunyd.common.Result;
import com.yunyd.common.enums.ResultCodeEnum;
import com.yunyd.common.enums.RoleEnum;
import com.yunyd.entity.Account;
import com.yunyd.exception.CustomException;
import com.yunyd.service.AdminService;
import com.yunyd.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础前端接口
 */
@RestController
public class WebController {

    @Resource
    private AdminService adminService;
    @Resource
    private UserService userService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("访问成功");
    }


    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            account = adminService.login(account);
        } else if (RoleEnum.USER.name().equals(account.getRole())) {
            account = userService.login(account);
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        return Result.success(account);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            userService.register(account);
        } else {
            throw new CustomException(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            adminService.updatePassword(account);
        }else if (RoleEnum.USER.name().equals(account.getRole())){
            userService.updatePassword(account);
        }
        return Result.success();
    }

}
