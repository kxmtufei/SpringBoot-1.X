/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.casbean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

/**
 *  OneToOne关系映射
 *  地址
 *@author : wuch
 *@date: 2019/11/28
 */
@Data
@Builder
@Entity
@Table(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id

    @Column(name = "address", nullable = true, length = 100)
    private String address;//地址

    //如果不需要根据Address级联查询People，可以注释掉
    //optional属性的默认值是true。optional 属性实际上指定关联类与被关联类的join 查询关系，
    // 如optional=false 时join 查询关系为inner join, optional=true 时join 查询关系为left join
//    @OneToOne(mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//    private People people;
}
