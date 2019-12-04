/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import com.example.demo.bean.Weapon;
import com.example.demo.service.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 *
 *@author : wuch
 *@date: 2019/12/2
 */
@Controller
public class WeaponController {

    @Autowired
    WeaponService service;

    @GetMapping("")
    public String index(){
        return "index";
    }

    @GetMapping("index")
    public String index2(){
        return "index2";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Weapon findOne(@PathVariable(value = "id")Integer id){
        Weapon one = service.findOne(id);
        return one;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Weapon> findAll(Model model){
        List<Weapon> weapons = service.findAll();
//        model.addAttribute("weapons", weapons);
            return weapons;
    }
}
