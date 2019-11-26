/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.util;

import com.example.demo.bean.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 *
 *@author : wuch
 *@date: 2019/11/26
 */
@Component
public class PageUtil {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    /**
     *  分页查询
     * @param sql
     * @param map 查询参数
     * @param rowMapper
     * @param pageNum 当前页
     * @param pageSize 每页大小
     * @param <T>
     * @return
     */
    public <T> PageBean<T> findByPage(String sql, Map<String,Object> map, RowMapper<T> rowMapper, int pageNum, int pageSize){
        if (pageNum <= 0){
            pageNum = 1;
        }
        if (pageSize <= 0){
            pageSize = 3;
        }
        //总记录数
        String rowsSql = "select count(*) from ("+ sql +") t_ ";
        int rows = namedParameterJdbcTemplate.queryForObject(rowsSql, map, Integer.class);
        if (rows == 0){
            return PageBean.<T>builder()
                    .content(null)
                    .pageNum(pageNum)
                    .pageSize(pageSize)
                    .totalPage(0)
                    .rows(0)
                    .build();
        }
        //总页数
        int totalPage = rows%pageSize == 0 ? 0 : rows/pageSize + 1;
        sql = sql + " limit " + (pageNum-1)*pageSize + "," + pageSize;
        List<T> content = namedParameterJdbcTemplate.query(sql, map, rowMapper);
        return PageBean.<T>builder()
                .content(content)
                .pageNum(pageNum)
                .pageSize(pageSize)
                .totalPage(totalPage)
                .rows(rows)
                .build();
    }
}
