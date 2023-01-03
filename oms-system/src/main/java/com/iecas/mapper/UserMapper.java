package com.iecas.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserMapper extends BaseMapper<User> {


    User selectByName(String name);
}
