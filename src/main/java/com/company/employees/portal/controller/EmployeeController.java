package com.company.employees.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.company.employees.portal.dto.Employee;
import com.company.employees.portal.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;


@CrossOrigin("*")
@RestController
@Api(tags = { "Employee" })
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/api/v1/register")
	@ResponseStatus(code = HttpStatus.CREATED)
	@ApiOperation(value = "Register Employee", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 201, message = "Successful creation") })
	public void register(@RequestBody(required = true) Employee employee) {
		employeeService.addEmployee(employee);
	}

	@GetMapping("/api/v1/employees")
	@ApiOperation(value = "Get All Employees", response = String.class)
	@ApiResponses(value = { @ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval") })
	public List<Employee> getAll() {
		return employeeService.getAll();
	}

}
