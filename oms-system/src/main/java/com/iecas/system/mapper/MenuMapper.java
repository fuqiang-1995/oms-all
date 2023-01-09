package com.iecas.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.system.domain.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<Menu> selectList(Long userId);

    List<Menu> selectHasSubMenuList(List<Long> ids);
}
