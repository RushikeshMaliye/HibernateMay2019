package com.spring.hibernate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HibernatePractiseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HibernatePractiseApplication.class, args);
		EmployeeDao employeeDao= context.getBean(EmployeeDao.class);
		
		/*List<Employee> list= employeeDao.getAllEmployee();
		for (Employee employee : list) {
			System.out.println("Name: "+employee.getName());
			System.out.println("Grade: "+employee.getGrade());
			System.out.println("Salary: "+employee.getSalary());
			System.out.println("Designation: "+employee.getDesignation());
			System.out.println("-------------------------");
			
		}*/
		
		
		//employeeDao.deleteEmployee(4);
		Employee emp = new Employee();
		emp.setId(3);
		emp.setName("Rushikesh");
		employeeDao.updateEmployee(emp);
		
		
		
		
	}

}
