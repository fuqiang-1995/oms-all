package com.iecas.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role")
public class Role {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String roleKey;
    private String roleName;
    private Integer roleSort;
    private Date createTime;
    private Date updateTime;
}
