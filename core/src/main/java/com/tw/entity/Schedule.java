package com.tw.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="time")
public class Schedule {
    private int id;
    private String day;
    private Course course;
    private Employee employee;

    public Schedule() {
    }

    public Schedule(String day, Course course, Employee employee) {
        this.day = day;
        this.course = course;
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

    @Column(name="day")
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId")
    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coachId")
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
