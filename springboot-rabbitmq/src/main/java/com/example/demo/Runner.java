/**
 * Copyright 厦门中软海晟信息技术有限公司 版权所有 违者必究 2019
 */
package com.example.demo;

import com.example.demo.mssage.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 *  发送消息
 *@author : wuch
 *@date: 2019/12/19
 */
@Component
public class Runner implements CommandLineRunner{
    private static final Logger LOGGER = LoggerFactory.getLogger(Runner.class);
    private final RabbitTemplate template;
    private final Receiver receiver;
    private final ConfigurableApplicationContext context;
    public Runner(Receiver receiver, RabbitTemplate template, ConfigurableApplicationContext context){
        this.receiver=receiver;
        this.template=template;
        this.context=context;
    }
    @Override
    public void run(String... strings) throws Exception {
        LOGGER.info("开始发送消息...");
        template.convertAndSend(SpringbootRabbitmqApplication.queueName,  "Hello from RabbitMQ!");
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
        context.close();
    }
}
