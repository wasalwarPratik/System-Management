package com.pwpl.managment.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponce {

	public static final String HttpStatus = null;
	private String Message;
	private boolean success;
}
