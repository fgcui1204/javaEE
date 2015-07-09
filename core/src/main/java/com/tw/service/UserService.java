package com.tw.service;

import com.tw.bean.User;
import com.tw.dao.DbConnection;
import com.tw.dao.UserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {
    UserDao userDao = new UserDao();

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

    public int updateUser(User user) {
        return userDao.updateUser(user);
    }
    }