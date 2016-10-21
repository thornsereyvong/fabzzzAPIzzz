package com.balancika.hrms.app.entities.setting;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class GeneralSetting {
	
	public List<Setting> Setting; 
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
