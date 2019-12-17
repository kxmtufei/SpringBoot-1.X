/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Order;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/12/17
 */
public interface OrderMapper {
    //根据商品的id，去查找所有相关的订单
    @Select("SELECT * FROM t_order WHERE oid in(SELECT oid FROM t_goods_order WHERE gid=#{gid})")
    @Results({@Result(id=true,column="oid",property="oid"),
            @Result(column="total",property="total"),
            @Result(column="buyer",property="buyer"),
            @Result(column="orderDate",property="orderDate")})
    public List<Order> getAllOrderByGoodsId(Integer gid);
}
