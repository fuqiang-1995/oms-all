package com.iecas.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iecas.system.entity.SysMenu;
import com.iecas.system.mapper.SysMenuMapper;
import com.iecas.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 02:41:09
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> listByUserId(Long userId) {
        if (userId == 1L) {
            return sysMenuMapper.selectList(null);
        } else {
            return sysMenuMapper.selectListByUserId(userId);
        }
    }

}
