package com.springapp.mvc.dao;

import com.springapp.mvc.model.Person;

import java.util.List;

/**
 * Created by hakd on 27/01/2015.
 */
public interface PersonDao  {
    void save(Person stock);
    void update(Person stock);
    void delete(Person stock);
    List<Person>findByPersonName(String name);

    List<Person> findAll();

    Person findById(Integer id);

    void upsert(Person p);
}
