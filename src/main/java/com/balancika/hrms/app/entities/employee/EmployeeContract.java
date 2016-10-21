package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeContract {
	private String Emp_ID;
	private String Con_Name;
	private String Con_Type;
	private Date Con_StartDate;
	private Date Con_EndDate;
	private String Con_Description;
	private int Con_EmpPositionID;
	private String Con_EmpType;
	private String Con_EmpCategory;
	private String Con_EmpGrade;
	private int Con_EmpBranchID;
	private int Con_EmpDepartmentID;
	private String Con_AttachFile;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getCon_Name() {
		return Con_Name;
	}
	public void setCon_Name(String con_Name) {
		Con_Name = con_Name;
	}
	public String getCon_Type() {
		return Con_Type;
	}
	public void setCon_Type(String con_Type) {
		Con_Type = con_Type;
	}
	public Date getCon_StartDate() {
		return Con_StartDate;
	}
	public void setCon_StartDate(Date con_StartDate) {
		Con_StartDate = con_StartDate;
	}
	public Date getCon_EndDate() {
		return Con_EndDate;
	}
	public void setCon_EndDate(Date con_EndDate) {
		Con_EndDate = con_EndDate;
	}
	public String getCon_Description() {
		return Con_Description;
	}
	public void setCon_Description(String con_Description) {
		Con_Description = con_Description;
	}
	public int getCon_EmpPositionID() {
		return Con_EmpPositionID;
	}
	public void setCon_EmpPositionID(int con_EmpPositionID) {
		Con_EmpPositionID = con_EmpPositionID;
	}
	public String getCon_EmpType() {
		return Con_EmpType;
	}
	public void setCon_EmpType(String con_EmpType) {
		Con_EmpType = con_EmpType;
	}
	public String getCon_EmpCategory() {
		return Con_EmpCategory;
	}
	public void setCon_EmpCategory(String con_EmpCategory) {
		Con_EmpCategory = con_EmpCategory;
	}
	public String getCon_EmpGrade() {
		return Con_EmpGrade;
	}
	public void setCon_EmpGrade(String con_EmpGrade) {
		Con_EmpGrade = con_EmpGrade;
	}
	public int getCon_EmpBranchID() {
		return Con_EmpBranchID;
	}
	public void setCon_EmpBranchID(int con_EmpBranchID) {
		Con_EmpBranchID = con_EmpBranchID;
	}
	public int getCon_EmpDepartmentID() {
		return Con_EmpDepartmentID;
	}
	public void setCon_EmpDepartmentID(int con_EmpDepartmentID) {
		Con_EmpDepartmentID = con_EmpDepartmentID;
	}
	public String getCon_AttachFile() {
		return Con_AttachFile;
	}
	public void setCon_AttachFile(String con_AttachFile) {
		Con_AttachFile = con_AttachFile;
	}
		
}
