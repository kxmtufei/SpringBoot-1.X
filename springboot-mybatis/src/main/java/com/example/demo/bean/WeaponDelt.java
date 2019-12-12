/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *  兵器类 - 明细
 *@author : wuch
 *@date: 2019/12/12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeaponDelt {
    private Integer id;
    private Integer pid;
    private String name;
    private String skill;
    private Weapon weapon;

}
