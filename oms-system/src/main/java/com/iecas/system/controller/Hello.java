package com.iecas.system.controller;

import com.iecas.common.result.R;
import com.iecas.system.entity.SysUser;
import com.iecas.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fuqiang
 * @since: 2023/1/12 01:11
 **/
@RestController
@RequestMapping("hello")
public class Hello {

    @Autowired
    ISysUserService sysUserService;
    @GetMapping("say")
    public R sayHello(){
        return R.ok().message("hello");
    }

    @GetMapping("users")
    public R getUser(){
        List<SysUser> list = sysUserService.list();
        list.forEach(System.out::println);
        return R.ok().data("users",list);
    }

    @GetMapping("useradd")
    public R addUser(){
        SysUser user = new SysUser();
        user.setUserName("fuqiang");
        user.setNickName("付强");
        boolean save = sysUserService.save(user);
        return R.ok().data("result",save);
    }
}
