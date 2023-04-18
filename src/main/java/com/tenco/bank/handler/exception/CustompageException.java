package com.tenco.bank.handler.exception;

import org.springframework.http.HttpStatus;

public class CustompageException extends RuntimeException{

	private HttpStatus status;
	public CustompageException(String message, HttpStatus status) {
		super(message);
		this.status = status;
	}
}
