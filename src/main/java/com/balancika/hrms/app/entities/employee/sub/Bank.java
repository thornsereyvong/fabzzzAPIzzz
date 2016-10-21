package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Bank {
	
	private int Bank_ID;
	private String Bank_Name;
	private String Bank_Description;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public int getBank_ID() {
		return Bank_ID;
	}
	public String getBank_Name() {
		return Bank_Name;
	}
	public String getBank_Description() {
		return Bank_Description;
	}
	public void setBank_ID(int bank_ID) {
		Bank_ID = bank_ID;
	}
	public void setBank_Name(String bank_Name) {
		Bank_Name = bank_Name;
	}
	public void setBank_Description(String bank_Description) {
		Bank_Description = bank_Description;
	}
}
