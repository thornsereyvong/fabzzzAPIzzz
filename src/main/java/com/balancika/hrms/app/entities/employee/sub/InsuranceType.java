package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class InsuranceType {
	
	private String InsuranceType_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getInsuranceType_Name() {
		return InsuranceType_Name;
	}

	public void setInsuranceType_Name(String insuranceType_Name) {
		InsuranceType_Name = insuranceType_Name;
	}

	
}
