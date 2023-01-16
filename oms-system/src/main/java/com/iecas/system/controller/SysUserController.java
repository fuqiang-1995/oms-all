package com.iecas.system.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.iecas.common.result.R;
import com.iecas.system.entity.SysUser;
import com.iecas.system.entity.vo.SysUserVo;
import com.iecas.system.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 用户信息表 前端控制器
 * </p>
 *
 * @author fuqiang
 * @since 2023-01-15 06:44:47
 */
@RestController
@RequestMapping("/system/sysUser")
public class SysUserController {
    @Autowired
    SysUserServiceImpl userService;

    @PostMapping("list")
    public R list(@RequestBody SysUserVo userQo) {
        List<SysUser> list = userService.listQo(userQo);
        // TODO 需要将SysUser转换为SysUserVo，避免冗余敏感信息泄露

        return R.ok().data("users", list);
    }

    @PostMapping("add")
    public R add(@RequestBody SysUser user) {
        // 检查用户名是否已存在
        if (checkUserExist(user.getUserName())) {
            return R.error().message("用户已存在");
        }
        // 加密密码，进行入库
        user.setPassword(SaSecureUtil.md5(user.getPassword()));
        boolean result = userService.save(user);
        if (result) {
            return R.ok().message("添加用户成功");
        } else {
            return R.error().message("添加用户失败");
        }
    }

    @PostMapping("update")
    public R update(@RequestBody SysUser user) {
        boolean result = userService.updateById(user);
        if (result) {
            return R.ok().message("更新用户信息成功");
        } else {
            return R.error().message("更新用户信息失败");
        }
    }

    @GetMapping("delete")
    public R delete(@RequestParam Long id) {
        if (userService.removeById(id)) {
            return R.ok().message("删除用户成功");
        } else {
            return R.error().message("删除用户失败");
        }
    }

    /**
     * 检查用户是否存在
     *
     * @param userName 用户名
     * @return 用户存在返回TRUE 不存在返回FALSE
     */
    private boolean checkUserExist(String userName) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", userName);
        return userService.list(wrapper).size() > 0;
    }

}
