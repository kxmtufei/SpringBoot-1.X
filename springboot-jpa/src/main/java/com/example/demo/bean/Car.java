/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  Boss-座驾
 *@author : wuch
 *@date: 2019/11/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_car")
public class Car {
    @Id
    //默认的生成策略就是GenerationType.AUTO,所以使用此种策略时.可
    // 以显式的指定@GeneratedValue(strategy = GenerationType.AUTO)也可以直接@GeneratedValue
    @GeneratedValue
    private Integer id;

    @Column
    private Integer bid;

    @Column(name = "cname")
    private String name;

}
