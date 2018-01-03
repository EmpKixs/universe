/*
 * Copyright (c) 2016 ywmj.com. All Rights Reserved.
 */
package com.universe.universe.dao;

import com.universe.universe.domain.Person;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wangbing
 * @version 1.0, 2017/12/29
 */
@Repository
public interface PersonDao {

    void save(@Param("person") Person person);

    //@Select("SELECT * FROM person")
    List<Person> findAll();
}
