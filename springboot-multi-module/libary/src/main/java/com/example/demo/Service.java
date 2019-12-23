/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo;

import org.springframework.stereotype.Component;

/**
 *
 *@author : wuch
 *@date: 2019/12/23
 */
@Component
public class Service {
    private final String message;

    public Service(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
