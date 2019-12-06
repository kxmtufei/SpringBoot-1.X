/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 *@author : wuch
 *@date: 2019/12/6
 */
@Configuration
public class MyWebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     *  静态资源访问
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/weapon/**").addResourceLocations("classpath:/public/");
        super.addResourceHandlers(registry);
    }
}
