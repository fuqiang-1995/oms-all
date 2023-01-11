package com.iecas.system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author fuqiang
 * @since: 2023/1/12 01:11
 **/
@RestController
@RequestMapping("hello")
public class Hello {

    @GetMapping("say")
    public String sayHello(){
        return "hello";
    }
}
