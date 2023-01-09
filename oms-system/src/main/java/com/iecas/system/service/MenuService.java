package com.iecas.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.system.domain.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {
    List<Menu> listByUserId(long userId);

    boolean hasSubMenu(List<Long> ids);
}

