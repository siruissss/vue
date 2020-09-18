package com.example.zoe.config;

/*
* 将拦截器配置到项目中*/

import com.example.zoe.interceptor.LoginInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    @Bean
    public LoginInterceptor getLoginIntercepter(){
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        /*
        * 对所有路径应用拦截器，除了 /index.html*/
        registry.addInterceptor(getLoginIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html");
    }
}
