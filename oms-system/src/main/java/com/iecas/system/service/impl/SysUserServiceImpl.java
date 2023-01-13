package com.iecas.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.qo.SysUserQo;
import com.iecas.system.mapper.SysUserMapper;
import com.iecas.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 12:45:21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> list(SysUserQo userQo) {
        sysUserMapper.selectPage()
        return sysUserMapper.selectList(userQo);
    }
}
