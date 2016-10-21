package com.balancika.hrms.app.entities.timesheet;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeLeaveTypes {
	public List<EmployeeLeaveType> employeeLeaveTypes; 
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
