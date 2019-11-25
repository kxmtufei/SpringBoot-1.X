/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao.impl;

import com.example.demo.bean.Fruit;
import com.example.demo.dao.IFruitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.*;

/**
 *  sql中使用了in，那么通过?占位符来传参是不能解决问题的，直接拼接sql又会有sql注入的风险。
 *  这种情况下我们可以使用NamedParameterJdbcTemplate 来解决问题。
    NamedParameterJdbcTemplate支持具名参数
    PS:具名参数: SQL 按名称(以冒号开头)而不是按位置进行指定. 具名参数更易于维护, 也提升了可读性.
    具名参数由框架类在运行时用占位符取代
 *@author : wuch
 *@date: 2019/11/25
 */
@Repository
public class FruitDaoImpl implements IFruitDao {

    //一般jdbcTemplate基本可以满足我们的需求，我们可以通过?占位符来传参
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public int add(Fruit fruit) {
        int update = jdbcTemplate.update("insert into fruit(name,price) values(?,?)", fruit.getName(), fruit.getPrice());
        return update;
    }

    @Override
    public int update(Fruit fruit) {
        int update = jdbcTemplate.update("update fruit set name=?,price=? where id=?", fruit.getName(), fruit.getPrice(), fruit.getId());
        return update;
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update("delete from fruit where id=?", id);
    }

    @Override
    public Fruit findFruitById(int id) {
        List<Fruit> fruits = jdbcTemplate.query("select * from fruit where id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Fruit.class));
        if (null!=fruits && fruits.size()>0){
            return fruits.get(0);
        }else {
            return null;
        }
    }

    @Override
    public List<Fruit> findAll() {
        List<Fruit> fruits = jdbcTemplate.query("select * from fruit", new Object[]{}, new BeanPropertyRowMapper<>(Fruit.class));
        if (null!=fruits && fruits.size()>0){
            return fruits;
        }else {
            return null;
        }
    }

    @Override
    public List<Fruit> findFruitsByCon(HashMap<String,Object> map) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fruit where 1=1 ");
        if (map.containsKey("id") && !ObjectUtils.isEmpty(map.get("id"))){
            sql.append("and id=:id");
        }
        if (map.containsKey("name") && !ObjectUtils.isEmpty(map.get("name"))){
            sql.append("and name like:name");
        }
        if (map.containsKey("price") && !ObjectUtils.isEmpty(map.get("price"))){
            sql.append("and price in(:ids)");
        }
        List<Fruit> fruits = namedParameterJdbcTemplate.query(sql.toString(), map, new BeanPropertyRowMapper<>(Fruit.class));
        if (null!=fruits && fruits.size()>0){
            return fruits;
        }else {
            return null;
        }
    }
}
