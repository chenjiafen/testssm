package com.tensquare.gathering.config;

import com.tensquare.gathering.Filter.JwtFilter;
import com.tensquare.gathering.interceptor.JwtInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author chenjiafeng2
 * @create 2021-07-20 16:54
 * @desc 自定义拦截器
 **/
@Configuration
public class ApplicationConfig extends WebMvcConfigurationSupport {
    @Autowired
    JwtFilter jwtFilter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtFilter)//将Jwt拦截器添加
                .addPathPatterns("/**"); //指定拦截路径
//                .excludePathPatterns("/login");


    }
}
