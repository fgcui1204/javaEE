package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.bean.User;
import com.tw.service.UserService;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        UserService userService = new UserService();
        List<User> userList = userService.getUserList();
        req.setAttribute("userList", userList);

        req.getRequestDispatcher("userManagement.jsp").forward(req, res);
        
    }
}