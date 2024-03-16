package com.pwpl.managment.model;

import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long employeeId;

	@NotBlank
	@NotEmpty(message = "Mandotary to write First Name")
	@Size(min = 3, max = 10)
	@Column(name = "empFirstName")
	private String empFirstName;

	@NotBlank
	@NotEmpty(message = "Mandotary to write Last Name")
	@Size(max = 12)
	@Column(name = "empLastName")
	private String empLastName;

	@NotBlank
	@NotEmpty(message = "Mandotary to write AdharCard Number ")
	@Size(min = 12, max = 12)
	@Column(name = "empAdharNumber")
	private String empAdharNumber;

	@NotBlank
	@NotEmpty(message = "Mandotary to write Mobile Number")
	@Size(min = 10, max = 10)
	@Column(name = "empMobileNumber")
	private String empMobileNumber;

	@NotBlank
	@Email(message = "Email Address Not Valid")
	@NotEmpty
	@Column(name = "empEmailAddress", nullable = false, unique = true)
	private String empEmailAddress;

	@NotBlank
	@NotEmpty(message = "Mandotary to write Salary")
	@Column(name = "empSalary")
	private String empSalary;

//	@NotBlank
//	@NotEmpty(message = "Mandotary to write DateOf Birth")
	@Column(name = "empDateOfBirth")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate empDateOfBirth;

	@Size(max = 20)
	@Column(name = "empFullName")
	private String empFullName;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false)
	private Date created_at;
	
	@PrePersist
	private void onCreate() {
	created_at = new Date();
	}
	
	public Employee() {
		super();
		
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpAdharNumber() {
		return empAdharNumber;
	}

	public void setEmpAdharNumber(String empAdharNumber) {
		this.empAdharNumber = empAdharNumber;
	}

	public String getEmpMobileNumber() {
		return empMobileNumber;
	}

	public void setEmpMobileNumber(String empMobileNumber) {
		this.empMobileNumber = empMobileNumber;
	}

	public String getEmpEmailAddress() {
		return empEmailAddress;
	}

	public void setEmpEmailAddress(String empEmailAddress) {
		this.empEmailAddress = empEmailAddress;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}

	public LocalDate getEmpDateOfBirth() {
		return empDateOfBirth;
	}

	public void setEmpDateOfBirth(LocalDate empDateOfBirth) {
		this.empDateOfBirth = empDateOfBirth;
	}

	public String getEmpFullName() {
		return empFullName;
	}

	public void setEmpFullName(String empFullName) {
		this.empFullName = empFullName;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empFirstName=" + empFirstName + ", empLastName=" + empLastName
				+ ", empAdharNumber=" + empAdharNumber + ", empMobileNumber=" + empMobileNumber + ", empEmailAddress="
				+ empEmailAddress + ", empSalary=" + empSalary + ", empDateOfBirth=" + empDateOfBirth + ", empFullName="
				+ empFullName + ", created_at=" + created_at + ", getEmployeeId()=" + getEmployeeId()
				+ ", getEmpFirstName()=" + getEmpFirstName() + ", getEmpLastName()=" + getEmpLastName()
				+ ", getEmpAdharNumber()=" + getEmpAdharNumber() + ", getEmpMobileNumber()=" + getEmpMobileNumber()
				+ ", getEmpEmailAddress()=" + getEmpEmailAddress() + ", getEmpSalary()=" + getEmpSalary()
				+ ", getEmpDateOfBirth()=" + getEmpDateOfBirth() + ", getEmpFullName()=" + getEmpFullName()
				+ ", getCreated_at()=" + getCreated_at() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public Employee(long employeeId,
			@NotBlank @NotEmpty(message = "Mandotary to write First Name") @Size(min = 3, max = 10) String empFirstName,
			@NotBlank @NotEmpty(message = "Mandotary to write Last Name") @Size(max = 12) String empLastName,
			@NotBlank @NotEmpty(message = "Mandotary to write AdharCard Number ") @Size(min = 12, max = 12) String empAdharNumber,
			@NotBlank @NotEmpty(message = "Mandotary to write Mobile Number") @Size(min = 10, max = 10) String empMobileNumber,
			@NotBlank @Email(message = "Email Address Not Valid") @NotEmpty String empEmailAddress,
			@NotBlank @NotEmpty(message = "Mandotary to write Salary") String empSalary, LocalDate empDateOfBirth,
			@Size(max = 20) String empFullName, Date created_at) {
		super();
		this.employeeId = employeeId;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.empAdharNumber = empAdharNumber;
		this.empMobileNumber = empMobileNumber;
		this.empEmailAddress = empEmailAddress;
		this.empSalary = empSalary;
		this.empDateOfBirth = empDateOfBirth;
		this.empFullName = empFullName;
		this.created_at = created_at;
	}
	
	




	
	
}
