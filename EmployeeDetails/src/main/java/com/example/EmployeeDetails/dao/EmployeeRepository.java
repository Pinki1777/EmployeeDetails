package com.example.EmployeeDetails.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.EmployeeDetails.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
