package com.tw.dao;

import com.tw.entity.Course;
import com.tw.entity.Schedule;
import com.tw.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {
    public List<Course> getCourseList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = session.createQuery("from Course where name != '私教'").list();
        session.close();
        return list;
    }

    public Course getCourseById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = session.createQuery("from Course where id=" + id).list();
        Course course = list.get(0);
        session.close();
        return course;
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = (Course)session.get(Course.class, id);
        session.delete(course);
        transaction.commit();
        session.close();
    }

    public void create(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
    }

    public void updateCourse(Course course) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
    }

    public List<Course> getUnArrangeSchedule(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Course> list = session.createQuery("select new Course(c.id, c.name, c.description) from Course c, Schedule s where c.id != s.course.id").list();
        for(Course course: list){
            System.out.println(course.getId()+"-------------");
        }
        session.close();
        return list;

    }
}
