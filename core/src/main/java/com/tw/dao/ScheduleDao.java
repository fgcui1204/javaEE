package com.tw.dao;

import com.tw.entity.Schedule;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScheduleDao {
    public List<Schedule> getScheduleList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Schedule> list = session.createQuery("from Schedule").list();
        session.close();
        return list;
    }

    public void create(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(schedule);
        transaction.commit();
        session.close();
    }

    public void delete(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Schedule schedule = (Schedule)session.get(Schedule.class, id);
        session.delete(schedule);
        transaction.commit();
        session.close();
    }

    public Schedule getSchedule(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Schedule schedule = (Schedule)session.get(Schedule.class, id);
        session.close();
        return schedule;
    }

    public void update(Schedule schedule) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
//        Schedule schedule1 = this.getSchedule(schedule.getId());
        session.update(schedule);
        transaction.commit();
        session.close();
    }
}
