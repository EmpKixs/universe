/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.controller.config;

import com.universe.universe.MineConfig;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
@RestController
@RequestMapping("/config")
@EnableConfigurationProperties({MineConfig.class})
@Api(value = "/config", description = "配置文件（*.properties）读取测试")
public class ConfigController {

    @Autowired
    private MineConfig mineConfig;

    @RequestMapping(value = "mine", method = RequestMethod.GET)
    @ApiOperation(value = "配置文件读取测试接口", notes = "配置文件读取测试接口")
    public String showMine() {
        return mineConfig.getGreeting() + " >>>>" + mineConfig.getName() + " >>>>" + mineConfig.getUuid() + " >>>>" + mineConfig.getMax();
    }
}
