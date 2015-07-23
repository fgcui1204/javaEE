package com.tw.controller;

import com.tw.entity.Course;
import com.tw.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/courses/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        courseService.delete(id);
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/create", method = RequestMethod.GET)
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCourse");
        return modelAndView;
    }

    @RequestMapping(value = "/courses/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String name, @RequestParam String description){
        Course course = new Course(name, description);
        courseService.create(course);
        return new ModelAndView("redirect:/courses");
    }

    @RequestMapping(value = "/courses/update/{id}", method = RequestMethod.GET)
    public ModelAndView getSchedule(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateCourse");
        modelAndView.addObject("course", courseService.getCourse(id));
        return modelAndView;
    }

    @RequestMapping(value = "/courses/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam int id, @RequestParam String name, @RequestParam String description){
        Course course = new Course(id, name, description);
        courseService.updateCourse(course);
        return new ModelAndView("redirect:/courses");
    }
}
