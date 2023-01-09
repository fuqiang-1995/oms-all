package com.iecas.system.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.domain.Menu;
import com.iecas.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    MenuService menuService;

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
     */
    public R list(){
        QueryWrapper<Menu> menuQueryWrapper = new QueryWrapper<>();
        menuQueryWrapper.orderByAsc("parent_id", "menu_sort");
        List<Menu> menus = menuService.list(menuQueryWrapper);
        return R.ok().data("menus", menus);
    }

    @GetMapping("get")
    public R listOfPermission(){
        // 查询登录ID
        //long userId = StpUtil.getLoginIdAsLong();
        // 根据用户ID查询该权限下的菜单列表
        List<Menu> menus = menuService.listByUserId(13L);
        return R.ok().data("menus", menus);
    }


}
