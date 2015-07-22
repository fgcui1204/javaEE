package com.tw.controller;


import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ModelAndView getCoachList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employeeList");
        modelAndView.addObject("employeeList", employeeService.getEmployeehList());
        return modelAndView;
    }

    @RequestMapping(value = "/employees/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "redirect:/employees";
    }

}
