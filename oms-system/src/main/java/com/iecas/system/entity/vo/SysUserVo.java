package com.iecas.system.entity.vo;

import lombok.Data;

import java.util.Date;

@Data
public class SysUserVo {
    private Long userId;
    private String userName;
    private String nickName;
    private String deptName;
    private String phoneNumber;
    private String loginIp;
    private Date loginDate;
}
