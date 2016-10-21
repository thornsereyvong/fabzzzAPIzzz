package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ContractType {
	private String ContactType_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getContactType_Name() {
		return ContactType_Name;
	}
	public void setContactType_Name(String contactType_Name) {
		ContactType_Name = contactType_Name;
	}
}
