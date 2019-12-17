/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 *  接收者
 *@author : wuch
 *@date: 2019/12/17
 */
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch){
        this.latch = latch;
    }

    public void receiveMsg(String msg){
        LOGGER.info("Receive < {} >", msg);
        latch.countDown();
    }
}
