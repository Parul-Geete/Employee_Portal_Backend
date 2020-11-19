package com.company.employees.portal.exceptions.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.company.employees.portal.exceptions.EmployeesNotFoundException;
import com.company.employees.portal.exceptions.ErrorResponse;

@RestControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(value = EmployeesNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleGenericNotFoundException(EmployeesNotFoundException e) {

		ErrorResponse error = new ErrorResponse("There are no employee present in database", e.getMessage());
		error.setTimeStamp(LocalDateTime.now());
		error.setStatus((HttpStatus.NOT_FOUND.value()));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
}
