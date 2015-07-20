package com.tw.service;

import com.tw.bean.Employee;
import com.tw.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }
}
