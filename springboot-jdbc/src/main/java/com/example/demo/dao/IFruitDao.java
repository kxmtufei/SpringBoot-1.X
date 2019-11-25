/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Fruit;

import java.util.HashMap;
import java.util.List;

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
}
