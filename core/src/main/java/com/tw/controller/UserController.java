package com.tw.controller;

import com.tw.bean.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getUserList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("userManagement");
        modelAndView.addObject("userList", userService.getUserList());
        return modelAndView;
    }

    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    public ModelAndView getUser(@RequestParam int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateUser");
        modelAndView.addObject("user",userService.getUser(id));
        return modelAndView;
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@RequestParam int id, @RequestParam String name,@RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        User user = new User(id, name,sex, mail,age);
        userService.updateUser(user);
        return this.getUserList();
    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int id){
        userService.deleteUser(id);
        return this.getUserList();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addeUser(@RequestParam String name,@RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        User user = new User(name,sex, mail,age);
        userService.addUser(user);
        return this.getUserList();
    }

}
