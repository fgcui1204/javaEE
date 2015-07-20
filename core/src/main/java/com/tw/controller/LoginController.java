package com.tw.controller;

import com.tw.entity.Employee;
import com.tw.entity.User;
import com.tw.service.EmployeeService;
import com.tw.service.UserService;
import com.tw.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by fgcui on 7/14/15.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private ParseMD5 parseMD5;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public ModelAndView getSession(HttpServletRequest request, HttpServletResponse response, @RequestParam String name, @RequestParam String password){

        User user = userService.login(name, parseMD5.parseStrToMd5L32(password));
        ModelAndView modelAndView = new ModelAndView();

        Cookie[] cookies = request.getCookies();
        String reqUrl = null;
        for (Cookie cookie: cookies){
            if ("reqUrl".equals(cookie.getName())){
                reqUrl = cookie.getValue();
            }
        }

        if(user == null){

            modelAndView.addObject("message", "用户名/密码错误");
            modelAndView.setViewName("login");
            return modelAndView;
        }else if(reqUrl == null) {

            request.getSession().setAttribute("user", user);
            return new ModelAndView("redirect:/users");
        }else {

            request.getSession().setAttribute("user", user);
            for (Cookie cookie: cookies){
                if ("reqUrl".equals(cookie.getName())){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/web/users");
                    response.addCookie(cookie);
                }
            }
            return new ModelAndView("redirect:/"+reqUrl);
        }
    }

    @RequestMapping(value = "/users/login",method = RequestMethod.GET)
    public ModelAndView login(){

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping(value = "/users/session/destroy", method = RequestMethod.GET)
    public ModelAndView destroySession(HttpServletRequest request){

        request.getSession().invalidate();

        return new ModelAndView("redirect:/users/login");
    }


    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerUser(@RequestParam String name,@RequestParam String password, @RequestParam String role, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        String password_md5 = parseMD5.parseStrToMd5L32(password);
        User user = new User(name, sex, mail, age, password_md5);
        userService.addUser(user);
        int userId = userService.getUserId(name);
        user.setId(userId);
        Employee employee = new Employee(role, user);
        employeeService.addEmployee(employee);
        return "redirect:/users";
    }

}
