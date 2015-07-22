package com.tw.dao;

import com.tw.entity.Employee;
import com.tw.entity.Schedule;
import com.tw.entity.User;
import com.tw.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    public void addEmployee(Employee employee){

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }

    public List<Employee> getEmployeeList() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("select  new Employee(e.id,e.name,e.role,e.sex,e.mail,e.age) from Employee as e, User as u where e.id=u.employee.id").list();
        session.close();
        return list;
    }

    public void delete(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Employee employee = (Employee)session.get(Employee.class, id);
        session.delete(employee);
        transaction.commit();
        session.close();
    }

    public List<Employee> getCoaches(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("select  new Employee(e.id,e.name,e.role,e.sex,e.mail,e.age) from Employee as e, User as u where e.id=u.employee.id and e.role='Coach'").list();
        session.close();
        return list;
    }

    public Employee getEmployeeById(int id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Employee> list = session.createQuery("select  new Employee(e.id,e.name,e.role,e.sex,e.mail,e.age) from Employee as e, User as u where e.id=u.employee.id and e.id="+id).list();
        Employee employee = list.get(0);
        session.close();
        return employee;

    }
//    public int getEmployeeId(String name){
//        Session session = HibernateUtil.getSessionFactory().openSession();
//        String hql = "from Employee where name='"+name+"'";
//        Employee employee = (Employee)session.createQuery(hql).list().get(0);
//        session.close();
//        return employee.getId();
//    }
}
