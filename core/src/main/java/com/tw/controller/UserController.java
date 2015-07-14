package com.tw.controller;

import com.tw.bean.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userManagement");
        modelAndView.addObject("userList", userService.getUserList());
        return modelAndView;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public ModelAndView getUser(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user",userService.getUser(id));
        return modelAndView;
    }

    @RequestMapping(value = "/users/put", method = RequestMethod.POST)
    public String updateUser(@RequestParam int id, @RequestParam String name,@RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        User user = new User(id, name,sex, mail,age);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/post", method = RequestMethod.POST)
    public String addUser(@RequestParam String name,@RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        User user = new User(name,sex, mail,age);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public ModelAndView login(HttpServletRequest request, @RequestParam String name, @RequestParam String password){

        User user = userService.login(name, password);
        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.addObject("message", "用户名/密码错误");
            modelAndView.setViewName("login");
            return modelAndView;
        }else {

            request.getSession().setAttribute("user", user);
            System.out.println(request.getSession().getAttribute("name") + "---------");
            return new ModelAndView("redirect:/users");
        }
    }

}
