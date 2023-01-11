package com.iecas.system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fuqiang
 * @since : 2023/1/12 01:05
 **/
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    //基本配置信息
    @Bean
    public ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("通用管理平台")
                .description("集成通用管理平台的常见功能")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi(ApiInfo apiInfo) {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo)
                .groupName("SwaggerGroupOneAPI-1.0")
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

}
