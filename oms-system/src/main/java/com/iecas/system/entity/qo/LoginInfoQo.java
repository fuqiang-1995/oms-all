package com.iecas.system.entity.qo;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginInfoQo {
    @NotBlank(message = "用户名不能为空")
    private String username;
    @NotBlank(message = "密码不能为空")
    private String password;
}
