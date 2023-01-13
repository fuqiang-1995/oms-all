package com.iecas.system.service;

import com.iecas.system.entity.SysUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.system.entity.qo.SysUserQo;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 12:45:21
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> list(SysUserQo userQo);

}
