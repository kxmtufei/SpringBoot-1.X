/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 自定义配置文件赋值给javabean
 * 需要加这三个注解。@Configuration @PropertySource(value = “classpath:test.properties”)
 * @ConfigurationProperties(prefix = “com.forezp”);在1.4版本需要 PropertySource加上location
 *@author : wuch
 *@date: 2019/11/25
 */

@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.wcc")
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
