package com.iecas.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.system.entity.SysMenu;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 02:41:09
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> listByUserId(Long userId);
}
