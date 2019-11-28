/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  自定义自己想要查询的实体
 *@author : wuch
 *@date: 2019/11/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BossCarVo {
    private Integer id;
    private String name;
    private String cname;
    private String brand;
}
