/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.service;

import com.universe.universe.domain.Person;

import java.util.List;

/**
 * @author wangbing
 * @version 1.0, 2018/1/2
 */
public interface PersonService {

    List<Person> queryPerson();

    Person saveByParam(String name, Integer age);

    Person saveByObject(Person person);

    String saveAndCacheByPara(String name, Integer age);

    String getCachePerson(Long id);
}
