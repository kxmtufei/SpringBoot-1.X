/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao.impl;

<<<<<<< HEAD
import com.alibaba.druid.sql.PagerUtils;
import com.alibaba.druid.util.JdbcConstants;
import com.example.demo.bean.Fruit;
import com.example.demo.bean.PageBean;
import com.example.demo.dao.IFruitDao;
import com.example.demo.util.PageUtil;
=======
import com.example.demo.bean.Fruit;
import com.example.demo.dao.IFruitDao;
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
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

<<<<<<< HEAD
    @Autowired
    private PageUtil pageUtil;

=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
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
<<<<<<< HEAD
            sql.append(" and id=:id ");
        }
        if (map.containsKey("name") && !ObjectUtils.isEmpty(map.get("name"))){
            sql.append(" and name like:name ");
        }
        if (map.containsKey("price") && !ObjectUtils.isEmpty(map.get("price"))){
            sql.append(" and price in(:price)");
=======
            sql.append("and id=:id");
        }
        if (map.containsKey("name") && !ObjectUtils.isEmpty(map.get("name"))){
            sql.append("and name like:name");
        }
        if (map.containsKey("price") && !ObjectUtils.isEmpty(map.get("price"))){
            sql.append("and price in(:ids)");
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
        }
        List<Fruit> fruits = namedParameterJdbcTemplate.query(sql.toString(), map, new BeanPropertyRowMapper<>(Fruit.class));
        if (null!=fruits && fruits.size()>0){
            return fruits;
        }else {
            return null;
        }
    }
<<<<<<< HEAD

    @Override
    public PageBean<Fruit> findByPage(Map map, int pageNum, int pageSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fruit where 1=1 ");
        if (map.containsKey("id") && !ObjectUtils.isEmpty(map.get("id"))){
            sql.append(" and id>:id ");
        }
        PageBean<Fruit> fruitPage = pageUtil.findByPage(sql.toString(), map, new BeanPropertyRowMapper<>(Fruit.class), pageNum, pageSize);
        return fruitPage;
    }

    @Override
    public PageBean<Fruit> findByPage2(Map map, int pageNum, int pageSize) {
        StringBuilder sql = new StringBuilder();
        sql.append("select * from fruit where 1=1 ");
        if (map.containsKey("id") && !ObjectUtils.isEmpty(map.get("id"))){
            sql.append(" and id>:id ");
        }
        String finalSql = sql.toString();
        // 生成获取记录数的sql
        String rowsSql = PagerUtils.count(finalSql, JdbcConstants.MYSQL);
        int rows = namedParameterJdbcTemplate.queryForObject(rowsSql, map, Integer.class);
        //总页数
        int totalPage = rows%pageSize == 0 ? 0 : rows/pageSize + 1;
        // 生成分页取数的sql
        String pageSql = PagerUtils.limit(finalSql, JdbcConstants.MYSQL, (pageNum-1)*pageSize, pageSize);
        List<Fruit> content = namedParameterJdbcTemplate.query(pageSql, map, new BeanPropertyRowMapper<>(Fruit.class));
        return PageBean.<Fruit>builder()
                .content(content)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalPage(totalPage)
                .rows(rows)
                .build();
    }
=======
>>>>>>> d8eb7c9672d99ac9f762bfc18c50afa4a05444a0
}
