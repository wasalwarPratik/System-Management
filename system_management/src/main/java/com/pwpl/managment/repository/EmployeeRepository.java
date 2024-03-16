package com.pwpl.managment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pwpl.managment.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	public Employee findById(long employeeId);
	
	//custom Query to search the EmployeeData By FirstName and LastName.
	@Query("SELECT e FROM Employee e WHERE e.empFirstName LIKE CONCAT('%', :query, '%') OR e.empLastName LIKE CONCAT('%', :query, '%')")
	public List<Employee> searchStudent(@Param("query") String query);
	
//	@Query("SELECT e FROM Employee e WHERE e.empFirstName = :empFirstName")
//	public List<Employee> findFirstName(@Param(value = "empFirstName") String empFirstName);
//
//	@Query("SELECT e FROM Employee e WHERE e.empLastName = :empLastName")
//	public List<Employee> findLastName(@Param(value = "empLastName") String empLastName);
}
