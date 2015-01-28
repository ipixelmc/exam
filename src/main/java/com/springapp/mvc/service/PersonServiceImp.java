package com.springapp.mvc.service;

import com.springapp.mvc.model.Person;
import com.springapp.mvc.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonServiceImp implements PersonService {

    @Autowired
    PersonDao personDao;

    public void setStockDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public void save(Person person){
        personDao.save(person);
    }

    public void update(Person person){
        personDao.update(person);
    }

    public void delete(Person person){
        personDao.delete(person);
    }

    public List<Person> findByStockCode(String personName){
        return personDao.findByPersonName(personName);
    }

    public List<Person> findAll(){
        return personDao.findAll();
    }


    public Person findById(Integer id) {
        return personDao.findById(id);
    }

    @Override
    public void upsert(Person p) {
         personDao.upsert(p);
    }
}
