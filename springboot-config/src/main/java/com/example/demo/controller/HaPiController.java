/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import com.example.demo.bean.ConfigBean;
import com.example.demo.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  将配置文件的属性赋给实体类
 *@author : wuch
 *@date: 2019/11/25
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class})
public class HaPiController {
    @Resource
    ConfigBean configBean;

    @GetMapping(value = "/hapi")
    public String hapi(){
        return configBean.getGreeting()+">>>"+configBean.getName()+">>>"+configBean.getUuid()+">>>"+configBean.getMax();
    }

    @Autowired
    User user;

    @RequestMapping(value = "/user")
    public String user(){
        return user.getName()+":"+user.getAge();
    }

}
