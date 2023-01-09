package com.iecas.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.domain.Menu;
import com.iecas.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("add")
    public R addMenu(@RequestBody Menu menu){
        // 对menu进行校验，确认是否已存在
        boolean existMenu = existMenu(menu);
        if (existMenu){
            return R.error().message("该菜单已存在，请检查后添加");
        }
        // 对menu进行添加
        boolean save = menuService.save(menu);
        if (save){
            return R.ok().message("菜单添加成功");
        } else {
            return R.error().message("菜单添加失败");
        }
    }

    public boolean existMenu(Menu menu){
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq("id", menu.getId())
                .eq("menu_name", menu.getMenuName());
        List<Menu> menus = menuService.list(menuQueryWrapper);
        return menus.size() > 0;
    }

    /**
     * 获取全部菜单列表
     * @return 返回全部菜单列表
     * TODO 准备返回一个菜单树，提供给 角色-菜单 使用
     */
    public R list(){
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.orderByAsc("parent_id", "menu_sort");
        List<Menu> menus = menuService.list(menuQueryWrapper);
        return R.ok().data("menus", menus);
    }

    /**
     * 根据登录的权限获取对应的菜单列表
     * @return 菜单列表
     */
    @GetMapping("get")
    public R listOfPermission(){
        // 查询登录ID
        long userId = StpUtil.getLoginIdAsLong();
        // 根据用户ID查询该权限下的菜单列表
        List<Menu> menus = menuService.listByUserId(userId);
        return R.ok().data("menus", menus);
    }

    public R delMenu(@RequestBody Long[] menusId){
        List<Long> ids = Arrays.asList(menusId);
        if (CollectionUtils.isEmpty(ids)){
            return R.error().message("要删除的菜单为空");
        }
        // 先删除menuType为M 菜单类型的记录
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.eq("menu_type", "M")
                        .in("id", ids);
        boolean removeM = menuService.remove(menuQueryWrapper);
        // 再检查要删除的目录类型菜单是否有子菜单
        boolean has = menuService.hasSubMenu(ids);
        if (has){
            R.error().message("要删除的菜单含有子项，请确认");
        }
        // 删除目录类型记录
        QueryWrapper<Menu> cataQueryWrapper = new QueryWrapper<>();
        cataQueryWrapper.eq("menu_type", "C")
                .in("id", ids);
        boolean removeC = menuService.remove(menuQueryWrapper);
        // 删除相关的菜单-角色表信息
        return R.ok();
    }


}
