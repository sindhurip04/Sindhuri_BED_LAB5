package com.greatlearning.ems.service;

import java.util.List;

import com.greatlearning.ems.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();
	void saveEmployee(Employee employee);
	Employee getEmployeeById(long id);
	void deleteEmployeeById(long id);
}