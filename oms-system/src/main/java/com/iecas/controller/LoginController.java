package com.iecas.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.iecas.domain.User;
import com.iecas.result.R;
import com.iecas.result.ResultCodeEnum;
import com.iecas.satoken.PasswordUtil;
import com.iecas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户登录
 */
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("login")
    public R login(@RequestBody User user){
        // 校验用户名
        User dbUser = userService.getByName(user.getName());
        if (ObjectUtils.isEmpty(dbUser)){
            return R.setResult(ResultCodeEnum.USER_NOTFOUND);
        }
        // 校验密码
        String encode = PasswordUtil.encode(user.getPassword());
        if (!dbUser.getPassword().equals(encode)) {
            return R.setResult(ResultCodeEnum.PASSWORD_ERROR);
        }
        // 登录
        StpUtil.login(user.getName());
        return R.ok();
    }

    @GetMapping("check")
    public R isLogin(){
        if (StpUtil.isLogin()) {
            return R.ok();
        }else {
            return R.error();
        }
    }
}