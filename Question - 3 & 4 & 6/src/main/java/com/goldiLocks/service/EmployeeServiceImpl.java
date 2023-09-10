package com.goldiLocks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldiLocks.exception.EmployeesException;
import com.goldiLocks.model.Employee;
import com.goldiLocks.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee employee) throws EmployeesException {
		
		return employeeRepo.save(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() throws EmployeesException {
		
		List<Employee> employees = employeeRepo.findAll();
		
		if(employees.isEmpty())
			throw new EmployeesException("No Data Found");
		
		return employees;
		
	}

	@Override
	public Employee getEmployeeById(Integer empId) throws EmployeesException {

		return employeeRepo.findById(empId).orElseThrow(() -> new EmployeesException("Invalid Id"));

	}

	
	
}
