/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.SpringbootMybatisApplication;
import com.example.demo.bean.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTestContextBootstrapper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

/**
 *  测试基类 - 其他类只要继承该接口即可，无需添加注解
 *@author : wuch
 *@date: 2019/12/5
 */
@WebAppConfiguration//用来声明加载的类是一个WebApplicationContext,模拟ServletContext
@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    protected MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }//这个方法在每个方法执行之前都会执行一遍

}
