package com.customer.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerException
{
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> handleNullPointerException(NullPointerException e)
	{
		return new ResponseEntity<String>("Not Found: "+e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
