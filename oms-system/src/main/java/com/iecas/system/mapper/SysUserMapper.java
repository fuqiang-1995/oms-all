package com.iecas.system.mapper;

import com.iecas.system.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.system.entity.qo.SysUserQo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 12:45:21
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectList(SysUserQo userQo);
}
