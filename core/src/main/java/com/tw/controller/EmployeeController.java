package com.tw.controller;


import com.tw.entity.Employee;
import com.tw.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(value = "/employees/update/{id}", method = RequestMethod.GET)
    public ModelAndView getEmployee(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateEmployee");
        modelAndView.addObject("employee", employeeService.getEmployeeById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/employees/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam int id, @RequestParam String name, @RequestParam String role, @RequestParam String sex, @RequestParam String mail, @RequestParam int age){
        Employee employee = new Employee(id, name, role, sex, mail, age);
        employeeService.updateEmployee(employee);
        return new ModelAndView("redirect:/employees");
    }

}
