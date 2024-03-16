package com.pwpl.managment.service;

import java.util.List;

import com.pwpl.managment.model.Employee;

public interface EmployeeService {

	// Add Employee Data
	public Employee addEmployeeData(Employee employee);

	// Fetch Employee Data By ID
	public Employee getEmployeeDataById(long employeeId);

	// fetch Employee Data By FirstName And LastName

	// Fetch All Employee List
	public List<Employee> getAllEmployeeData();

	// Update Employee Data By Id
	public Employee upDateEmployData(Employee employee, long employeeId);

	// Delete Employee Data
	public void deleteEmployeeById(long employeeId);
	
	//Get Student Data By FirstName And LastName
	public List<Employee> searchStudentDataByFirstNameAndLAstName(String query);
	
	
}
