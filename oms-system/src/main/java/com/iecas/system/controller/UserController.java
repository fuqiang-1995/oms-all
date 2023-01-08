package com.iecas.system.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.domain.User;
import com.iecas.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @param user 用户信息
     */
    @PostMapping("add")
    public R addUser(@RequestBody User user){
        // 密码加密
        user.setPassword(SaSecureUtil.md5(user.getPassword()));
        boolean result = userService.save(user);
        if (result){
            return R.ok().message("注册成功");
        } else {
            return R.error().message("注册失败");
        }
    }


    @GetMapping("del")
    public R delUser(@RequestParam("id") Long userId){
        User user = new User();
        user.setId(userId);
        boolean result = userService.removeById(user);
        if (result){
            return R.ok().message("删除成功");
        }else {
            return R.error().message("删除失败");
        }
    }

    public R updateUser(@RequestBody User user){
        userService.update();
        return R.ok();
    }

    public R getOneUser(@RequestBody User user){
        Long id = user.getId();
        String name = user.getName();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(id)){
            wrapper.eq("id", id);
        }
        if (!ObjectUtils.isEmpty(name)){
            wrapper.eq("name", name);
        }
        User result = userService.getOne(wrapper);
        if (ObjectUtils.isEmpty(result)){
            return R.error().message("找不到对应用户");
        }else {
            // User转换UserInfoVo
            return R.ok();
        }
    }
}
