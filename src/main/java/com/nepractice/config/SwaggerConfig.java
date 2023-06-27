//package com.nepractice.config;
//
//import io.swagger.v3.oas.annotations.info.Info;
//import io.swagger.v3.oas.models.OpenAPI;
//import org.springdoc.core.models.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * 接口文档配置
// *
// * @author Canva
// */
//@Configuration
//public class SwaggerConfig {
//    @Bean
//    public OpenAPI apiInfo() {
//        return new OpenAPI().info(new Info().title("后端接口文档").version("1.0.0"));
//    }
//
//    @Bean
//    public GroupedOpenApi httpApi() {
//        return GroupedOpenApi.builder()
//                .group("http")
//                .pathsToMatch("/**")
//                .build();
//    }
//}