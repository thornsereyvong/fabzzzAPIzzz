package com.balancika.hrms.app.entities.employee;

import java.sql.Date;

public class EmployeeTraining {
	private String Emp_ID;
	private String Train_InstituteName;
	private String Train_Certificate;
	private String Train_Course;
	private Date Train_StartDate;
	private Date Train_EndDate;
	private String Train_Description;
	private String Train_AttachFile;

	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getTrain_InstituteName() {
		return Train_InstituteName;
	}
	public void setTrain_InstituteName(String train_InstituteName) {
		Train_InstituteName = train_InstituteName;
	}
	public String getTrain_Certificate() {
		return Train_Certificate;
	}
	public void setTrain_Certificate(String train_Certificate) {
		Train_Certificate = train_Certificate;
	}
	public String getTrain_Course() {
		return Train_Course;
	}
	public void setTrain_Course(String train_Course) {
		Train_Course = train_Course;
	}
	public Date getTrain_StartDate() {
		return Train_StartDate;
	}
	public void setTrain_StartDate(Date train_StartDate) {
		Train_StartDate = train_StartDate;
	}
	public Date getTrain_EndDate() {
		return Train_EndDate;
	}
	public void setTrain_EndDate(Date train_EndDate) {
		Train_EndDate = train_EndDate;
	}
	public String getTrain_Description() {
		return Train_Description;
	}
	public void setTrain_Description(String train_Description) {
		Train_Description = train_Description;
	}
	public String getTrain_AttachFile() {
		return Train_AttachFile;
	}
	public void setTrain_AttachFile(String train_AttachFile) {
		Train_AttachFile = train_AttachFile;
	}

}
