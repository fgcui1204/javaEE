package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="customers")
public class Customer {
    private int id;
    private String name;
    private String telphone;
    private Set<Course> courses;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    @Column(name = "telphone")
    public String getTelphone() {
        return telphone;
    }

    @ManyToMany
    @JoinTable(name="customer_course", joinColumns = {@JoinColumn(name="customerId")}, inverseJoinColumns = {@JoinColumn(name="courseId")})
    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }
}
