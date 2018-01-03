/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
@Component
public class SpringBootMQListener {

    private static final Logger LOG = LoggerFactory.getLogger(SpringBootMQListener.class);

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "spring-boot-msg", durable = "true"),
            exchange = @Exchange(value = "amq.direct", durable = "true"),
            key = "spring-boot-msg"))
    public void process(String msg) {
        LOG.info("receive a msg:" + msg);
    }
}
