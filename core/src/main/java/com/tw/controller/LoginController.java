package com.tw.controller;

import com.tw.bean.User;
import com.tw.service.UserService;
import com.tw.util.ParseMD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by fgcui on 7/14/15.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private ParseMD5 parseMD5;

    @RequestMapping(value = "/users/session", method = RequestMethod.POST)
    public ModelAndView getSession(HttpServletRequest request, @RequestParam String name, @RequestParam String password){

        User user = userService.login(name, parseMD5.parseStrToMd5L32(password));
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
