package com.example.EmployeeDetails.service;

import java.util.List;

import com.example.EmployeeDetails.model.Employee;

public interface EmployeeService {
		
	public abstract Employee saveEmployee(Employee emp);

	public abstract void updateEmployee(Employee emp);
	
	public abstract List<Employee> getAllEmployees();
	
	public abstract void deleteEmployee(int id);
	
	public abstract boolean isEmployeeExist(int id);

	public abstract Employee getEmployee(int id);
	
	

	

}
