package com.iecas.controller;

import com.iecas.domain.User;
import com.iecas.result.R;
import com.iecas.satoken.PasswordUtil;
import com.iecas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 注册用户
     * @param user 用户信息
     */
    @PostMapping("register")
    public R addUser(@RequestBody User user){
        System.out.println(user);
        // 密码加密
        user.setPassword(PasswordUtil.encode(user.getPassword()));
        boolean result = userService.save(user);
        if (result){
            return R.ok().message("注册成功");
        } else {
            return R.error().message("注册失败");
        }
    }



    @PostMapping("get")
    public R getUserByName(@RequestBody String name){
        User user = userService.getByName(name);
        return R.ok().data("user", user);
    }
}
