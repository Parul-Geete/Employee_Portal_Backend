package com.company.employees.portal.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.employees.portal.dto.Employee;
import com.company.employees.portal.entity.EmployeeEntity;
import com.company.employees.portal.exceptions.EmployeesNotFoundException;
import com.company.employees.portal.repo.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Override
	public void addEmployee(Employee employee) {
		employeeRepo.save(prepareEmployeeEntity(employee));
	}

	@Override
	public List<Employee> getAll() {
		try {
			return convertToEmployeeList(employeeRepo.findAll());
		} catch (Exception e) {
			throw new EmployeesNotFoundException("There are no employees data available in database");
		}
	}

	private EmployeeEntity prepareEmployeeEntity(Employee employee) {
		EmployeeEntity entity = new EmployeeEntity();
		entity.setFirstName(employee.getFirstName() !=null ? employee.getFirstName() : "");
		entity.setLastName(employee.getLastName() !=null ? employee.getLastName() : "");
		entity.setGender(employee.getGender() !=null ? employee.getGender() : "");
		entity.setDob(LocalDate.parse(employee.getDob()));
		entity.setDepartment(employee.getDepartment() !=null ? employee.getDepartment() : "");
		
		return entity;
	}

	private List<Employee> convertToEmployeeList(List<EmployeeEntity> entityList) {
		List<Employee> employeesList = new ArrayList<>();

		for (EmployeeEntity entity : entityList) {
			Employee employee = new Employee();
			employee.setDepartment(entity.getDepartment());
			employee.setDob(entity.getDob().toString());
			employee.setFirstName(entity.getFirstName());
			employee.setGender(entity.getGender());
			employee.setLastName(entity.getLastName());
			employeesList.add(employee);
		}
		return employeesList;

	}

}
