package com.tw.controller;

import com.tw.service.UserService;
import com.tw.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ParseMD5 parseMD5;

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

//    @RequestMapping(value = "/users/put", method = RequestMethod.POST)
//    public String updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String password, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){
//
//        String userPassword = password.equals(userService.getUser(id).getPassword())?password:parseMD5.parseStrToMd5L32(password);
//        User user = new User(id, name,sex, mail,age,userPassword);
//        userService.updateUser(user);
//        return "redirect:/users";
//    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }
//
//    @RequestMapping(value = "/users/post", method = RequestMethod.POST)
//    public String addUser(@RequestParam String name,@RequestParam String password, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){
//        String password_md5 = parseMD5.parseStrToMd5L32(password);
//        User user = new User(name, sex, mail, age, password_md5);
//        userService.addUser(user);
//        return "redirect:/users";
//    }


}
