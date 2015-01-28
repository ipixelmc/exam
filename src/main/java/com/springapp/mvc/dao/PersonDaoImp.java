package com.springapp.mvc.dao;

import com.springapp.mvc.model.Person;
import com.springapp.persistence.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("personDao")
public class PersonDaoImp implements PersonDao{

    public void save(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(person);
        if(!session.getTransaction().wasCommitted()){
            session.getTransaction().commit();
        }
    }

    public void update(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(person);
        if(!session.getTransaction().wasCommitted()){
            session.getTransaction().commit();
        }
    }

    public void delete(Person person){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.delete(person);
        if(!session.getTransaction().wasCommitted()){
            session.getTransaction().commit();
        }
    }

    public List<Person> findByPersonName(String name){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);
        String param = "%"+name+"%";
        cr.add(Restrictions.like("name",param));
        List<Person> lstP = cr.list();
        return lstP;
    }

    public List<Person> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);
        return   cr.list();
    }

    @Override
    public Person findById(Integer id) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(Person.class);
        cr.add(Restrictions.eq("id",id));
        return  (Person)cr.uniqueResult();
    }

    @Override
    public void upsert(Person p) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.saveOrUpdate(p);
        if(!session.getTransaction().wasCommitted()){
            session.getTransaction().commit();
        }
    }

}
