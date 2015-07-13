package com.tw.controller;

import com.tw.bean.User;
import com.tw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


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
        return "redirect:/users/";
    }

}
