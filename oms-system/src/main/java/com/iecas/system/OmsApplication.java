package com.iecas.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 系統启动类
 */
@SpringBootApplication
@MapperScan("com.iecas.**.mapper")
public class OmsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OmsApplication.class, args);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("-------" + name);
        }
    }
}
