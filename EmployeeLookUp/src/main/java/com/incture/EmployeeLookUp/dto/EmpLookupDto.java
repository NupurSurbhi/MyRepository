package com.incture.EmployeeLookUp.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class EmpLookupDto {
	
	private int empId;
	
	private String empName;
	
	private String empSalary;

	

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	
	
}
