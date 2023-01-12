package com.iecas.system.controller;

import com.iecas.common.result.R;
import com.iecas.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-12 12:45:21
 */
@Controller
@RequestMapping("/system/sysUser")
public class SysUserController {

    @Autowired
    ISysUserService userService;
    /**
     * 查询用户列表
     */
    public R list(@RequestBody ){

        userService.
    }

}
