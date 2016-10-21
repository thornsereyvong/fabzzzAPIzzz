package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeEducation {
	
	private String Emp_ID;
	private String Edu_Name;
	private Date Edu_StartDate;
	private Date Edu_EndDate;
	private String Edu_Degree;
	private String Edu_School;
	private String Edu_Major;
	private String Edu_Description;
	private String Edu_AttachFile;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getEdu_Name() {
		return Edu_Name;
	}
	public void setEdu_Name(String edu_Name) {
		Edu_Name = edu_Name;
	}
	public Date getEdu_StartDate() {
		return Edu_StartDate;
	}
	public void setEdu_StartDate(Date edu_StartDate) {
		Edu_StartDate = edu_StartDate;
	}
	public Date getEdu_EndDate() {
		return Edu_EndDate;
	}
	public void setEdu_EndDate(Date edu_EndDate) {
		Edu_EndDate = edu_EndDate;
	}
	public String getEdu_Degree() {
		return Edu_Degree;
	}
	public void setEdu_Degree(String edu_Degree) {
		Edu_Degree = edu_Degree;
	}
	public String getEdu_School() {
		return Edu_School;
	}
	public void setEdu_School(String edu_School) {
		Edu_School = edu_School;
	}
	public String getEdu_Major() {
		return Edu_Major;
	}
	public void setEdu_Major(String edu_Major) {
		Edu_Major = edu_Major;
	}
	public String getEdu_Description() {
		return Edu_Description;
	}
	public void setEdu_Description(String edu_Description) {
		Edu_Description = edu_Description;
	}
	public String getEdu_AttachFile() {
		return Edu_AttachFile;
	}
	public void setEdu_AttachFile(String edu_AttachFile) {
		Edu_AttachFile = edu_AttachFile;
	}
	
	
}
