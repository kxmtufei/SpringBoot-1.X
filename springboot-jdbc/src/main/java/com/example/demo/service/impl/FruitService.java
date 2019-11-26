/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.service.impl;

import com.example.demo.bean.Fruit;
<<<<<<< HEAD
import com.example.demo.bean.PageBean;
=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
import com.example.demo.dao.IFruitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.IFruitService;

import java.util.HashMap;
import java.util.List;
<<<<<<< HEAD
import java.util.Map;
=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0

/**
 *
 *@author : wuch
 *@date: 2019/11/25
 */
@Service
public class FruitService implements IFruitService {

    @Autowired
    IFruitDao fruitDao;

    @Override
    public int add(Fruit fruit) {
        return fruitDao.add(fruit);
    }

    @Override
    public int update(Fruit fruit) {
        return fruitDao.update(fruit);
    }

    @Override
    public int delete(int id) {
        return fruitDao.delete(id);
    }

    @Override
    public Fruit findFruitById(int id) {
        return fruitDao.findFruitById(id);
    }

    @Override
    public List<Fruit> findAll() {
        return fruitDao.findAll();
    }

    @Override
    public List<Fruit> findFruitsByCon(HashMap<String, Object> map) {
        return fruitDao.findFruitsByCon(map);
    }
<<<<<<< HEAD

    @Override
    public PageBean<Fruit> findByPage(Map map, int pageNum, int pageSize) {
        //自定义分页
//        return fruitDao.findByPage(map, pageNum, pageSize);
        //druid分页
        return fruitDao.findByPage2(map, pageNum, pageSize);
    }
=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
}
