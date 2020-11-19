package com.company.employees.portal.service;

import java.util.List;

import com.company.employees.portal.dto.Employee;

public interface EmployeeService {

	void addEmployee(Employee employee);

	List<Employee> getAll();

}
