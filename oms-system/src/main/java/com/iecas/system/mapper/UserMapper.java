package com.iecas.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.iecas.system.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {


    User selectByName(String name);
}
