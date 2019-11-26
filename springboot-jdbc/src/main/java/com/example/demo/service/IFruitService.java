/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.service;

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
public interface IFruitService {
    int add(Fruit fruit);

    int update(Fruit fruit);

    int delete(int id);

    Fruit findFruitById(int id);

    List<Fruit> findAll();

    List<Fruit> findFruitsByCon(HashMap<String, Object> map);
<<<<<<< HEAD

    PageBean<Fruit> findByPage(Map map, int pageNum, int pageSize);
=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
}
