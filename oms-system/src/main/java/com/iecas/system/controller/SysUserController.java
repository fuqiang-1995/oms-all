package com.iecas.system.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.qo.SysUserQo;
import com.iecas.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 12:45:21
 */
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController {

    @Autowired
    ISysUserService userService;

    /**
     * 查询用户列表
     */
    @PostMapping("list")
    public R list(@RequestBody SysUserQo userQo) {
        Page<SysUser> page = new Page<>(userQo.pageIndex, userQo.pageSize);
        List<SysUser> list = userService.list(userQo);
        // TODO 需要将SysUser转换为SysUserVo，避免冗余敏感信息泄露

        return R.ok().data("users", list);
    }

    @PostMapping("add")
    public R add(@RequestBody SysUser user){
        boolean result = userService.save(user);
        if (result) {
            return R.ok().message("添加用户成功");
        } else {
            return R.error().message("添加用户失败");
        }
    }

    public R update(@RequestBody SysUser user){
        boolean result = userService.updateById(user);
        if (result) {
            return R.ok().message("更新用户信息成功")
        }
    }

}
