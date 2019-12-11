/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.controller;

import com.example.demo.bean.Weapon;
import com.example.demo.service.WeaponService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *@author : wuch
 *@date: 2019/12/2
 */
@Controller
@Slf4j
public class WeaponController {
    private static final String UPLOAD_BASE = System.getProperty("user.dir") + File.separator + "springboot-mybatis" +
            File.separator + "src/main/resources/public/";
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

    @GetMapping("/delete")
    @ResponseBody
    public boolean deleteById(Integer id){
        int result = service.delete(id);
        if(result>0){
            return true;
        }
        return false;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Weapon> findAll(Model model){
        List<Weapon> weapons = service.findAll();
        //加入图片地址
        for (Weapon weapon : weapons) {
            String url = "/weapon/" + weapon.getId() + ".jpg";
            weapon.setImgUrl(url);
        }
//        model.addAttribute("weapons", weapons);
            return weapons;
    }

    @PostMapping(value = "/add")
    @ResponseBody
    public Map addOne(HttpServletRequest request, @RequestParam("file") MultipartFile file, Weapon weapon){
        Map<String,Object> result = new HashMap<>(2);
        int add = service.add(weapon);
        String newName = uplodaFile(file, weapon);
        result.put("rows", add);
        result.put("impUrl", "/weapon/" + newName);
        return result;
    }

    @PostMapping(value = "/update")
    @ResponseBody
    public Map updateOne(HttpServletRequest request, @RequestParam("file") MultipartFile file, Weapon weapon){
        Map<String,Object> result = new HashMap<>(2);
        int update = service.update(weapon);
        String newName = uplodaFile(file, weapon);
        result.put("rows", update);
        result.put("impUrl", "/weapon/" + newName);
        return result;
    }

    private String uplodaFile(@RequestParam("file") MultipartFile file, Weapon weapon) {
        String newName = "";
        if (null == file){
            log.warn("上传图片为空");
        }else {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
            //编号
            Weapon one = service.findOneName(weapon.getType());
            newName = one.getId() + suffix;
            Path path = Paths.get(UPLOAD_BASE, newName);
            try {
                if (!Files.exists(path.getParent())){
                    Files.createDirectories(path.getParent());
                }
                Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);//强制覆盖已存在的
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newName;
    }


    public static void main(String[] args) {
        ///D:/IdeaProjects/SpringBoot-1.X/springboot-mybatis/target/classes/
//        System.out.println(ClassUtils.getDefaultClassLoader().getResource("").getPath());
        //D:\IdeaProjects\SpringBoot-1.X
//        System.out.println(System.getProperty("user.dir"));
    }
}
