
package com.company.employees.portal.service;

import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.company.employees.portal.dto.Employee;
import com.company.employees.portal.entity.EmployeeEntity;
import com.company.employees.portal.repo.EmployeeRepo;
import com.company.employees.portal.service.EmployeeServiceImpl;

@SpringBootTest
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepo repo;

	@InjectMocks
	private EmployeeServiceImpl serviceImpl;

	@BeforeEach
	public void before() {
		List<EmployeeEntity> employees = new ArrayList<>();
		EmployeeEntity entity = new EmployeeEntity();
		entity.setDepartment("Human Resource");
		entity.setDob(LocalDate.now());
		entity.setFirstName("John");
		entity.setGender("Male");
		entity.setLastName("Smith");
		employees.add(entity);
		when(repo.findAll()).thenReturn(employees);
	}

	@Test
	public void testGetAll() {
		List<Employee> employees = serviceImpl.getAll();
		 Assert.notEmpty(employees, "Employees list should not be empty");
	}

	@Test
	public void testAddEmployee() {
		Employee employee = new Employee();
		employee.setDepartment("Human Resource");
		employee.setDob("1991-01-18");
		employee.setFirstName("John");
		employee.setGender("Male");
		employee.setLastName("Smith");
		serviceImpl.addEmployee(employee);

	}

}
