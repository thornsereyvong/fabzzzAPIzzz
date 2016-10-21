package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class School {
	private String School_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getSchool_Name() {
		return School_Name;
	}

	public void setSchool_Name(String school_Name) {
		School_Name = school_Name;
	}
}
