package com.balancika.hrms.app.entities.payroll;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class OverTime {
	private String overtimeID;
	private String overtimeEmpID;
	private String overtimeOTComID;
	private float overtimeHours;
	private Date overtimeDate;
	private String overtimeReason;
	private Time overtimeTimeIn;
	private Time overtimeTimeOut;
	private String overtimeDescription;
	private String overtimeStatus;
	
	public List<AuthorisationApproved> authorisationApproved;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getOvertimeID() {
		return overtimeID;
	}
	public void setOvertimeID(String overtimeID) {
		this.overtimeID = overtimeID;
	}
	public String getOvertimeEmpID() {
		return overtimeEmpID;
	}
	public void setOvertimeEmpID(String overtimeEmpID) {
		this.overtimeEmpID = overtimeEmpID;
	}
	public String getOvertimeOTComID() {
		return overtimeOTComID;
	}
	public void setOvertimeOTComID(String overtimeOTComID) {
		this.overtimeOTComID = overtimeOTComID;
	}
	public float getOvertimeHours() {
		return overtimeHours;
	}
	public void setOvertimeHours(float overtimeHours) {
		this.overtimeHours = overtimeHours;
	}
	public Date getOvertimeDate() {
		return overtimeDate;
	}
	public void setOvertimeDate(Date overtimeDate) {
		this.overtimeDate = overtimeDate;
	}
	public String getOvertimeReason() {
		return overtimeReason;
	}
	public void setOvertimeReason(String overtimeReason) {
		this.overtimeReason = overtimeReason;
	}
	public Time getOvertimeTimeIn() {
		return overtimeTimeIn;
	}
	public void setOvertimeTimeIn(Time overtimeTimeIn) {
		this.overtimeTimeIn = overtimeTimeIn;
	}
	public Time getOvertimeTimeOut() {
		return overtimeTimeOut;
	}
	public void setOvertimeTimeOut(Time overtimeTimeOut) {
		this.overtimeTimeOut = overtimeTimeOut;
	}
	public String getOvertimeDescription() {
		return overtimeDescription;
	}
	public void setOvertimeDescription(String overtimeDescription) {
		this.overtimeDescription = overtimeDescription;
	}
	public String getOvertimeStatus() {
		return overtimeStatus;
	}
	public void setOvertimeStatus(String overtimeStatus) {
		this.overtimeStatus = overtimeStatus;
	}
}
