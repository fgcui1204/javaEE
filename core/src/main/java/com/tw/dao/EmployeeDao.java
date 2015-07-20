package com.tw.dao;

import com.tw.entity.Employee;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    public void addEmployee(Employee employee){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
}
