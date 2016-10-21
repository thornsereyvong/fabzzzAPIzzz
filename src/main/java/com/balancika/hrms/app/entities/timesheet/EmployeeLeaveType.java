package com.balancika.hrms.app.entities.timesheet;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeLeaveType {
	private String leaveEmpID;
	private int leaveYear;
	private String leaveTypeID;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getLeaveEmpID() {
		return leaveEmpID;
	}

	public void setLeaveEmpID(String leaveEmpID) {
		this.leaveEmpID = leaveEmpID;
	}

	public int getLeaveYear() {
		return leaveYear;
	}

	public void setLeaveYear(int leaveYear) {
		this.leaveYear = leaveYear;
	}

	public String getLeaveTypeID() {
		return leaveTypeID;
	}

	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	
}
