/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *  自定义属性
 *@author : wuch
 *@date: 2019/11/25
 */
@RestController
public class WoCaController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @GetMapping(value = "/woca")
    public String woca(){
        return name+":"+age;
    }
}
