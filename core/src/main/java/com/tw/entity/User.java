package com.tw.entity;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {
    private int id;
    private String name;
    private String sex;
    private String mail;
    private int age;
    private String password;

    public User() {
    }

    public User(int id, String name, String sex, String mail, int age, String password) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
        this.password = password;
    }

    public User(String name, String sex, String mail, int age, String password) {
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
        this.password = password;
    }

    public User(String name, String sex, String mail, int age) {
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
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

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
