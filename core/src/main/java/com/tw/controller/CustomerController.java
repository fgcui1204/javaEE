package com.tw.controller;

import com.tw.entity.Customer;
import com.tw.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public ModelAndView getCoachList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("customerList");
        modelAndView.addObject("customers", customerService.getCustomers());
        return modelAndView;
    }

    @RequestMapping(value = "/customers/create", method = RequestMethod.GET)
    public ModelAndView getCreatePage(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("addCustomer");
        return modelAndView;
    }

    @RequestMapping(value = "/customers/create", method = RequestMethod.POST)
    public ModelAndView create(@RequestParam String name, @RequestParam String telphone){
        Customer customer = new Customer(name, telphone);
        customerService.create(customer);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/customers/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id){
        customerService.delete(id);
        return new ModelAndView("redirect:/customers");
    }

    @RequestMapping(value = "/customers/update/{id}", method = RequestMethod.GET)
    public ModelAndView getCustomer(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updateCustomer");
        modelAndView.addObject("customer", customerService.getCustomerById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/customers/update", method = RequestMethod.POST)
    public ModelAndView update(@RequestParam int id, @RequestParam String name, @RequestParam String telphone){
        Customer customer = new Customer(id, name, telphone);
        customerService.update(customer);
        return new ModelAndView("redirect:/customers");
    }
}
