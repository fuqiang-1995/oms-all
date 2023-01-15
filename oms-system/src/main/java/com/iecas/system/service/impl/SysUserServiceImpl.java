package com.iecas.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.vo.SysUserVo;
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
 * @since 2023-01-15 06:50:36
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Autowired
    SysUserMapper sysUserMapper;
    @Override
    public List<SysUser> listQo(SysUserVo userQo) {
        return sysUserMapper.selectListByQo(userQo);
    }
}
