package com.tw.controller;

import com.tw.entity.Course;
import com.tw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/courses", method = RequestMethod.GET)
    public ModelAndView getCoachList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("courseList");
        modelAndView.addObject("courseList", courseService.getCourseList());
        return modelAndView;
    }
}
