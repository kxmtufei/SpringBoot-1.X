/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  商品
 *@author : wuch
 *@date: 2019/12/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("t_goods")
public class Goods {
    private int gid;
    private String name;
    private double price;
    private transient List<Order> orderList;
}
