package com.balancika.hrms.app.entities.payroll;

import java.sql.Date;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Payroll {
	private String payrollID;
	private String payrollName;
	private String payrollType;
	private Date payrollStartDate;
	private Date payrollLastSubmitDate;
	private Date payrollSubmitDate;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getPayrollID() {
		return payrollID;
	}

	public void setPayrollID(String payrollID) {
		this.payrollID = payrollID;
	}

	public String getPayrollName() {
		return payrollName;
	}

	public void setPayrollName(String payrollName) {
		this.payrollName = payrollName;
	}

	public String getPayrollType() {
		return payrollType;
	}

	public void setPayrollType(String payrollType) {
		this.payrollType = payrollType;
	}

	public Date getPayrollStartDate() {
		return payrollStartDate;
	}

	public void setPayrollStartDate(Date payrollStartDate) {
		this.payrollStartDate = payrollStartDate;
	}

	public Date getPayrollLastSubmitDate() {
		return payrollLastSubmitDate;
	}

	public void setPayrollLastSubmitDate(Date payrollLastSubmitDate) {
		this.payrollLastSubmitDate = payrollLastSubmitDate;
	}

	public Date getPayrollSubmitDate() {
		return payrollSubmitDate;
	}

	public void setPayrollSubmitDate(Date payrollSubmitDate) {
		this.payrollSubmitDate = payrollSubmitDate;
	}
	
	
}
