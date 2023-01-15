package com.iecas.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysRole;
import com.iecas.system.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色信息表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 02:39:50
 */
@RestController
@RequestMapping("/system/sysRole")
public class SysRoleController {

    @Autowired
    SysRoleServiceImpl sysRoleService;
    @GetMapping("list")
    public R list(){
        List<SysRole> list = sysRoleService.list();
        list.forEach(System.out::println);
        return R.ok().data("roles", list);
    }

    @GetMapping("one")
    public R getOne(){
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", "管理员");
        SysRole one = sysRoleService.getOne(wrapper);
        return R.ok().data("roles", one);
    }
}
