/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  兵器类
 *@author : wuch
 *@date: 2019/11/29
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Weapon {
    private Integer id;
    private String type;
    private String range;
    private String sex;
    private String imgUrl;
    private List<WeaponDelt> deltList;
    public Weapon(String type, String range) {
        this.type = type;
        this.range = range;
    }
}
