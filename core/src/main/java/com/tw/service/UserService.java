package com.tw.service;

import com.tw.entity.User;
import com.tw.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUserList() {
        return userDao.getUserList();
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }

    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    public User getUser(int id) {
        return userDao.getUser(id);
    }

    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    public User login(String name, String password){
        return userDao.login(name, password);
    }

    public int getUserId(String name){
        return userDao.getUserId(name);
    }
    }