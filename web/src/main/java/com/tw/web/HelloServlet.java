package com.tw.web;

import java.io.*;
import java.util.List;
import javax.servlet.http.*;
import javax.servlet.*;

import com.tw.bean.User;
import com.tw.core.Service;

public class HelloServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Service service = new Service();
        List<User> userList = service.getUserList();
        req.setAttribute("userList", userList);

        req.getRequestDispatcher("userManagement.jsp").forward(req, res);

//        PrintWriter out = res.getWriter();
//
//        out.println(new Service().service());
//        out.close();
    }
}