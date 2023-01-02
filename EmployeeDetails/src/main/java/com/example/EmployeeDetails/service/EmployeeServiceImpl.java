package com.example.EmployeeDetails.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EmployeeDetails.dao.EmployeeRepository;
import com.example.EmployeeDetails.model.Employee;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepository repository;

	@Override
	public Employee saveEmployee(Employee emp)
	{
		return repository.save(emp);
	}

	@Override
	public void updateEmployee(Employee emp)
	{
		repository.save(emp);
	}
	
	@Override
	public Employee getEmployee(int id)
	{
		Optional<Employee> optional = repository.findById(id);
		Employee employee = optional.get();
		return employee;
	}
	
	@Override
	public List<Employee> getAllEmployees()
	{
		return (List<Employee>)repository.findAll();
	}

	@Override
	public void deleteEmployee(int id)
	{
		repository.deleteById(id);
	}

	@Override
	public boolean isEmployeeExist(int id)
	{
		return repository.existsById(id);
	}

	
	
	
}
