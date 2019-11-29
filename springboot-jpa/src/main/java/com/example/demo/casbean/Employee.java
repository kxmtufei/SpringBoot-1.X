/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.casbean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 *  OneToOne关系映射（例：员工 ==》 住址）
 *  OneToMany 站在部门的角度，一个员工只能属于一个部门，但是一个部门可以包含有多个员工
 *  ManyToOne   站在员工的角度， 多个员工对应一个部门
 *  ManyToMany  员工与角色之间的关系，一个员工可以拥有多个角色，一个角色也可以属于多个员工，员工与角色之间就是多对多的关系。
 *  通常这种多对多关系都是通过创建中间表来进行关联处理
 *  员工
 *@author : wuch
 *@date: 2019/11/28
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_employee")
public class Employee  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = true, length = 30)
    private String name;

    @Column(name = "sex", columnDefinition = "varchar(2) DEFAULT '不详' COMMENT '性别'")
    private String sex;

    @Column(name = "birthday", nullable = true)
    private Timestamp birthday;

    @OneToOne(cascade ={CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE,CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.DETACH}, targetEntity = Dept.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    private Dept dept;

    /**
     * joinColumns 用来指定中间表中关联自己ID的字段 inverseJoinColumns 用来指定中间表中关联对方ID的字段
     */
//    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
//    @JoinTable(name = "t_employee_role",
//            joinColumns = {@JoinColumn(name = "employee_id")},inverseJoinColumns = {@JoinColumn(name = "role_id")})
//    private List<Role> roles;
}
