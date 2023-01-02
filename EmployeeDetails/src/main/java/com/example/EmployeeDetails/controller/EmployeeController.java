package com.example.EmployeeDetails.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.EmployeeDetails.exception.EmployeeNotFoundException;
import com.example.EmployeeDetails.model.Employee;
import com.example.EmployeeDetails.service.EmployeeService;

@RestController
public class EmployeeController {
	
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
		emp=service.saveEmployee(emp);
		logger.info("Details saved");
		return new ResponseEntity<>("Employee is created successfully with Id = "+emp.getId(),HttpStatus.CREATED);
	}
	
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id") int id,@RequestBody Employee emp) {

		boolean isEmployeeExist = service.isEmployeeExist(id);
		logger.info("Searching for existing data...");
    	if(isEmployeeExist) {
    		emp.setId(id);
    		service.updateEmployee(emp);
    		logger.info("Details modified");
    		return new ResponseEntity<>("Employee is updated successfully.",HttpStatus.CREATED);
    	}
    	else	{
    		logger.info("Data not found...");
    		service.saveEmployee(emp);
    		logger.info("New Resource Created.");
    		throw new EmployeeNotFoundException();
    	}
	}
	
   
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		List<Employee> employeeList = service.getAllEmployees();
		logger.info("Retrieved data");
		logger.trace("fatal error");
		return new ResponseEntity<>(employeeList, HttpStatus.OK);
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = service.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			Employee employee = service.getEmployee(id);
			logger.info("Retrieved data");
			return new ResponseEntity<>(employee, HttpStatus.OK);
		}
		else
		{
			logger.info("Data not found...");
			throw new EmployeeNotFoundException();
		}

	}
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") int id)
	{
		boolean isEmployeeExist = service.isEmployeeExist(id);
		if (isEmployeeExist)
		{
			service.deleteEmployee(id);
			logger.info("Deleted...");
			return new ResponseEntity<>("Employee is deleted successsfully.", HttpStatus.OK);
		}
		else
		{
			logger.info("data not found....");
			throw new EmployeeNotFoundException();
		}

	}

}