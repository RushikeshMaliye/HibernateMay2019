package com.spring.hibernate;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.openSession();
		List<Employee>  employeeList = session.createQuery("from Employee").list();
		return employeeList;
	}
 
	
	public Employee getEmployee(int id) {
		Session session = sessionFactory.openSession();
		Employee employee = (Employee) session.get(Employee.class, id);
		return employee;
	}
 
	@Transactional
	public Employee addEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		//Transaction tx = session.beginTransaction();  // no need to this if @Transactional used
		session.save(employee);
		//tx.commit();
		return employee;
	}
 
	@Transactional
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(employee);
		tx.commit();
	}
 
	public void deleteEmployee(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Employee p = (Employee) session.load(Employee.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
		tx.commit();
	} 

}
