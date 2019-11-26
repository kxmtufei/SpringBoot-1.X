/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Fruit;
<<<<<<< HEAD
import com.example.demo.bean.PageBean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
=======

import java.util.HashMap;
import java.util.List;
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0

/**
 *
 *@author : wuch
 *@date: 2019/11/25
 */
public interface IFruitDao {
    int add(Fruit fruit);

    int update(Fruit fruit);

    int delete(int id);

    Fruit findFruitById(int id);

    List<Fruit> findAll();

    List<Fruit> findFruitsByCon(HashMap<String,Object> map);
<<<<<<< HEAD

    //自定义分页（mysql）
    PageBean<Fruit> findByPage(Map map, int pageNum, int pageSize);

    //Druid分页(PageUtils)-支持MySql、Oracle、DB2、SQL Server
    PageBean<Fruit> findByPage2(Map map, int pageNum, int pageSize);

=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
}
