package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="time")
public class Time {
    private int id;
    private String time;
    private Set<Customer_course> customer_courses;
    private Set<Employee> employees;
    private Course course;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public String getTime() {
        return time;
    }

    @ManyToOne
    public Set<Customer_course> getCustomer_courses() {
        return customer_courses;
    }

    public void setCustomer_courses(Set<Customer_course> customer_courses) {
        this.customer_courses = customer_courses;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="courseId")
    public Course getCourse() {
        return course;
    }

    public void setTime(String time) {

        this.time = time;
    }
}
