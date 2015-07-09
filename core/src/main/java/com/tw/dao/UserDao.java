package com.tw.dao;

import com.tw.bean.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();

        Session session = HibernateUtil.getSessionFactory().openSession();
        userList = session.createQuery("from User").list();
        session.close();

        return userList;
    }

    public void addUser(User user){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void deleteUser(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        User user = (User)session.get(User.class,id);
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public User getUser(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();

        User user = (User)session.get(User.class,id);
        return user;
    }

    public void updateUser(User user){

        Session session = HibernateUtil.getSessionFactory().openSession();

        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }
}
