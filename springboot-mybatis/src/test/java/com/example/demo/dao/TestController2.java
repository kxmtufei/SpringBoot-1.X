/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.dao;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

/**
 *
 *@author : wuch
 *@date: 2019/12/5
 */
public class TestController2 extends DemoApplicationTests{
    /** mockMvc在父类已经完成初始化
    这里的super.mockMvc要写到@Test方法里面。因为初始化是在@Before中完成的，
     如果定义在成员变量则mockMvc其实在父类没有完成初始化为null，然后报空指针异常
     */
    @Test
    public void testController() throws Exception{
        //perform：执行一个RequestBuilder请求，会自动执行SpringMVC的流程并映射到相应的控制器执行处理
//        andExpect：添加ResultMatcher验证规则，验证控制器执行完成后结果是否正确（对返回的数据进行的判断）；
//        andDo：添加ResultHandler结果处理器，比如调试时打印结果到控制台（对返回的数据进行的判断）；
//        andReturn：最后返回相应的MvcResult；然后进行自定义验证/进行下一步的异步处理（对返回的数据进行的判断）；
//        contentType :设置数据的格式contentType :设置数据的格式
        String result = super.mockMvc.perform(
               MockMvcRequestBuilders.get("http://localhost:8080/list")//请求的url,请求的方法是post
                       .contentType(MediaType.APPLICATION_JSON_UTF8) //数据的格式
                       .accept(MediaType.APPLICATION_JSON_UTF8)
        )

                .andExpect(MockMvcResultMatchers.status().isOk())//状态码200
                .andDo(MockMvcResultHandlers.print()) //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符
        System.out.println(result);
    }
}
