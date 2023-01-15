package com.iecas.system.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.spring.SpringMVCUtil;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.common.result.ResultCodeEnum;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.qo.LoginInfoQo;
import com.iecas.system.service.impl.SysUserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class LoginController {
    private static final String NODE = "[login]";

    @Autowired
    SysUserServiceImpl sysUserService;

    @PostMapping("login")
    public R login(@RequestBody @Validated LoginInfoQo loginInfo) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_type", "00")
                .eq("password", SaSecureUtil.md5(loginInfo.getPassword()))
                .last("limit 1");
        SysUser user = sysUserService.getOne(queryWrapper);
        // 更新登录信息
        user.setLoginDate(LocalDateTime.now());
        System.out.println(SpringMVCUtil.getRequest().getRemoteHost());
        user.setLoginIp("127.0.0.1");
        sysUserService.updateById(user);
        log.info(NODE + user.getUserName() + "登录成功");
        if (ObjectUtils.isEmpty(user)) {
            return R.setResult(ResultCodeEnum.LOGIN_ERROR);
        } else {
            return R.ok();
        }
    }

    @GetMapping("logout")
    public R logout() {
        if (StpUtil.isLogin()) {
            Long userId = (Long) StpUtil.getLoginId();
            StpUtil.logout();
            log.info(NODE + "用户编号" + userId + "退出系统");
            return R.ok().message("登出成功");
        } else {
            return R.error().message("用户未登录");
        }
    }
}
