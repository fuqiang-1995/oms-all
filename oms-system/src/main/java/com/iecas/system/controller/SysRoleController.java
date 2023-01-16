package com.iecas.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysRole;
import com.iecas.system.service.impl.SysRoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public R list() {
        List<SysRole> list = sysRoleService.list();
        return R.ok().data("roles", list);
    }

    @PostMapping("add")
    public R add(@RequestBody SysRole role) {
        //检查角色是否存在
        if (checkExistRole(role)) {
            return R.error().message("角色名或角色码已存在");
        }
        if (sysRoleService.save(role)) {
            return R.ok().message("角色添加成功");
        } else {
            return R.error().message("角色添加失败");
        }
    }

    @GetMapping("delete")
    public R delete(@RequestParam Long roleId) {
        if (sysRoleService.removeById(roleId)) {
            return R.ok().message("删除角色成功");
        } else {
            return R.error().message("删除角色失败");
        }
    }

    @PostMapping("update")
    public R update(@RequestBody SysRole sysRole) {
        if (sysRoleService.updateById(sysRole)) {
            return R.ok().message("更新角色成功");
        } else {
            return R.error().message("更新角色失败");
        }
    }

    /**
     * 根据角色名 角色码判断角色是否存在
     *
     * @param role 角色信息
     * @return 角色存在返回TRUE 否则返回FALSE
     */
    private boolean checkExistRole(SysRole role) {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_name", role.getRoleName())
                .eq("role_key", role.getRoleKey());
        return sysRoleService.list(wrapper).size() > 0;
    }
}
