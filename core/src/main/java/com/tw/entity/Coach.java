package com.tw.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coach {
    @Id
    private int id;
    private String name;
    private String role;
    private String mail;

    public Coach(int id, String name, String role, String mail) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.mail = mail;
    }

    public Coach(String name, String role, String mail) {
        this.name = name;
        this.role = role;
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}
