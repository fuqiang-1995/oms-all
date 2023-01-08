package com.iecas.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.system.domain.User;

/**
 * 用户服务相关
 */
public interface UserService extends IService<User> {

    User getByName(String name);
}
