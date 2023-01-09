package com.iecas.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.system.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectList(Long userId);
}
