/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.web;

import com.example.demo.entity.PersonForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.validation.Valid;

/**
 *
 *@author : wuch
 *@date: 2019/12/23
 */
@Controller
public class WebController extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

    /**
     * showForm方法返回表单模板。它在方法签名中包含一个PersonForm，因此模板可以将表单属性与PersonForm关联起来
     * @param personForm
     * @return
     */
    @GetMapping("/")
    public String showForm(PersonForm personForm){
        return "form";
    }

    /**
     * 用@Valid标记的personForm对象，用于收集将要构建的表单中填写的属性。
     *  bindingResult对象，以便您可以测试和检索验证错误。
     * @param personForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            //测试错误，返回表单页
            return "form";
        }
        //通过，重定向到结果页
        return "results";
    }
}
