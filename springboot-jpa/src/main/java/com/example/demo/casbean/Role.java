/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.casbean;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/28
 */
@Data
@Builder
@Entity
@Table(name = "t_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    private String name; // 角色名称

    @ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "t_employee_role", joinColumns = { @JoinColumn(name = "role_id") }, inverseJoinColumns = {
            @JoinColumn(name = "employee_id") })
    private List<Employee> employees; // 拥有角色的员工
}
