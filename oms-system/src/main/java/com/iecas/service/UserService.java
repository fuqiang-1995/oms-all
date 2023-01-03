package com.iecas.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.iecas.domain.User;

/**
 * 用户服务相关
 */
public interface UserService extends IService<User> {

    User getByName(String name);
}
