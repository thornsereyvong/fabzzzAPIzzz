package com.balancika.hrms.app.entities.authorisation;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeAuthorisations {
	public List<EmployeeAuthorisation> employeeAuthorisation;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
