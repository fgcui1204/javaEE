package com.tw.entity;

import javax.persistence.*;

@Entity
@Table(name="employees")
public class Employee {
    private int id;
    private String name;
    private String role;
    private String sex;
    private String mail;
    private int age;

    public Employee(int id, String name, String role, String sex, String mail, int age) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
    }

    public Employee(String name, String role, String sex, String mail, int age) {
        this.name = name;
        this.role = role;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
    }

    public Employee() {
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name="sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Column(name="mail")
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Column(name="age")
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
