package com.tw.dao;

import com.tw.bean.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {


    public List<User> getUserList(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> userList;
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

    public User login(String userName, String password){
        Session session = HibernateUtil.getSessionFactory().openSession();
        String hql = "from User where name='"+userName+"' and password='"+password+"'";
        List<User> userList = session.createQuery(hql).list();
        session.close();
        if(userList.size() != 0){
            return userList.get(0);
        }
        return null;
    }
}
