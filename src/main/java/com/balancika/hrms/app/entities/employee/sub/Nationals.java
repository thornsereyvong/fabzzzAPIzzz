package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Nationals {
	private String Nationals_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getNationals_Name() {
		return Nationals_Name;
	}

	public void setNationals_Name(String nationals_Name) {
		Nationals_Name = nationals_Name;
	}
}
