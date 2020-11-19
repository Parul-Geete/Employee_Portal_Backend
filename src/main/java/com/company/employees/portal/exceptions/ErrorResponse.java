package com.company.employees.portal.exceptions;

import java.time.LocalDateTime;

public class ErrorResponse {

	private String message;
	private String stackTrace;
	private LocalDateTime timeStamp;
	private Integer status;

	public ErrorResponse(String message, String stackTrace) {
		this.message = message;
		this.stackTrace = stackTrace;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStackTrace() {
		return stackTrace;
	}

	public void setStackTrace(String stackTrace) {
		this.stackTrace = stackTrace;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
