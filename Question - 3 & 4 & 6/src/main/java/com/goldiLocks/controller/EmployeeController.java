package com.goldiLocks.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goldiLocks.model.Employee;
import com.goldiLocks.service.EmployeeService;

@RestController
@RequestMapping("/test")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("")
	public ResponseEntity<Employee> addEmployeeHandler(@RequestBody @Valid Employee employee){
		
		Employee employee2 = employeeService.addEmployee(employee);
		
		return new ResponseEntity<Employee>(employee2, HttpStatus.ACCEPTED);
		
	}
	
	@GetMapping("")
	public ResponseEntity<List<Employee>> getAllEmployeeHandler(){
		
		List<Employee> employees = employeeService.getAllEmployees();
		
		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Employee> getEmployeeByIdHandler(@PathVariable Integer id){
		
		Employee employee = employeeService.getEmployeeById(id);
		
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		
	}
	
}
