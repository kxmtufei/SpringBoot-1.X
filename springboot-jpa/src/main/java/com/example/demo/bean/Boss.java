/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 *  老总表
 *@author : wuch
 *@date: 2019/11/27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "t_boss")
public class Boss {
    @Id
    //默认的生成策略就是GenerationType.AUTO,所以使用此种策略时.可
    // 以显式的指定@GeneratedValue(strategy = GenerationType.AUTO)也可以直接@GeneratedValue
    @GeneratedValue
    private Integer id;

    @Column(length = 30, nullable = false)
    private String name;

    @Column(unique = true, length = 30 , nullable = false)
    private String brand;

    @Column(precision = 8, scale = 2) //位数，经度， 单位是亿
    private BigDecimal assets;
}
