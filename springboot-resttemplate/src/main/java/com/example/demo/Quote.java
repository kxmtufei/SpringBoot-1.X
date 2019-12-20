/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *  创建一个类来接收需要的数据
 *@author : wuch
 *@date: 2019/12/20
 */
@JsonIgnoreProperties(ignoreUnknown = true)//忽略类中不存在的属性
public class Quote {
    private String type;
    private Value value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}

@JsonIgnoreProperties(ignoreUnknown = true)
class Value{
    private Long id;
    @JsonProperty("quote")
    private String str;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Value{" +
                "id=" + id +
                ", str='" + str + '\'' +
                '}';
    }
}