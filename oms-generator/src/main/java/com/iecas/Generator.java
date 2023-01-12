package com.iecas;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * Hello world!
 *
 */
public class Generator {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/omsndb?serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "12345678";
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("fuqiang")
                            //.enableSwagger()
                            .commentDate("yyyy-MM-dd hh:mm:ss")
                            .outputDir("D:\\Projects\\IdeaProjects\\WorkSpace\\oms-all\\oms-system\\src\\main\\java\\");
                })
                .packageConfig(builder -> {
                    builder.parent("com.iecas")//设置父包名
                            .moduleName("system")//设置父模块报名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, "D:\\Projects\\IdeaProjects\\WorkSpace\\oms-all\\oms-system\\src\\main\\resources\\mapper\\"));//设置mapperXml生成路径
                })
                .strategyConfig(builder -> {
                    builder.addInclude("sys_menu");//设置需要生成的表名
                            //.addTablePrefix("");//设置过滤表前缀
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
