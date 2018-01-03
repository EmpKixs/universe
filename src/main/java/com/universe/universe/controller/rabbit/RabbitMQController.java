/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.controller.rabbit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangbing
 * @version 1.0, 2018/1/3
 */
@RestController
@RequestMapping("/rabbitmq")
@Api(value = "/rabbitmq", description = "RabbitMQ整合测试")
public class RabbitMQController {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQController.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RequestMapping(value = "send", method = RequestMethod.POST)
    @ApiOperation(value = "发出消息", notes = "发出消息")
    public String sendMsg(
            @ApiParam(name = "msg", value = "消息内容")
            @RequestParam("msg") String msg) {
        LOG.info("then send the msg:" + msg);
        // rabbitTemplate.convertAndSend(msg);
        rabbitTemplate.convertAndSend("amq.direct", "spring-boot-msg", msg);
        LOG.info("msg send success!");

        return "msg send success!";
    }
}
