/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Weapon;
import org.apache.ibatis.annotations.*;

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
            @Result(property = "type", column = "type_name"),
            @Result(property = "range", column = "attack_range")
    })
    List<Weapon> findAll();

    @Select("SELECT * FROM t_weapon  WHERE id = #{id}")
    @Results({
            @Result(property = "type", column = "type_name"),
            @Result(property = "range", column = "attack_range")
    })
    Weapon findOne(Integer id);

    @Insert("INSERT INTO t_weapon(type_name,attack_range) VALUES(#{type},#{range})")
    int insert(Weapon weapon);

    @Update("UPDATE t_weapon SET type_name=#{type},attack_range=#{range} WHERE id=#{id}")
    int update(Weapon weapon);

    @Delete("DELETE FROM t_weapon WHERE id=#{id}")
    int delete(Integer id);

}
