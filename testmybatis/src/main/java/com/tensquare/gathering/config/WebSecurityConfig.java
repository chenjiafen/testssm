package com.tensquare.gathering.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author chenjiafeng2
 * @create 2021-07-06 13:53
 * @desc 安全配置类
 * WebSecurityConfigurerAdapter过滤器
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**")//所有路径跳过security校验
                .permitAll()
                .anyRequest()
                .authenticated()
                .and().
                csrf()
                .disable();
    }
}
