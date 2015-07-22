package com.tw.dao;

import com.tw.entity.Schedule;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
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
}
