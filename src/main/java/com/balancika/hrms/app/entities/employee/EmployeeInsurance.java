package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeInsurance {
	private String Emp_ID;
	private int Ins_InsuranceID;
	private Date Ins_StartDate;
	private Date Ins_ExpireDate;
	private String Ins_Description;
	private double Ins_SumInsured;
	private double Ins_Premium;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public int getIns_InsuranceID() {
		return Ins_InsuranceID;
	}
	public Date getIns_StartDate() {
		return Ins_StartDate;
	}
	public Date getIns_ExpireDate() {
		return Ins_ExpireDate;
	}
	public String getIns_Description() {
		return Ins_Description;
	}
	public double getIns_SumInsured() {
		return Ins_SumInsured;
	}
	public double getIns_Premium() {
		return Ins_Premium;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public void setIns_InsuranceID(int ins_InsuranceID) {
		Ins_InsuranceID = ins_InsuranceID;
	}
	public void setIns_StartDate(Date ins_StartDate) {
		Ins_StartDate = ins_StartDate;
	}
	public void setIns_ExpireDate(Date ins_ExpireDate) {
		Ins_ExpireDate = ins_ExpireDate;
	}
	public void setIns_Description(String ins_Description) {
		Ins_Description = ins_Description;
	}
	public void setIns_SumInsured(double ins_SumInsured) {
		Ins_SumInsured = ins_SumInsured;
	}
	public void setIns_Premium(double ins_Premium) {
		Ins_Premium = ins_Premium;
	}
}
