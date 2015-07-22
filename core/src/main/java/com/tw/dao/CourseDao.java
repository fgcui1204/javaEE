package com.tw.dao;

import com.tw.entity.Course;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    public List<Course> getCourseList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = session.createQuery("from Course").list();
        session.close();
        return list;
    }
}
