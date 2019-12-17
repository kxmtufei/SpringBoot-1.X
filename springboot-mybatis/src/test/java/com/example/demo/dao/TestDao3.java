/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Goods;
import com.example.demo.bean.Order;
import com.example.demo.bean.Weapon;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/12/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDao3{
    @Autowired
    private GoodsMapper dao;

    @Test
    public void daoTest(){
        Goods all = dao.getGoodsById(1);
        System.out.println(all);
    }

    @Test
    public void daoTest2(){
        List<Goods> all = dao.selectList(null);
        Assert.assertEquals(4, all.size());
        all.forEach(System.out::println);
    }
}
