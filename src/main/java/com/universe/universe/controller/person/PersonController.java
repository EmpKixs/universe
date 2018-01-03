/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.controller.person;

import com.universe.universe.domain.Person;
import com.universe.universe.service.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wangbing
 * @version 1.0, 2017/12/29
 */
@RestController
@RequestMapping("/person")
@Api(value = "/person", description = "MyBatis整合测试")
public class PersonController {

    @Resource
    private PersonService personService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "查询所有数据", notes = "查询所有数据")
    public List<Person> queryPerson() {
        return personService.queryPerson();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "以参数形式上传创建一条记录", notes = "以参数形式添加上传创建一条记录")
    public Person postPerson(
            @ApiParam(name = "name", value = "姓名")
            @RequestParam(value = "name") String name,
            @ApiParam(name = "age", value = "年龄")
            @RequestParam(value = "age") Integer age) {
        System.out.println("save a new person!");
        return personService.saveByParam(name, age);

    }

    @RequestMapping(value = "post-body", method = RequestMethod.POST)
    @ApiOperation(value = "以Body形式上传创建一条记录", notes = "以Body形式上传创建一条记录（PS：打开注释语句则测试Spring事务）")
    public Person postPersonBody(
            @ApiParam(name = "person", value = "Body信息")
            @RequestBody Person person) {
        System.out.println("save a new person!");

        return personService.saveByObject(person);
    }

    /*@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Person findPerson(@PathVariable("id") Long id) {
        return personDao.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Person updatePerson(
            @PathVariable("id") Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "age", required = true) Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setId(id);
        person.setAge(age);

        return personDao.saveAndFlush(person);
    }*/
}
