package com.iecas.system.domain;

import lombok.Data;

import java.util.Date;

@Data
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
