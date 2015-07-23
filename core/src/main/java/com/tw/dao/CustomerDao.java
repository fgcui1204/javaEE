package com.tw.dao;

import com.tw.entity.Customer;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {

    public List<Customer> getCustomers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Customer> list = session.createQuery("from Customer").list();
        session.close();
        return list;
    }

    public void create(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(customer);
        transaction.commit();
        session.close();
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Customer customer = (Customer)session.get(Customer.class, id);
        session.delete(customer);
        transaction.commit();
        session.close();
    }

    public Customer getCustomerById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Customer customer = (Customer)session.get(Customer.class, id);
        session.close();
        return customer;
    }

    public void update(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customer);
        transaction.commit();
        session.close();
    }
}
