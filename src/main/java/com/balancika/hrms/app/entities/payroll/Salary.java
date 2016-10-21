package com.balancika.hrms.app.entities.payroll;


import java.sql.Date;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Salary {
	private String salaryEmpID;
	private String salaryPayrollID;
	private String salaryType;
	private double salaryAmount;
	private Date salaryStartDate;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getSalaryEmpID() {
		return salaryEmpID;
	}

	public void setSalaryEmpID(String salaryEmpID) {
		this.salaryEmpID = salaryEmpID;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public double getSalaryAmount() {
		return salaryAmount;
	}

	public void setSalaryAmount(double salaryAmount) {
		this.salaryAmount = salaryAmount;
	}

	public String getSalaryPayrollID() {
		return salaryPayrollID;
	}

	public void setSalaryPayrollID(String salaryPayrollID) {
		this.salaryPayrollID = salaryPayrollID;
	}

	public Date getSalaryStartDate() {
		return salaryStartDate;
	}

	public void setSalaryStartDate(Date salaryStartDate) {
		this.salaryStartDate = salaryStartDate;
	}

}
