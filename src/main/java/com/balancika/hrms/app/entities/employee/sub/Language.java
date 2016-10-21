package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Language {
	private String Language_Name;
	
	
	public String getLanguage_Name() {
		return Language_Name;
	}

	public void setLanguage_Name(String language_Name) {
		Language_Name = language_Name;
	}
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
