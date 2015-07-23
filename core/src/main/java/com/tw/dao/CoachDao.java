package com.tw.dao;

import com.tw.entity.Coach;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoachDao {
    public List<Coach> getCoachList(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Coach> coachList = session.createQuery("select new Coach(u.id, u.name, e.role, u.mail) from User as u, Employee as e where u.id=e.user.id").list();

        return coachList;
    }

//    public void deleteCoach(int id) {
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        Transaction transaction = session.beginTransaction();
//        User user = (User)session.get(User.class, id);
//        Employee employee = (Employee)session.createQuery("from Employee where userId="+id).list().get(0);
//        employee.setUser(null);
//        session.delete(user);
//        transaction.commit();
//        session.close();
//    }
}
