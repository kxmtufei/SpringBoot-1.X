/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.mssage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

/**
 *  接收者
 *@author : wuch
 *@date: 2019/12/19
 */
@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMsg(String msg){
        ;LOGGER.warn("Receive < {} >", msg);
        latch.countDown();//接收到消息，计数器减一
    }

    public CountDownLatch getLatch(){
        return latch;
    }

}
