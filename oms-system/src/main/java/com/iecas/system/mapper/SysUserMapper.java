package com.iecas.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.vo.SysUserVo;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-15 06:50:36
 */
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> selectListByQo(SysUserVo userQo);
}
