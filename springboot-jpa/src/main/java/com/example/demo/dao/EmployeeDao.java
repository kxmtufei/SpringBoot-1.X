/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.casbean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 *@author : wuch
 *@date: 2019/11/28
 */
public interface EmployeeDao extends JpaRepository<Employee,Long>{


}
