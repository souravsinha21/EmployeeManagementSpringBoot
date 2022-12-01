package com.capgemini.employee.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Employee")
public class EmployeeModel 
{
	@Column(name="Id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	 private int EmployeeId;
	@Column(name="EmployeeFirstName")
	 private String EmployeeFirstName;
	@Column(name="EmployeeLastName")
	 private String EmployeeLastName;
	@Column(name="EmployeeContactNo")
	 private String EmployeeContactNo;
	@Column(name="EmployeeSalary")
	 private int EmployeeSalary;
	 
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeFirstName() {
		return EmployeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		EmployeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return EmployeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		EmployeeLastName = employeeLastName;
	}
	public String getEmployeeContactNo() {
		return EmployeeContactNo;
	}
	public void setEmployeeContactNo(String employeeContactNo) {
		EmployeeContactNo = employeeContactNo;
	}
	public int getEmployeeSalary() {
		return EmployeeSalary;
	}
	public void setEmployeeSalary(int employeeSalary) {
		EmployeeSalary = employeeSalary;
	}
	@Override
	public String toString() {
		return "EmployeeModel [EmployeeId=" + EmployeeId + ", EmployeeFirstName=" + EmployeeFirstName + ", EmployeeLastName="
				+ EmployeeLastName + ", EmployeeContactNo=" + EmployeeContactNo + ", EmployeeSalary=" + EmployeeSalary + "]";
	}

}
