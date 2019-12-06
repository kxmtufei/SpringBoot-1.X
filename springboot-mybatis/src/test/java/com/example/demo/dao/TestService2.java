/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.service.WeaponService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 *@author : wuch
 *@date: 2019/12/5
 */
public class TestService2 extends DemoApplicationTests {
    @Autowired
    WeaponService service;

    @Test
    public void testService(){
        System.out.println(service.findOne(2));
    }
}
