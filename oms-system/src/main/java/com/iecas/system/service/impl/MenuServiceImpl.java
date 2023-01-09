package com.iecas.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iecas.system.domain.Menu;
import com.iecas.system.mapper.MenuMapper;
import com.iecas.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    MenuMapper menuMapper;
    @Override
    public List<Menu> listByUserId(long userId) {
        return menuMapper.selectList(userId);
    }
}
