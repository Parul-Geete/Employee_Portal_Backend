package com.company.employees.portal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED)
public class EmployeesNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmployeesNotFoundException(String message) {
		super();
	}

}
