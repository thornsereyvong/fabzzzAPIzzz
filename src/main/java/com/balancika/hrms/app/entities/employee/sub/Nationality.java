package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Nationality {
	private String Nationality_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getNationality_Name() {
		return Nationality_Name;
	}

	public void setNationality_Name(String nationality_Name) {
		Nationality_Name = nationality_Name;
	}
}
