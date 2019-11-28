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
@Table(name = "t_dept")
public class Dept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 主键ID

    private String name; // 部门名称

    @OneToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "dept_id")
    /**
     * joinColumns 用来指定中间表中关联自己ID的字段 inverseJoinColumns 用来指定中间表中关联对方ID的字段
     */
    // @JoinTable(name = "tbl_employee_department", joinColumns = {
    // 		@JoinColumn(name = "department_id") }, inverseJoinColumns = { @JoinColumn(name = "employee_id") })
    private List<Employee> employees; // 部门员工

}
