package com.springapp.mvc.service;

import com.springapp.mvc.model.Person;

import java.util.List;

/**
 * Created by hakd on 27/01/2015.
 */
public interface PersonService {
    void save(Person person);
    void update(Person person);
    void delete(Person person);
    List<Person> findByStockCode(String name);
    List<Person> findAll();

    Person findById(Integer id);

    void upsert(Person p);
}
