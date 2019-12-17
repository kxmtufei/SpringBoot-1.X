/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.Goods;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

/**
 *  使用MyBatis-plus 继承BaseMapper<T>
 *@author : wuch
 *@date: 2019/12/17
 */
public interface GoodsMapper extends BaseMapper<Goods>{
    //根据goodsId得到商品
    @Select("SELECT * FROM t_goods WHERE gid=#{gid}")
    @Results({
            @Result(id = true,column = "gid",property = "gid"),
            @Result(column = "name",property = "name"),
            @Result(column = "price",property = "price"),
            @Result(column = "gid",property = "orderList",
                    many = @Many(select = "com.example.demo.dao.OrderMapper.getAllOrderByGoodsId",//多对多
                            fetchType = FetchType.LAZY))
    })
    Goods getGoodsById(Integer gid);
}
