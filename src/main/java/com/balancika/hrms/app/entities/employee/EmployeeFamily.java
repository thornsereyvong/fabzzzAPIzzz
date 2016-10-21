package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeFamily {
	private String Emp_ID;
	private String Fam_Name;
	private String Fam_NameKh;
	private Date Fam_DOB;
	private String Fam_Relative;
	private String Fam_Occupation;
	private String Fam_Tel;
	private int Fam_TaxDeduct;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getFam_Name() {
		return Fam_Name;
	}
	public void setFam_Name(String fam_Name) {
		Fam_Name = fam_Name;
	}
	public String getFam_NameKh() {
		return Fam_NameKh;
	}
	public void setFam_NameKh(String fam_NameKh) {
		Fam_NameKh = fam_NameKh;
	}
	public String getFam_Relative() {
		return Fam_Relative;
	}
	public void setFam_Relative(String fam_Relative) {
		Fam_Relative = fam_Relative;
	}
	public String getFam_Occupation() {
		return Fam_Occupation;
	}
	public void setFam_Occupation(String fam_Occupation) {
		Fam_Occupation = fam_Occupation;
	}
	public String getFam_Tel() {
		return Fam_Tel;
	}
	public void setFam_Tel(String fam_Tel) {
		Fam_Tel = fam_Tel;
	}
	public Date getFam_DOB() {
		return Fam_DOB;
	}
	public void setFam_DOB(Date fam_DOB) {
		Fam_DOB = fam_DOB;
	}
	public int getFam_TaxDeduct() {
		return Fam_TaxDeduct;
	}
	public void setFam_TaxDeduct(int fam_TaxDeduct) {
		Fam_TaxDeduct = fam_TaxDeduct;
	}
	
	

}
