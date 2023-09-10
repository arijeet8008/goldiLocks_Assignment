package com.goldiLocks.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(EmployeesException.class)
	public ResponseEntity<MyErrorDetails> genericExceptionHandler(EmployeesException ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(req.getDescription(false));
		err.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(err , HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> genericExceptionHandler(Exception ex, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(req.getDescription(false));
		err.setMessage(ex.getMessage());
		
		return new ResponseEntity<>(err , HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> myNoHandlerExceptionHandler(NoHandlerFoundException ne, WebRequest req){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails(req.getDescription(false));
		err.setMessage(ne.getMessage());
		
		return new ResponseEntity<>(err , HttpStatus.BAD_REQUEST);
		
	}
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMArgExceptionHandler(MethodArgumentNotValidException me){
		
		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setDetails("Validation Error");
		err.setMessage(me.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<>(err , HttpStatus.BAD_REQUEST);
		
	}
	
}
