package com.iecas.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.vo.SysUserVo;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-15 06:50:36
 */
public interface ISysUserService extends IService<SysUser> {

    List<SysUser> listQo(SysUserVo userQo);
}
