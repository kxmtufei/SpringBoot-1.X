/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import com.example.demo.bean.Weapon;
import com.example.demo.bean.WeaponDelt;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/29
 */
public interface WeaponDeltMapper {


    /**fetchType=FetchType.EAGER，如果是EAGER，那么表示取出这条数据时，它关联的数据也同时取出放入内存中,
     如果是LAZY那么取出这条数据时，它关联的数据并不取出来，在同一个session中，什么时候要用，
     就什么时候取(再次访问数据库)。但是，在session外，就不能再取了。用EAGER时，因为在内存里，所以在session外也可以取。*/
    @Results({@Result(column="id",property="id",id=true),//id=true，表示为主键
            @Result(column="pid",property="pid"),
            @Result(column="name",property="name"),
            @Result(column="skill",property="skill"),
            @Result(column="pid ",property="weapon",one=@One(select="com.example.demo.dao.WeaponMapper.findOne",
                    fetchType= FetchType.EAGER))
    })
    @Select("SELECT * FROM t_weapon_delt ")
    List<WeaponDelt> findList();



}
