package com.pwpl.managment.exception;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponce> resourceNotfoundException(ResourceNotFoundException exception){
		String message = exception.getMessage();
		ApiResponce apiResponce = new ApiResponce(message, false);
		
		return new ResponseEntity<ApiResponce>(apiResponce,HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgNotValidException(MethodArgumentNotValidException excep){
		
		Map<String, String> resp = new HashMap<>();
		excep.getBindingResult().getAllErrors().forEach((error)-> {
			String fieldName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			resp.put(fieldName, message);	
		});
		return new ResponseEntity<Map<String, String>>(resp, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ApiResponce> sqlIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException exception){
		String message = exception.getMessage();
		ApiResponce apiResponce = new ApiResponce(message, false );
		return new ResponseEntity<ApiResponce>(apiResponce, HttpStatus.IM_USED);
		
	}
	
	
	
	
}
