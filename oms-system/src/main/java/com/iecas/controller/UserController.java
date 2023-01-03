package com.iecas.controller;

import com.iecas.domain.User;
import com.iecas.result.R;
import com.iecas.result.ResultCodeEnum;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("add")
    public R addUser(@RequestBody User user){
        return R.setResult(ResultCodeEnum.SUCCESS).data("user", user);
    }
}
