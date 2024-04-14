package com.ticket.myticket.service;

import java.util.List;

import com.ticket.myticket.model.Employee;

public interface EmployeeService {
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
}
