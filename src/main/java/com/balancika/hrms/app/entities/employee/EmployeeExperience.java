package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeExperience {
	
	private String Emp_ID;
	private String Ex_Position;
	private String Ex_Company;
	private Date Ex_StartDate;
	private Date Ex_EndDate;
	private String Ex_Description;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getEx_Position() {
		return Ex_Position;
	}
	public void setEx_Position(String ex_Position) {
		Ex_Position = ex_Position;
	}
	public String getEx_Company() {
		return Ex_Company;
	}
	public void setEx_Company(String ex_Company) {
		Ex_Company = ex_Company;
	}
	public Date getEx_StartDate() {
		return Ex_StartDate;
	}
	public void setEx_StartDate(Date ex_StartDate) {
		Ex_StartDate = ex_StartDate;
	}
	public Date getEx_EndDate() {
		return Ex_EndDate;
	}
	public void setEx_EndDate(Date ex_EndDate) {
		Ex_EndDate = ex_EndDate;
	}
	public String getEx_Description() {
		return Ex_Description;
	}
	public void setEx_Description(String ex_Description) {
		Ex_Description = ex_Description;
	}
	
	

}
