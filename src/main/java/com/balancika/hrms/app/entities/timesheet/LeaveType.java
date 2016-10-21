package com.balancika.hrms.app.entities.timesheet;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class LeaveType {
	private String leaveTypeID;
	private String leaveTypeName;
	private String leaveTypePayStatus;
	private int leaveTypeYear;
	private String leaveTypeAmountAllowed;
	private String leaveTypeGenderRestriction;
	private String leaveTypePaidType;
	private double leaveTypePaidValue;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getLeaveTypeID() {
		return leaveTypeID;
	}
	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public String getLeaveTypeName() {
		return leaveTypeName;
	}
	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}
	public String getLeaveTypePayStatus() {
		return leaveTypePayStatus;
	}
	public void setLeaveTypePayStatus(String leaveTypePayStatus) {
		this.leaveTypePayStatus = leaveTypePayStatus;
	}
	public String getLeaveTypeAmountAllowed() {
		return leaveTypeAmountAllowed;
	}
	public void setLeaveTypeAmountAllowed(String leaveTypeAmountAllowed) {
		this.leaveTypeAmountAllowed = leaveTypeAmountAllowed;
	}
	public String getLeaveTypeGenderRestriction() {
		return leaveTypeGenderRestriction;
	}
	public void setLeaveTypeGenderRestriction(String leaveTypeGenderRestriction) {
		this.leaveTypeGenderRestriction = leaveTypeGenderRestriction;
	}
	public String getLeaveTypePaidType() {
		return leaveTypePaidType;
	}
	public void setLeaveTypePaidType(String leaveTypePaidType) {
		this.leaveTypePaidType = leaveTypePaidType;
	}
	public double getLeaveTypePaidValue() {
		return leaveTypePaidValue;
	}
	public void setLeaveTypePaidValue(double leaveTypePaidValue) {
		this.leaveTypePaidValue = leaveTypePaidValue;
	}
	public int getLeaveTypeYear() {
		return leaveTypeYear;
	}
	public void setLeaveTypeYear(int leaveTypeYear) {
		this.leaveTypeYear = leaveTypeYear;
	}
	
	
}
