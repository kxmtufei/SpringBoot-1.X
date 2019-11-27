/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Boss;
import com.example.demo.dao.BossDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestJpa{
    @Autowired
    BossDao bossDao;

    /**
     * 测试默认方法 （JPA）
     */
    @Test
    public void test1(){
        //全部删除
//		bossDao.deleteAllInBatch(); //直接执行一条SQL，全部删除
//		bossDao.deleteAll();//先执行findAll,然后遍历删除
        //批量删除
//        List<Boss> b = new ArrayList<>();
//        b.add(Boss.builder().id(5).build());
//        b.add(Boss.builder().id(6).build());
//		bossDao.delete(b);//遍历删除
//        bossDao.deleteInBatch(b);//直接执行一条SQL，全部删除
        //批量插入
//        List<Boss> b = new ArrayList<>();
//        b.add(Boss.builder().id(5).name("王健林").brand("万达").assets(new BigDecimal(854.34)).build());
//        b.add(Boss.builder().id(6).name("雷军").brand("小米").assets(new BigDecimal(1434.34)).build());
//        bossDao.save(b); //一条条插入
        // Example 按例查询（QBE）是一种用户界面友好的查询技术。 它允许动态创建查询，并且不需要编写包含字段名称的查询
        //Probe: 含有对应字段的实例对象  ExampleMatcher携带有关如何匹配特定字段的详细信息，相当于匹配条件。Example：由Probe和ExampleMatcher组成，用于查询。
        Boss boss = new Boss();
        boss.setName("马");
//        Example<Boss> example = Example.of(boss);//ExampleMatcher 不传，默认全字符匹配-->相当于=
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", ExampleMatcher.GenericPropertyMatchers.startsWith())//模糊查询匹配开头，即 name%
                .withMatcher("name", match -> match.contains())//模糊查询，即 %name%, lamb写法
                .withIgnorePaths("id");//忽略字段，即不管id是什么值都不加入查询条件
        Example<Boss> example = Example.of(boss, matcher);
        System.out.println(bossDao.findAll(example  ).toString());
    }

    /**
     *  测试自定义方法
     */
    @Test
    public void test2(){
//        System.out.println(bossDao.findByBrand("小米"));;
//        System.out.println(bossDao.getByNameOrBrand("王健林", "京东"));
//        System.out.println(bossDao.countByAssets(new BigDecimal(342)));
//        System.out.println(bossDao.findByNameLike("%马%"));
//        System.out.println(bossDao.queryByIdGreaterThanEqualOrderByAssetsDesc(1));

//        System.out.println(bossDao.findByNameLike("%马%", new PageRequest(0,2, Sort.Direction.ASC, "id")).getContent());

//        System.out.println(bossDao.findFirstByOrderByAssetsDesc());
//        System.out.println(bossDao.findTopByOrderByAssetsAsc());
//        System.out.println(bossDao.queryFirst3ByIdGreaterThanEqual(1, new PageRequest(0,5)).getContent());
//        System.out.println(bossDao.findFirst2ByIdGreaterThanEqual(1, new Sort(Sort.Direction.ASC, "assets")));
//        System.out.println(bossDao.queryTop3ByIdGreaterThanEqual(1, new PageRequest(0,5)));

        //自定义部分
        System.out.println(bossDao.updateById("陈发树", "大润发", new BigDecimal(2012.33), 11));
//        bossDao.deleteById(12);
//        System.out.println(bossDao.findAllBoss());
    }
}
