package com.tw.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="courses")
public class Course {
    private int id;
    private String name;
    private Set<Customer> customers;
    private Set<Time> times;

    @Id
    @GeneratedValue
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

    @ManyToMany(mappedBy = "teachers")
    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @OneToMany(mappedBy = "time")
    public Set<Time> getTimes() {
        return times;
    }

    public void setTimes(Set<Time> times) {
        this.times = times;
    }
}
