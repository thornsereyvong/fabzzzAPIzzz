package com.balancika.hrms.app.entities.payroll;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeAllowances {
	
	public List<EmployeeAllowance> employeeAllowance;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
