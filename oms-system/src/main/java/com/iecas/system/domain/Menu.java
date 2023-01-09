package com.iecas.system.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_menu")
public class Menu {
    private Long id;
    private String menuName;
    private Long parentId;
    private Integer menuSort;
    private String component;
    private String menuType;
    private String menuIcon;
    private Date createTime;
    private Date updateTime;

}
