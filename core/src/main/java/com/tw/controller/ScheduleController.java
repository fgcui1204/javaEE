package com.tw.controller;

import com.tw.entity.Course;
import com.tw.entity.Employee;
import com.tw.entity.Schedule;
import com.tw.service.CourseService;
import com.tw.service.EmployeeService;
import com.tw.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class ScheduleController {
    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private CourseService courseService;

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public ModelAndView getCoachList() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("scheduleList");
        modelAndView.addObject("scheduleList", scheduleService.getScheduleList());
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/create", method = RequestMethod.GET)
    public ModelAndView createPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addSchedule");
        modelAndView.addObject("courses", courseService.getCourseList());
        System.out.println(courseService.getUnArrangeSchedule().size()+"============");
        modelAndView.addObject("coaches", employeeService.getCoaches());
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam int courseId, @RequestParam int coachId, @RequestParam String day) {
        Employee employee = employeeService.getEmployeeById(coachId);
        Course course = courseService.getCourseById(courseId);
        Schedule schedule = new Schedule(day, course, employee);
        scheduleService.create(schedule);
        return new ModelAndView("redirect:/schedules");
    }

    @RequestMapping(value = "/schedules/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id) {
        scheduleService.delete(id);
        return new ModelAndView("redirect:/schedules");
    }

    @RequestMapping(value = "/schedules/update/{id}", method = RequestMethod.GET)
    public ModelAndView getSchedule(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateSchedule");
        modelAndView.addObject("courses", courseService.getCourseList());
        modelAndView.addObject("coaches", employeeService.getCoaches());
        modelAndView.addObject("schedule", scheduleService.getSchedule(id));
        return modelAndView;
    }

    @RequestMapping(value = "/schedules/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam int scheduleId, @RequestParam int courseId, @RequestParam int coachId, @RequestParam String day) {
        Employee employee = employeeService.getEmployeeById(coachId);
        Course course = courseService.getCourseById(courseId);
        Schedule schedule = new Schedule(scheduleId, day, course, employee);
        scheduleService.update(schedule);
        return new ModelAndView("redirect:/schedules");
    }


}
