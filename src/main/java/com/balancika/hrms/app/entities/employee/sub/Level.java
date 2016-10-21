package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Level {
	private String Level_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getLevel_Name() {
		return Level_Name;
	}

	public void setLevel_Name(String level_Name) {
		Level_Name = level_Name;
	}

	
}
