package com.iecas.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 系統启动类
 */
@SpringBootApplication
public class OmsApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OmsApplication.class, args);
        for (String name : context.getBeanDefinitionNames()) {
            System.out.println("-------" + name);
        }
    }
}
