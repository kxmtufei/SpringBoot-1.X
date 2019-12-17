/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Weapon;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 *
 *@author : wuch
 *@date: 2019/12/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao {

    @Resource
    WeaponMapper weaponMapper;
    @Test
    public void test1(){
//        weaponMapper.insert(new Weapon("剑","近战"));
//        weaponMapper.insert(new Weapon("刀","近战"));
//        weaponMapper.insert(new Weapon("暗器","远程"));
        Assert.assertEquals(3, weaponMapper.findAll().size());
//        weaponMapper.findAll().toString();
        weaponMapper.insert(new Weapon("2","2"));
        weaponMapper.delete(6);
    }

    @Test
    public void test2(){
//        weaponMapper.findList();
    }
}
