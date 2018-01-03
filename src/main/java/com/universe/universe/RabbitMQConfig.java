/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
//@Configuration
public class RabbitMQConfig {

    //@Bean
    public Queue queue() {
        return new Queue("spring-boot-msg");
    }
}
