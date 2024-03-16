package com.pwpl.managment.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwpl.managment.exception.ResourceNotFoundException;
import com.pwpl.managment.model.Employee;
import com.pwpl.managment.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class.getName());

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployeeData(Employee employee) {
		LOGGER.info("!----------SaveEmployeeData--InTo--DB------------!");
		employee.setEmpFullName(employee.getEmpFirstName()+" "+employee.getEmpLastName());
		Employee save = employeeRepository.save(employee);
		return save;
	}

	@Override
	public Employee getEmployeeDataById(long employeeId) {
		LOGGER.info("!----------GetEmployeeDataById--InTo--DB---Start------------!");
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee", "employeeId", employeeId));
		LOGGER.info("!----------GetEmployeeDataById--InTo--DB---End------------!");
		return employee;
		
	}

	@Override
	public List<Employee> getAllEmployeeData() {
		LOGGER.info("!----------GetEmployeeAllData--InTo--DB------------!");
		List<Employee> findAll = employeeRepository.findAll();
		return findAll;
	}

	@Override
	public Employee upDateEmployData(Employee employee, long employeeId) {

		LOGGER.info("!----------upDateEmployeeDataById--InTo--DB------------!");
		Employee existingemployee = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Id", "employeeId", employeeId));
		existingemployee.setEmpFirstName(employee.getEmpFirstName());
		existingemployee.setEmpLastName(employee.getEmpLastName());
		existingemployee.setEmpDateOfBirth(employee.getEmpDateOfBirth());
		existingemployee.setEmpAdharNumber(employee.getEmpAdharNumber());
		existingemployee.setEmpMobileNumber(employee.getEmpMobileNumber());
		existingemployee.setEmpEmailAddress(employee.getEmpEmailAddress());
		existingemployee.setEmpSalary(employee.getEmpSalary());
	
		Employee updtae = employeeRepository.save(existingemployee);
		return updtae;
	}

	@Override
	public void deleteEmployeeById(long employeeId) {
		LOGGER.info("!----------DeleteEmployeeDataById--InTo--DB------------!");
		Employee findById = employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Id Data Not Exist : Create New Employee Data With New Id", "employeeId", employeeId));
		if (findById != null) {
			 employeeRepository.deleteById(employeeId);
		}
			
	}

	@Override
	public List<Employee> searchStudentDataByFirstNameAndLAstName(String query) {
		List<Employee> searchStudent = employeeRepository.searchStudent(query);
		return searchStudent;
	}

}
