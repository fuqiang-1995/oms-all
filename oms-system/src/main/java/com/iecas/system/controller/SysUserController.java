package com.iecas.system.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.vo.SysUserVo;
import com.iecas.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-15 06:44:47
 */
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {
    @Autowired
    ISysUserService userService;

    @PostMapping("list")
    public R list(@RequestBody SysUserVo userQo) {
        List<SysUser> list = userService.listQo(userQo);
        // TODO 需要将SysUser转换为SysUserVo，避免冗余敏感信息泄露

        return R.ok().data("users", list);
    }

    @PostMapping("add")
    public R add(@RequestBody SysUser user){
        user.setPassword(SaSecureUtil.md5(user.getPassword()));
        boolean result = userService.save(user);
        System.out.println("result" + result);
        if (result) {
            return R.ok().message("添加用户成功");
        } else {
            return R.error().message("添加用户失败");
        }
    }

    @PostMapping("update")
    public R update(@RequestBody SysUser user){
        boolean result = userService.updateById(user);
        if (result) {
            return R.ok().message("更新用户信息成功");
        } else {
            return R.error().message("更新用户信息失败");
        }
    }

}
