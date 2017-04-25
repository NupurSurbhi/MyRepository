package com.incture.EmployeeLookUp.Rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.incture.EmployeeLookUp.Response.EmpLookupResponse;
import com.incture.EmployeeLookUp.Service.EmpLookupServices;
import com.incture.EmployeeLookUp.dto.EmpLookupDto;

@Path("/employee")
public class EmpLookupRest {
	
	EmpLookupServices empServices=new EmpLookupServices();
	

	@POST
	@Path("/createEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmpLookupResponse createRecord(EmpLookupDto empDto) {
		return empServices.createEmpRecord(empDto);
	}

	@GET
	@Path("/getEmployee/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmpLookupResponse readRecord(@PathParam("empId") int empId) {
		return empServices.readEmpRecord(empId);
	}

	@POST
	@Path("/updateEmployee")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmpLookupResponse updateRecord(EmpLookupDto empDto) {
		return empServices.updateEmpRecord(empDto);
	}

	@GET
	@Path("/deleteEmployee/{empId}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EmpLookupResponse deleteRecord(@PathParam("empId") int empId) {
		return empServices.deleteEmployeeRecord(empId);
	}
	

}
