/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Weapon;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/29
 */
public interface WeaponMapper{

    @Select("SELECT * FROM t_weapon")
    @Results({
//            @Result(property = "userSex",  column = "user_sex", javaType = UserSexEnum.class),
            @Result(property = "type", column = "type_name")
    })
    List<Weapon> findAll();

    @Select("SELECT * FROM t_weapon  WHERE id = #{id}")
    @Results({
            @Result(property = "type", column = "type_name")
    })
    Weapon findOne(Integer id);


}
