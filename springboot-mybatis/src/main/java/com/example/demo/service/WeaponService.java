/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.service;

import com.example.demo.bean.Weapon;
import com.example.demo.dao.WeaponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/12/2
 */
@Service
public class WeaponService {
    @Resource
    WeaponMapper weaponMapper;

    public int add(Weapon weapon){
        return weaponMapper.insert(weapon);
    }

    public int update(Weapon weapon){
        return weaponMapper.update(weapon);
    }

    public int delete(Integer id){
        return weaponMapper.delete(id);
    }

    public Weapon findOne(Integer id){
        return weaponMapper.findOne(id);
    }

    public List<Weapon> findAll(){
        return weaponMapper.findAll();
    }
}
