/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.storage;

/**
 *  自定义异常类
 *@author : wuch
 *@date: 2019/12/20
 */
public class StorageException extends RuntimeException{

    public StorageException(String message){
        super(message);
    }

    public StorageException(String message,Throwable cause){
        super(message, cause);
    }
}
