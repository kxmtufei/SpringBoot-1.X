/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 *   存储路径配置类
 *@author : wuch
 *@date: 2019/12/20
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * Folder location for storing files
     */
//    private String location = "upload-dir";
    private String location;

    public String getLocation(){
        return location;
    }

    public void setLocation(String location){
        this.location = location;
    }

}
