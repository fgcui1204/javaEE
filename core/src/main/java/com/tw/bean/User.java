package com.tw.bean;

public class User {
    private int userId;
    private String name;
    private String sex;
    private String mail;
    private int age;

    public User() {
    }

    public User(int userId, String name, String sex, String mail, int age) {
        this.userId = userId;
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
    }

    public User(String name, String sex, String mail, int age) {
        this.name = name;
        this.sex = sex;
        this.mail = mail;
        this.age = age;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
