package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Insurance {
	private int Insurance_ID;
	private String Insurance_Name;
	private String Insurance_Company;
	private String Insurance_Type;
	private String Insurance_Description;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public int getInsurance_ID() {
		return Insurance_ID;
	}
	public void setInsurance_ID(int insurance_ID) {
		Insurance_ID = insurance_ID;
	}
	public String getInsurance_Name() {
		return Insurance_Name;
	}
	public void setInsurance_Name(String insurance_Name) {
		Insurance_Name = insurance_Name;
	}
	public String getInsurance_Company() {
		return Insurance_Company;
	}
	public void setInsurance_Company(String insurance_Company) {
		Insurance_Company = insurance_Company;
	}
	public String getInsurance_Type() {
		return Insurance_Type;
	}
	public void setInsurance_Type(String insurance_Type) {
		Insurance_Type = insurance_Type;
	}
	public String getInsurance_Description() {
		return Insurance_Description;
	}
	public void setInsurance_Description(String insurance_Description) {
		Insurance_Description = insurance_Description;
	}

}
