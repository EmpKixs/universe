/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.service.impl;

import com.universe.universe.dao.PersonDao;
import com.universe.universe.domain.Person;
import com.universe.universe.service.PersonService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PersonServiceImpl implements PersonService {

    private static final String REDIS_PERSON_KEY = "redis.person.key:";

    @Resource
    private PersonDao personDao;

    @Resource
    private RedisTemplate<Object, Object> redisTemplate;

    @Override
    public List<Person> queryPerson() {
        return personDao.findAll();
    }

    @Override
    public Person saveByParam(String name, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personDao.save(person);
        return person;
    }

    @Override
    public Person saveByObject(Person person) {
        personDao.save(person);
        // int res = 1/0;
        return person;
    }

    @Override
    public String saveAndCacheByPara(String name, Integer age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);
        personDao.save(person);

        Map<String, String> personMap = new HashMap<>();
        personMap.put("id", person.getId().toString());
        personMap.put("name", person.getName());
        personMap.put("age", person.getAge().toString());

        redisTemplate.opsForHash().putAll(REDIS_PERSON_KEY + person.getId(), personMap);

        return "save and cache success: " + person.getId();
    }

    @Override
    public String getCachePerson(Long id) {
        Map<Object, Object> dataMap = redisTemplate.opsForHash().entries(REDIS_PERSON_KEY + id);
        if (CollectionUtils.isEmpty(dataMap)) {
            return "person(" + id + ")`s cache isn`t existed!";
        }

        return dataMap.get("name") + " is " + dataMap.get("age");
    }
}
