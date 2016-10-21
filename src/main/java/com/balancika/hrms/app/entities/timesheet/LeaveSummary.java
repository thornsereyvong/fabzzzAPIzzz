package com.balancika.hrms.app.entities.timesheet;

public class LeaveSummary extends LeaveType {
	private float leaveTaken;
	private float leavePending;
	private float leaveBalance;
	
	public float getLeaveTaken() {
		return leaveTaken;
	}
	public void setLeaveTaken(float leaveTaken) {
		this.leaveTaken = leaveTaken;
	}
	public float getLeavePending() {
		return leavePending;
	}
	public void setLeavePending(float leavePending) {
		this.leavePending = leavePending;
	}
	public float getLeaveBalance() {
		return leaveBalance;
	}
	public void setLeaveBalance(float leaveBalance) {
		this.leaveBalance = leaveBalance;
	}
}
