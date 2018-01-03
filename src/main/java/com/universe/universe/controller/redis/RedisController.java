/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.controller.redis;

import com.universe.universe.domain.Person;
import com.universe.universe.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
@RestController
@RequestMapping("/redis")
@Api(value = "/redis", description = "Redis整合测试")
public class RedisController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.POST)
    @ApiOperation(value = "添加并缓存一条数据到Redis", notes = "添加并缓存一条数据到Redis")
    public String saveAndCachePerson(
            @ApiParam(name = "name", value = "姓名")
            @RequestParam(value = "name") String name,
            @ApiParam(name = "age", value = "年龄")
            @RequestParam(value = "age") Integer age) {
        System.out.println("save a new person!");
        return personService.saveAndCacheByPara(name, age);
    }

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    @ApiOperation(value = "获取缓存的数据记录", notes = "获取缓存的数据记录")
    public String getCachePerson(
            @ApiParam(name = "id", value = "记录id")
            @RequestParam(value = "id") Long id) {
        return personService.getCachePerson(id);
    }
}
