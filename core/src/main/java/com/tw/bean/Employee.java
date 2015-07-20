package com.tw.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employee {
    private int id;
    private String role;
    private User user;

    public Employee() {
    }

    public Employee(String role, User user) {
        this.role = role;
        this.user = user;
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

    @OneToOne
    @JoinColumn(name="userId")
    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
