/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 *  创建一个service组件,它读取配置文件的 service.message属性
 *@author : wuch
 *@date: 2019/12/23
 */
@ConfigurationProperties("service")
public class ServiceProperties {
    /**
     * A message for the service.
     */
    private String message;

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
