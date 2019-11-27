/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.bean.Boss;
import com.example.demo.dao.BossDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/11/27
 */
@RestController
@RequestMapping("/boss")
public class BossController {
    @Autowired
    BossDao bossDao;

    @GetMapping("/list")
    public String findAll(){
        return JSON.toJSONString(bossDao.findAll(), SerializerFeature.PrettyFormat);
    }

    @GetMapping("/page")
    public String page(){
        int page=0,size=2;
        Sort sort = new Sort(Sort.Direction.ASC, "id");
        Pageable pageable = new PageRequest(page, size, sort);
        Page<Boss> pageBoss = bossDao.findAll(pageable);
        return JSON.toJSONString(pageBoss.getContent(),SerializerFeature.PrettyFormat) + "总记录数：" + pageBoss.getTotalElements() + " ,总页数:" + pageBoss.getTotalPages();
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable(value = "id")Integer id){
        Boss boss = bossDao.getOne(id);
        return boss.toString();
    }

    @PostMapping("/add")
    public String addBoss(@RequestParam(name = "name")String name, @RequestParam(value = "brand")String brand,
                          @RequestParam(name = "assets")BigDecimal assets){
        Boss boss = new Boss();
        boss.setName(name);
        boss.setBrand(brand);
        boss.setAssets(assets);
        Boss boss1 = bossDao.save(boss);
        return "招募成功：" + JSON.toJSONString(boss1);
    }

    @PutMapping("/update")
    public String updateBoss(@RequestParam(name = "id",required = true)Integer id, @RequestParam(name = "name",required = true) String name,
                             @RequestParam(name = "brand")String brand, @RequestParam(value = "assets") BigDecimal assets){
        Boss boss = new Boss();
        boss.setId(id);
        boss.setName(name);
        if (!StringUtils.isEmpty(brand)){
            boss.setBrand(brand);
        }
        if (!StringUtils.isEmpty(assets)){
            boss.setAssets(assets);
        }
        Boss boss1 = bossDao.saveAndFlush(boss);
        return "更新成功：" + JSON.toJSONString(boss1);
    }

    @DeleteMapping("/{id}")
    public String deleteBoss(@PathVariable(value = "id")Integer id){
        if (!bossDao.exists(id)){
            return "没有对应的编号的数据";
        }
        bossDao.delete(id);
        return "炒鱿鱼，编号：" + id;
    }


}
