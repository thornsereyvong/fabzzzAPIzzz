package com.balancika.hrms.app.entities.timesheet;

import java.util.Date;
import java.util.List;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.tool.CustomDateDeserializer;
import com.balancika.hrms.app.tool.CustomDateSerializer;
import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Leave {
	private String leaveID;
	private String leaveEmpID;
	private String leaveTel;
	private String leaveEmail;
	private String leaveReason;
	private String leaveDuration;
	
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date leaveFrom;
	@JsonDeserialize(using = CustomDateDeserializer.class)
	private Date leaveTo;
	
	private float leaveTotal;
	private String leaveTypeID;
	private String leaveDescription;
	private String leaveAttachmentName;
	private String leaveAttachmentPath;
	private String leaveStatus;
	
	public List<AuthorisationApproved> authorisationApproved;
	
	public List<LeaveSummary> leaveSummary;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getLeaveID() {
		return leaveID;
	}
	public void setLeaveID(String leaveID) {
		this.leaveID = leaveID;
	}
	public String getLeaveEmpID() {
		return leaveEmpID;
	}
	public void setLeaveEmpID(String leaveEmpID) {
		this.leaveEmpID = leaveEmpID;
	}
	public String getLeaveTel() {
		return leaveTel;
	}
	public void setLeaveTel(String leaveTel) {
		this.leaveTel = leaveTel;
	}
	public String getLeaveEmail() {
		return leaveEmail;
	}
	public void setLeaveEmail(String leaveEmail) {
		this.leaveEmail = leaveEmail;
	}
	public String getLeaveReason() {
		return leaveReason;
	}
	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}
	public String getLeaveDuration() {
		return leaveDuration;
	}
	public void setLeaveDuration(String leaveDuration) {
		this.leaveDuration = leaveDuration;
	}
	public Date getLeaveFrom() {
		return leaveFrom;
	}
	
	@JsonSerialize(using = CustomDateSerializer.class)
	public void setLeaveFrom(Date leaveFrom) {
		this.leaveFrom = leaveFrom;
	}
	
	public Date getLeaveTo() {
		return leaveTo;
	}
	
	@JsonSerialize(using = CustomDateSerializer.class)
	public void setLeaveTo(Date leaveTo) {
		this.leaveTo = leaveTo;
	}
	
	public float getLeaveTotal() {
		return leaveTotal;
	}
	public void setLeaveTotal(float leaveTotal) {
		this.leaveTotal = leaveTotal;
	}
	public String getLeaveTypeID() {
		return leaveTypeID;
	}
	public void setLeaveTypeID(String leaveTypeID) {
		this.leaveTypeID = leaveTypeID;
	}
	public String getLeaveDescription() {
		return leaveDescription;
	}
	public void setLeaveDescription(String leaveDescription) {
		this.leaveDescription = leaveDescription;
	}
	public String getLeaveAttachmentName() {
		return leaveAttachmentName;
	}
	public void setLeaveAttachmentName(String leaveAttachmentName) {
		this.leaveAttachmentName = leaveAttachmentName;
	}
	public String getLeaveAttachmentPath() {
		return leaveAttachmentPath;
	}
	public void setLeaveAttachmentPath(String leaveAttachmentPath) {
		this.leaveAttachmentPath = leaveAttachmentPath;
	}
	public String getLeaveStatus() {
		return leaveStatus;
	}
	public void setLeaveStatus(String leaveStatus) {
		this.leaveStatus = leaveStatus;
	}
	
}
