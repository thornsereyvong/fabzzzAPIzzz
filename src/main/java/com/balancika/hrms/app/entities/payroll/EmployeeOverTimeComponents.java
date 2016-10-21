package com.balancika.hrms.app.entities.payroll;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeOverTimeComponents {
	public List<EmployeeOverTimeComponent> employeeOverTimeComponent;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
