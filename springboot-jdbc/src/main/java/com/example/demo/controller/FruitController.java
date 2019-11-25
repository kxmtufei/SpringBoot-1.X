/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.example.demo.bean.Fruit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.IFruitService;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 *  构建一组restful api来展示
 *@author : wuch
 *@date: 2019/11/25
 */
@RestController
@RequestMapping("/fruit")
public class FruitController {

    @Autowired
    IFruitService fruitService;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postFruit(@RequestParam(value = "name")String name,@RequestParam(value = "price") double price){
        Fruit fruit = new Fruit(name, price);
        if (fruitService.add(fruit)>0){
            return "上架成功：" + name + "-->" + price;
        }else {
            return "上架失败：" + name + "-->" + price;
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putFruit(@PathVariable("id")int id, @RequestParam(value = "name",required = true)String name,
                           @RequestParam("price")double price){
        Fruit fruit = fruitService.findFruitById(id);
        if (null != fruit){
            String oldName =  fruit.getName();
            double oldPrice = fruit.getPrice();
            fruit.setName(name);
            fruit.setPrice(price);
            if (fruitService.update(fruit)>0){
                return "更新成功：" + oldName + "-->" + fruit.getName() + ", "+ oldPrice + "-->" + fruit.getPrice();
            }else {
                return "更新信息失败-->" + oldName;
            }
        }
        return "没有指定编号："+ id + " 的水果";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteFruit(@PathVariable("id")int id){
        if (fruitService.delete(id)>0){
            return "下架成功";
        }else {
            return "下架失败";
        }
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public String getAllFruit(){
        return JSONUtils.toJSONString(fruitService.findAll());
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String getFruitByCon(@RequestParam("id")int id, @RequestParam("name")String name,
                                @RequestParam("price")double price){
        HashMap<String,Object> params = new HashMap<>();
        params.put("id", id);
        params.put("name", name);
        params.put("price", price);
        List<Fruit> fruits = fruitService.findFruitsByCon(params);
        return JSONUtils.toJSONString(fruits);
    }
}
