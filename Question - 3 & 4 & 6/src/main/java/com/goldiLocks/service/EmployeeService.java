package com.goldiLocks.service;

import java.util.List;

import com.goldiLocks.exception.EmployeesException;
import com.goldiLocks.model.Employee;

public interface EmployeeService {

	public Employee addEmployee(Employee employee) throws EmployeesException;
	
	public List<Employee> getAllEmployees() throws EmployeesException;
	
	public Employee getEmployeeById(Integer empId) throws EmployeesException;
	
}
