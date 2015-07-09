package com.tw.dao;

import com.tw.bean.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    int result = 0;

    DbConnection dbConnection = new DbConnection();
    Connection connection = dbConnection.getConnection();
    Statement statement = null;//statement 用来执行sql语句

    public List<User> getUserList(){
        List<User> userList = new ArrayList<User>();

        try {
            statement = connection.createStatement();
            String sql = "select * from users";

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String mail = resultSet.getString("mail");
                int age = resultSet.getInt("age");

                User user = new User(id,name,sex,mail,age);
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public int addUser(User user){

        try {
            statement = connection.createStatement();
            String sql = "insert into users values (null,'"+user.getName()+"','"+user.getSex()+"','"+user.getMail()+"',"+user.getAge()+")";
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteUser(int id){

        try {
            statement = connection.createStatement();
            String sql = "delete from users where id="+id;
            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User getUser(int id){
        User user = new User();
        try {
            statement = connection.createStatement();
            String sql = "select * from users where id="+id;

            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String sex = resultSet.getString("sex");
                String mail = resultSet.getString("mail");
                int age = resultSet.getInt("age");

                user = new User(userId,name,sex,mail,age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public int updateUser(User user){

        try {
            statement = connection.createStatement();
            String sql = "update users set name='"+user.getName()+"',sex='"+user.getSex()+"',mail='"+user.getMail()+"',age="+user.getAge()+" where id="+user.getUserId();

            result = statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
