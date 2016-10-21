package com.balancika.hrms.app.entities.payroll;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Allowance {
	private String allowanceID;
	private String allowanceName;
	private String allowancePayType;
	private double allowancePayAmount;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getAllowanceID() {
		return allowanceID;
	}

	public void setAllowanceID(String allowanceID) {
		this.allowanceID = allowanceID;
	}

	public String getAllowanceName() {
		return allowanceName;
	}

	public void setAllowanceName(String allowanceName) {
		this.allowanceName = allowanceName;
	}

	public String getAllowancePayType() {
		return allowancePayType;
	}

	public void setAllowancePayType(String allowancePayType) {
		this.allowancePayType = allowancePayType;
	}

	public double getAllowancePayAmount() {
		return allowancePayAmount;
	}

	public void setAllowancePayAmount(double allowancePayAmount) {
		this.allowancePayAmount = allowancePayAmount;
	}
}
