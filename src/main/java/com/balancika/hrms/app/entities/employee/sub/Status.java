package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Status {
	
	private String Status_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getStatus_Name() {
		return Status_Name;
	}
	public void setStatus_Name(String status_Name) {
		Status_Name = status_Name;
	}
	
}
