package com.tw.service;

import com.tw.entity.Employee;
import com.tw.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeDao employeeDao;

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public List<Employee> getEmployeehList() {
        return employeeDao.getEmployeeList();
    }

    public void delete(int id) {
        employeeDao.delete(id);
    }

    public List<Employee> getCoaches(){
        return employeeDao.getCoaches();
    }

    public Employee getEmployeeById(int id){
        return employeeDao.getEmployeeById(id);
    }

//    public int getEmployeeId(String name){
//        return employeeDao.getEmployeeId(name);
//    }
}
