package com.tourcoreservice.pojo.generic;

import org.springframework.http.HttpStatus;

public class ResponseMessagePojo {
	private String successMessage;
	private HttpStatus status;
	private String errorMessage;
	private String statusCode;

	public String getMessage() {
		return successMessage;
	}

	public void setMessage(String message) {
		this.successMessage = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

}
