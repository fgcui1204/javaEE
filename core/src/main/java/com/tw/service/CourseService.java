package com.tw.service;

import com.tw.dao.CourseDao;
import com.tw.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseDao courseDao;

    public List<Course> getCourseList() {
        return courseDao.getCourseList();
    }

    public Course getCourseById(int id){
        return courseDao.getCourseById(id);
    }

    public void delete(int id) {
        courseDao.delete(id);
    }

    public void create(Course course) {
        courseDao.create(course);
    }

    public Course getCourse(int id) {
        return courseDao.getCourseById(id);
    }

    public void updateCourse(Course course) {
        courseDao.updateCourse(course);
    }
}
