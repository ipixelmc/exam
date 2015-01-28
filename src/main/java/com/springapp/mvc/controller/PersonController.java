package com.springapp.mvc.controller;

import com.google.gson.Gson;
import com.springapp.mvc.model.Person;
import com.springapp.mvc.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView printWelcome(ModelMap model) {
        ModelAndView modelAndView = new ModelAndView("/person/index");
        List<Person> list = personService.findAll();
        Gson gson = new Gson();
        modelAndView.addObject("list", gson.toJson(list));
        return modelAndView;
    }

    @RequestMapping(value = "/loadList.json", method = RequestMethod.GET)
    @ResponseBody
    public String loadList() {

        List<Person> list = personService.findAll();
        for (Person p : list) {
            System.out.println(p.toString());
        }
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping(value = "/findPerson.json", method = RequestMethod.GET)
    @ResponseBody
    public String findPerson(@RequestParam(required = false) Integer id) {

        if (id != null) {
            Person p = personService.findById(id);
            Gson gson = new Gson();
            return gson.toJson(p);
        }
        return "";
    }

    @RequestMapping(value = "/findPersonName.json", method = RequestMethod.GET)
    @ResponseBody
    public String findPersonByName(@RequestParam String name) {
        List<Person> pList;
        if (name != null && name.trim().equals("")) {
            pList = personService.findAll();
        } else {
            pList = personService.findByStockCode(name);
        }


        Gson gson = new Gson();
        return gson.toJson(pList);

    }


    @RequestMapping(value = "/upsert.json", method = RequestMethod.GET)
    @ResponseBody
    public String upsertPerson(@RequestParam(required = false) Integer id,
                               @RequestParam String name,
                               @RequestParam String address,
                               @RequestParam String age,
                               @RequestParam(required = false) String idIdentification,
                               @RequestParam(required = false) String profession,
                               @RequestParam(required = false) String school,
                               @RequestParam(required = false) String phone,
                               @RequestParam Integer gender
    ) {
        Person p = new Person();
        if (id != null) {
            p = personService.findById(id);
        }
        p.setAddress(address);
        p.setName(name);
        p.setAge(age);
        p.setIdIdentification(idIdentification);
        p.setProfession(profession);
        p.setSchool(school);
        p.setPhone(phone);
        p.setGender(gender);

        try {
            if (id != null) {
                personService.update(p);
            } else {
                personService.save(p);
            }
            return "El registro ha sido guardado";
        } catch (Exception e) {
            return "Ha ocurrido un error al guardar el registro";
        }
    }

    @RequestMapping(value = "/delete.json", method = RequestMethod.GET)
    @ResponseBody
    public String deletePerson(@RequestParam Integer id) {

        Person p = personService.findById(id);
        try {
            personService.delete(p);
            return "Se ha eliminado el registro";
        } catch (Exception e) {
            return "Ha ocurrido un error al eliminar el registro";
        }

    }
}