package com.iecas.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysMenu;
import com.iecas.system.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 02:41:09
 */
@Controller
@RequestMapping("/system/sysMenu")
public class SysMenuController {

    @Autowired
    SysMenuServiceImpl sysMenuService;

    @GetMapping("list")
    public R list() {
        // 获取登录用户ID
        Long userId = StpUtil.getLoginIdAsLong();
        List<SysMenu> menus = sysMenuService.listByUserId(userId);
        return R.ok().data("menus", menus);
    }
}
