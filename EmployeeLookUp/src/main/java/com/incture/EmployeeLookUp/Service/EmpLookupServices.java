package com.incture.EmployeeLookUp.Service;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.incture.EmployeeLookUp.Response.EmpLookupResponse;
import com.incture.EmployeeLookUp.dao.EmpLookupDao;
import com.incture.EmployeeLookUp.dto.EmpLookupDto;
import com.incture.EmployeeLookUp.entities.EmpLookupDo;

public class EmpLookupServices {
	private SessionFactory sessionFactory=new Configuration().configure("com/incture/EmployeeLookUp/cfgs/hibernate.cfg.xml").buildSessionFactory();
	private Session session = sessionFactory.openSession();
	
	
	public EmpLookupResponse createEmpRecord(EmpLookupDto empDto){
		EmpLookupResponse empResponse=new EmpLookupResponse();
		if(empDto!=null){
		 try{
			session.beginTransaction();
			session.save(new EmpLookupDao().importDto(empDto));
			session.getTransaction().commit();
			session.close();
			empResponse.setMessage("SUCCESS");
		 }
		 catch(Exception e){
			 System.out.println(e.getMessage());
			 empResponse.setMessage("Failure");
			} finally {

				session.close();
				sessionFactory.close();
			}
		}
		return empResponse;
	}
	
	
	public EmpLookupResponse readEmpRecord(int empId){
		EmpLookupResponse empResponse=new EmpLookupResponse();
		List<EmpLookupDto> empDtos =new ArrayList<EmpLookupDto>();
		if(empId!=0){
			EmpLookupDo empDo=(EmpLookupDo)session.get(EmpLookupDo.class,empId);
			if(empDo!=null){
				EmpLookupDto empDto=new EmpLookupDao().exportDto(empDo);
				empDtos.add(empDto);
				empResponse.setEmpLookupDtos(empDtos);
			}
		}
		
		return empResponse;
	}
	
	
	public EmpLookupResponse updateEmpRecord(EmpLookupDto empDto) {
		EmpLookupResponse empLookupResponse = new EmpLookupResponse();
		List<EmpLookupDto> empDtos = new ArrayList<EmpLookupDto>();
		if (empDto.getEmpId() != 0) {
			EmpLookupDo empDo = (EmpLookupDo) session.get(EmpLookupDo.class,empDto.getEmpId());
			if (empDo != null) {
				empDo = new EmpLookupDao().importDto(empDto,empDo);
				try {

					session.beginTransaction();
					session.update(empDo);
					session.getTransaction().commit();
					empLookupResponse.setMessage("Success");
					empDtos.add(empDto);
					empLookupResponse.setEmpLookupDtos(empDtos);
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					empLookupResponse.setMessage("Failure");
				} finally {
					session.close();
					sessionFactory.close();
				}
			}
		}
		return empLookupResponse;
	}
	

	public EmpLookupResponse deleteEmployeeRecord(int empId) {
		EmpLookupResponse empResponse = new EmpLookupResponse();
		if (empId != 0) {
			EmpLookupDo empDo = (EmpLookupDo) session.get(EmpLookupDo.class, empId);
			if (empDo != null) {
				try {

					session.beginTransaction();
					session.delete(empDo);
					session.getTransaction().commit();
					empResponse.setMessage("Deleted successfully");
				} catch (Exception ex) {
					System.out.println(ex.getMessage());
					empResponse.setMessage("Failure");
				} finally {
					session.close();
					sessionFactory.close();
				}
			}
		}
		return empResponse;
	}
	
	
	
}
