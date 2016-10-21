package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeMemberShip {
	
	private String Emp_ID;
	private String Mem_Name;
	private String Mem_Institute;
	private Date Mem_GrantedOn;
	private Date Mem_ValidThru;
	private String Mem_Type;
	private String Mem_Description;
	private String Mem_Attachfile;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public String getMem_Name() {
		return Mem_Name;
	}
	public String getMem_Institute() {
		return Mem_Institute;
	}
	public Date getMem_GrantedOn() {
		return Mem_GrantedOn;
	}
	public Date getMem_ValidThru() {
		return Mem_ValidThru;
	}
	public String getMem_Description() {
		return Mem_Description;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public void setMem_Name(String mem_Name) {
		Mem_Name = mem_Name;
	}
	public void setMem_Institute(String mem_Institute) {
		Mem_Institute = mem_Institute;
	}
	public void setMem_GrantedOn(Date mem_GrantedOn) {
		Mem_GrantedOn = mem_GrantedOn;
	}
	public void setMem_ValidThru(Date mem_ValidThru) {
		Mem_ValidThru = mem_ValidThru;
	}
	public void setMem_Description(String mem_Description) {
		Mem_Description = mem_Description;
	}
	public String getMem_Type() {
		return Mem_Type;
	}
	public void setMem_Type(String mem_Type) {
		Mem_Type = mem_Type;
	}
	public String getMem_Attachfile() {
		return Mem_Attachfile;
	}
	public void setMem_Attachfile(String mem_Attachfile) {
		Mem_Attachfile = mem_Attachfile;
	}
	
	
	

}
