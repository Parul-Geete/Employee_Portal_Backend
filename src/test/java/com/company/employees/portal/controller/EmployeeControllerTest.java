package com.company.employees.portal.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.company.employees.portal.dto.Employee;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;
	@LocalServerPort
	private Integer port;

	private static final String baseUrl = "http://localhost:";

	// Test case to check successful registration case
	@Test
	public void testRegister() {
		String url = baseUrl + port + "/human-resource/employee-management/emp/api/v1";
		Employee employee = new Employee();
		employee.setDepartment("Human Resource");
		employee.setDob("1991-01-18");
		employee.setFirstName("John");
		employee.setGender("Male");
		employee.setLastName("Smith");

		ResponseEntity<String> response = restTemplate.postForEntity(url + "/register", employee, String.class);
		Assert.isTrue(HttpStatus.CREATED == response.getStatusCode(), "Status should be 201");

	}

	@Test
	public void testGetAll() {
		String url = baseUrl + port + "/human-resource/employee-management/emp/api/v1";
		ResponseEntity<String> response = restTemplate.getForEntity(url + "/employees", String.class);
		Assert.isTrue(HttpStatus.OK == response.getStatusCode(), "Status should be 200");

	}
}
