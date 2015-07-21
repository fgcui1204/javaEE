package com.tw.controller;


import com.tw.service.CoachService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CoachController {
    @Autowired
    private CoachService coachService;

    @RequestMapping(value = "/coaches", method = RequestMethod.GET)
    public ModelAndView getCoachList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("coachList");
        modelAndView.addObject("coachList", coachService.getCoachList());
        return modelAndView;
    }
}
