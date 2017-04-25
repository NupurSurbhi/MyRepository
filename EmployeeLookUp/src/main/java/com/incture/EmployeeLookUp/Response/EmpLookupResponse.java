package com.incture.EmployeeLookUp.Response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.incture.EmployeeLookUp.dto.EmpLookupDto;

@XmlRootElement
public class EmpLookupResponse {
	public String message;
	public List<EmpLookupDto> EmpLookupDtos;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<EmpLookupDto> getEmpLookupDtos() {
		return EmpLookupDtos;
	}
	public void setEmpLookupDtos(List<EmpLookupDto> empLookupDtos) {
		EmpLookupDtos = empLookupDtos;
	}
	
	

}
