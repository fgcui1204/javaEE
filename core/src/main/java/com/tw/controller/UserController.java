package com.tw.controller;

import com.tw.bean.User;
import com.tw.service.UserService;
import com.tw.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sun.security.krb5.internal.crypto.DesCbcMd5EType;

import javax.servlet.http.HttpServletRequest;

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

    @RequestMapping(value = "/users/put", method = RequestMethod.POST)
    public String updateUser(@RequestParam int id, @RequestParam String name, @RequestParam String password, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){

        String userPassword = password.equals(userService.getUser(id).getPassword())?password:parseMD5.parseStrToMd5L32(password);
        User user = new User(id, name,sex, mail,age,userPassword);
        userService.updateUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id){
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/post", method = RequestMethod.POST)
    public String addUser(@RequestParam String name,@RequestParam String password, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        String password_md5 = parseMD5.parseStrToMd5L32(password);
        User user = new User(name, sex, mail, age, password_md5);
        userService.addUser(user);
        return "redirect:/users";
    }

    @RequestMapping(value = "/users/session", method = RequestMethod.POST)
    public ModelAndView getSession(HttpServletRequest request, @RequestParam String name, @RequestParam String password){

        User user = userService.login(name, password);
        ModelAndView modelAndView = new ModelAndView();
        if(user == null){
            modelAndView.addObject("message", "用户名/密码错误");
//            modelAndView.setViewName("login");
            return new ModelAndView("redirect:/users/login");
        }else {

            request.getSession().setAttribute("user", user);
            System.out.println(request.getSession().getAttribute("user") + "---------");
            return new ModelAndView("redirect:/users");
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
        return new ModelAndView("redirect:/users");
    }

}
