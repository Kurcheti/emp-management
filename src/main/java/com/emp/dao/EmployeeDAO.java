package com.emp.dao;

import java.util.List;

import com.emp.model.Employee;

public interface EmployeeDAO {
	
	public boolean createEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public boolean deleEmployeeById(String empId);

}
