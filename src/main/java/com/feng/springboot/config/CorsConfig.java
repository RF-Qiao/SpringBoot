package com.feng.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    public CorsConfig(){}
    @Bean
    public CorsFilter corsFilter(){
        //1.添加cors配置信息
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:8080");
        //是否发送cookie信息
        config.setAllowCredentials(true);
        //设置允许请求的方式
        config.addAllowedMethod("*");
        //设置允许的header
        config.addAllowedHeader("*");
        //2.为URL添加映射路径
        UrlBasedCorsConfigurationSource CorsSource = new UrlBasedCorsConfigurationSource();
        CorsSource.registerCorsConfiguration("/**",config);
        //3.返回重新定义好的corsSource
        return new CorsFilter(CorsSource);
    }
}
