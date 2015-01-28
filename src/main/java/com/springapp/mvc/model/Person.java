package com.springapp.mvc.model;

/**
 * Created by hakd on 27/01/2015.
 */
public class Person implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String name;
    private String address;
    private String age;
    private int gender;
    private String idIdentification;
    private String profession;
    private String school;
    private String phone;

    public Person() {
    }

    public Person(Integer id, String name, String address, String age, int gender, String idIdentification, String profession, String school, String phone) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.age = age;
        this.gender = gender;
        this.idIdentification = idIdentification;
        this.profession = profession;
        this.school = school;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getIdIdentification() {
        return idIdentification;
    }

    public void setIdIdentification(String idIdentification) {
        this.idIdentification = idIdentification;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age='" + age + '\'' +
                ", gender=" + gender +
                ", idIdentification='" + idIdentification + '\'' +
                ", profession='" + profession + '\'' +
                ", school='" + school + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}