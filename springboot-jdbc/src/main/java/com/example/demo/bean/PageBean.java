/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *  分页对象
 *@author : wuch
 *@date: 2019/11/26
 */

@Data //所有属性的get和set方法,toString 方法,hashCode方法,equals方法
@NoArgsConstructor
@AllArgsConstructor
@Builder
/**
 * 进行Builder方式初始化
 * UserInfo userInfo = UserInfo.builder()
    .name("zzl")
    .email("bgood@sina.com")
    .build();
 * 修改实体，要求实体上添加@Builder(toBuilder=true)
 * userInfo = userInfo.toBuilder()
    .name("OK")
    .email("zgood@sina.com")
    .build();
 */
//@Value //表示只公开getter，对所有属性的setter都封闭
public class PageBean<T> {

    private List<T> content; //内容

    private int pageSize; // 每页大小

    private int pageNum; //当前页数

    private int totalPage; //总页数

    private int rows; //总数量
}
