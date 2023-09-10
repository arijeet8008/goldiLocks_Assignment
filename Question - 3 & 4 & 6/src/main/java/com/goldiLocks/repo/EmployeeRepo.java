package com.goldiLocks.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goldiLocks.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

}
