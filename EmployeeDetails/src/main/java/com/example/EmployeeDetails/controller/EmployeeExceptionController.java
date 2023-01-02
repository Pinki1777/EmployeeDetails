package com.example.EmployeeDetails.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.EmployeeDetails.exception.EmployeeNotFoundException;


@ControllerAdvice
public class EmployeeExceptionController {

	@ExceptionHandler(value=EmployeeNotFoundException.class)
	public ResponseEntity<String> exception(EmployeeNotFoundException exception) {
	      return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
	   }
}
