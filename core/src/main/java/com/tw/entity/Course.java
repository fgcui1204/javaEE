package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    private int id;
    private String name;
    private String time;
    private Employee employee;
    private Set<Customer> customers;

    public Course() {
    }

    public Course(int id, String name, String time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }

    public Course(int id, String name, String time, Employee employee) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.employee = employee;
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

    @Column(name="time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @OneToOne
    @JoinColumn(name="coachId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @ManyToMany(mappedBy = "courses")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }
}
