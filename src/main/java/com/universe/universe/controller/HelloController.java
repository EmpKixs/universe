/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author wangbing
 * @version 1.0, 2017/12/29
 */
@RestController
@RequestMapping("/hello")
@Api(value = "/hello", description = "Hello Spring Boot")
public class HelloController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "问候语接口", notes = "问候语接口，来自Spring Boot的问候")
    public String index() {
        return "Greetings from Spring Boot!" + new Date().toString();
    }
}
