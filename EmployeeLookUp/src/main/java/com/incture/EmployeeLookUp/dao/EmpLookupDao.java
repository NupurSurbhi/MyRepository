package com.incture.EmployeeLookUp.dao;

import com.incture.EmployeeLookUp.dto.EmpLookupDto;
import com.incture.EmployeeLookUp.entities.EmpLookupDo;

public class EmpLookupDao {
	
	public EmpLookupDto exportDto(EmpLookupDo empDo){
		EmpLookupDto empDto=new EmpLookupDto();
		if(empDo !=null){
			empDto.setEmpId(empDo.getEmpId());
			empDto.setEmpName(empDo.getEmpName());
			empDto.setEmpSalary(empDo.getEmpSalary());
			
		}
		return empDto;
	}
	
	//for creation
	public EmpLookupDo importDto(EmpLookupDto empDto){
		EmpLookupDo empDo=new EmpLookupDo();
		if(empDto!=null){
			
			if(empDto.getEmpId()!=0){
				empDo.setEmpId(empDto.getEmpId());
				
			}
			if(empDto.getEmpName()!=null){
				empDo.setEmpName(empDto.getEmpName());
				
			}
			if(empDto.getEmpSalary()!=null){
				empDo.setEmpSalary(empDto.getEmpSalary());
				
			}
			
		}
		
		return empDo;
	}
	
	//for update
	public EmpLookupDo importDto(EmpLookupDto empDto,EmpLookupDo empDo){
		
		if(empDto!=null){
			
			if(empDto.getEmpId()!=0){
				empDo.setEmpId(empDto.getEmpId());
				
			}
			if(empDto.getEmpName()!=null){
				empDo.setEmpName(empDto.getEmpName());
				
			}
			if(empDto.getEmpSalary()!=null){
				empDo.setEmpSalary(empDto.getEmpSalary());
				
			}
			
		}
		
		return empDo;
	}


}
