package com.tw.bean;

import javax.persistence.*;

@Entity
@Table(name="employee")
public class Employee {
    private int id;
    private String role;
    private User user;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "role")
    public String getRole() {
        return role;
    }

    @OneToOne(mappedBy = "user")
    @JoinColumn(name="userId")
    public User getUser() {
        return user;
    }
}
