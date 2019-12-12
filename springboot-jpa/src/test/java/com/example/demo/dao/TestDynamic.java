/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Boss;
import com.example.demo.bean.BossCarVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 *@author : wuch
 *@date: 2019/12/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestDynamic {

    @Autowired
    private DynamicQuery dynamicQuery;

    @Test
    public void initData(){
        dynamicQuery.save(Boss.builder().name("雷军").brand("小米").assets(new BigDecimal(1434.34)).build());
        dynamicQuery.save(Boss.builder().name("王健林").brand("万达").assets(new BigDecimal(854.34)).build());
    }

    @Test
    public void  find1(){
        String nativeSql = "select b.id,b.name ,c.cname,b.brand  from t_boss b left join t_car c on c.bid = b.id limit 0,1";
        List<Object[]> list = dynamicQuery.nativeQueryList(nativeSql, new Object[]{});
        System.out.println(list);
    }

    @Test
    public void  find2(){
        String nativeSql = "select b.id,b.name ,c.cname,b.brand  from t_boss b left join t_car c on c.bid = b.id limit 0,1";
        List<BossCarVo> list = dynamicQuery.nativeQueryListModel(BossCarVo.class, nativeSql, new Object[]{});
        System.out.println(list);
    }

    @Test
    public void  find3(){
        String nativeSql = "select b.id,b.name ,c.cname,b.brand  from t_boss b left join t_car c on c.bid = b.id limit 0,3";
        List<Map> list = dynamicQuery.nativeQueryListMap(nativeSql, new Object[]{});
        System.out.println(list);
    }
}
