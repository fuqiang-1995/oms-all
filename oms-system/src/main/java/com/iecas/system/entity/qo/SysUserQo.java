package com.iecas.system.entity.qo;

import lombok.Data;

@Data
public class SysUserQo extends BaseQo {
    private String userName;
    private String nickName;
    private Long deptId;
}
