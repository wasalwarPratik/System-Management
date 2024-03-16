package com.pwpl.managment.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pwpl.managment.exception.ApiResponce;
import com.pwpl.managment.model.Employee;
import com.pwpl.managment.response.PostResponseHandler;
import com.pwpl.managment.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	/**
	 * TO TRACK THE lOG
	 */
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class.getName());

	/**
	 * PARAMETERISE CONSTRUCTOR
	 * 
	 * @paramemployeeService
	 */
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@Autowired
	private EmployeeService employeeService;

	/**
	 * TO SAVE THE EMPLOYEE DATA
	 * 
	 * @param employee
	 * @return
	 */
	
	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployeeData(@Valid @RequestBody Employee employee) {
		LOGGER.info("!----------SaveEmployeeData--InTo--DB------------!");
		Employee addEmployeeData = employeeService.addEmployeeData(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(addEmployeeData);

	}
	
//	/**
//	 * TO SAVE THE EMPLOYEE WITH NEW RESPONSE
//	 * 
//	 * @param employee
//	 * @return
//	 */
//	@PostMapping("/save")
//	public ResponseEntity<Object> saveEmployee(@Valid @RequestBody Employee employee) {
//		LOGGER.info("!-----#-----SaveEmployeeDataWith New Response-----#-----!");
//		return PostResponseHandler.postResponse("Employee Add Successfull", HttpStatus.CREATED, employeeService.addEmployeeData(employee));
//		
//	}

	/**
	 * TO GET EMPLOYEE DATA BY EMPLOYEE ID
	 * 
	 * @paramemployeeId
	 * @return
	 */
	@GetMapping("/getId/{employeeId}")
	public ResponseEntity<Employee> getEmployeeDataById(@PathVariable long employeeId) {
		LOGGER.info("!----------GetEmployeeDataById--InTo--DB------------!");
		Employee employeeDataById = employeeService.getEmployeeDataById(employeeId);
		return ResponseEntity.status(HttpStatus.FOUND).body(employeeDataById);
	}

	/**
	 * TO GET ALL DATA BY EMPLOYEE
	 * 
	 * @return
	 */
	@GetMapping("/getAll")
	public ResponseEntity<List<Employee>> getEmployeeAllData() {
		LOGGER.info("!----------GetEmployeeAllData--InTo--DB------------!");
		List<Employee> allEmployeeData = employeeService.getAllEmployeeData();
		return ResponseEntity.status(HttpStatus.FOUND).body(allEmployeeData);
	}

	/**
	 * TO DELETE EMPLOYEE DATA BY ID
	 * 
	 * @param employeeId
	 * @return
	 */
	@DeleteMapping("/deleteData/{employeeId}")
	public ResponseEntity<ApiResponce> deleteEmployeeDataById(@PathVariable("employeeId") long employeeId) {
		LOGGER.info("!----------DeleteEmployeeDataById--InTo--DB------------!");
		employeeService.deleteEmployeeById(employeeId);
		return new ResponseEntity<ApiResponce>(
				new ApiResponce("Delete Employee Data Successfully with Id : " + employeeId, true), HttpStatus.OK);
	}

	/**
	 * TO UPDATE THE EMPLOYEE DATA BY EMPLOYEE ENTITY AND EMPLOYEE ID
	 * 
	 * @param employee
	 * @param employeeId
	 * @return
	 */
	@PutMapping("/update/{employeeId}")
	public ResponseEntity<Employee> updateEmployeeData(@RequestBody Employee employee, @PathVariable long employeeId) {
		LOGGER.info("!----------upDateEmployeeDataById--InTo--DB------------!");
		Employee upDateEmployData = employeeService.upDateEmployData(employee, employeeId);
		return ResponseEntity.ok().body(upDateEmployData);
	}

	/**
	 * TO SEARCH AND GET EMPLOYEE BY FIRSTNAME AND LASTNAME
	 * 
	 * @param query
	 * @return
	 */
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployeeDataByFirstNameAndLastName(
			@RequestParam("query") String query) {
		LOGGER.info("##----------SearchEmployeeDataByFirstNameAndLastName--InTo--DB------------##");
		List<Employee> searchStudentDataByFirstNameAndLAstName = employeeService
				.searchStudentDataByFirstNameAndLAstName(query);
		return ResponseEntity.status(HttpStatus.OK).body(searchStudentDataByFirstNameAndLAstName);
	}

}
