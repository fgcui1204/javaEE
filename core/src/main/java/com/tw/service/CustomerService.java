package com.tw.service;

import com.tw.dao.CustomerDao;
import com.tw.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    public void create(Customer customer) {
        customerDao.create(customer);
    }

    public void delete(int id) {
        customerDao.delete(id);
    }

    public Customer getCustomerById(int id) {
        return customerDao.getCustomerById(id);
    }

    public void update(Customer customer) {
        customerDao.update(customer);
    }
}
