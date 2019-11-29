/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.casbean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 *  OneToOne关系映射
 *  地址
 *@author : wuch
 *@date: 2019/11/28
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//id

    @Column(name = "address", nullable = true, length = 100)
    private String address;//地址

    //如果不需要根据Address级联查询People，可以注释掉
    //  optional属性的默认值是true。optional 属性实际上指定关联类与被关联类的join 查询关系，
    // 如optional=false 时join 查询关系为inner join, optional=true 时join 查询关系为left join
    //  optional ：一个员工可以没有地址，但是一个地址不能没有对应员工，所以设置为false
    // 凡是双向关联，mapped必设，因为根本都没必要在2个表中都存在一个外键关联，在数据库中只要定义一边就可以了
    //  mappedBy : 表示为Employee的从表，由Employee来维护整个关系,
//    @OneToOne(mappedBy = "address", cascade = {CascadeType.MERGE, CascadeType.REFRESH}, optional = false)
//    private Employee employee;
}
