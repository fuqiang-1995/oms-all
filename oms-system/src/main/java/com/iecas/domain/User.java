package com.iecas.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String name;
    private String name_zh;
    private String password;
}
