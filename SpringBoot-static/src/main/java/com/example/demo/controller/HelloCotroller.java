/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *@author : wuch
 *@date: 2019/12/2
 */
@Controller
public class HelloCotroller {

    //未配置视图解析的前后缀
//    @RequestMapping("")
//    public String index(){
//        return "/index2.html";
//    }

    @RequestMapping("/index") //url
    public String index2(){
        return "index2";
    }
    @RequestMapping("")
    public String index(){
        return "index";
    }


}
