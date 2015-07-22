package com.tw.controller;

import com.tw.entity.Schedule;
import com.tw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public ModelAndView getCoachList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scheduleList");
        modelAndView.addObject("scheduleList", scheduleService.getScheduleList());
        return modelAndView;
    }
}
