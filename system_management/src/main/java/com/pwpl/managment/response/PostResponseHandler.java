package com.pwpl.managment.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pwpl.managment.model.Employee;

public class PostResponseHandler {

	public static ResponseEntity<Object> postResponse(String meesage, HttpStatus httpStatus, Employee employee){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", meesage);
		map.put("Http Status", httpStatus);
		map.put("Employee", employee);
		
		return new ResponseEntity<Object>(employee, httpStatus);
	}
}
