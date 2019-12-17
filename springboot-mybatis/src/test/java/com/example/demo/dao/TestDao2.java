/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Weapon;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/12/5
 */
public class TestDao2 extends DemoApplicationTests{
    @Autowired
    private WeaponMapper dao;

    @Test
    public void daoTest(){
        List<Weapon> all = dao.findDeltsById(1);
        System.out.println(all);
    }
}
