package com.balancika.hrms.app.entities.payroll;

import java.sql.Date;
import java.util.List;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Bonus {
	private String bonusID;
	private String bonusEmpID;
	private Date bonusDate;
	private String bonusReason;
	private double bonusAmount;
	private String bonusDescription;
	private String bonusStatus;
	
	public List<AuthorisationApproved> authorisationApproved;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getBonusID() {
		return bonusID;
	}
	public void setBonusID(String bonusID) {
		this.bonusID = bonusID;
	}
	public String getBonusEmpID() {
		return bonusEmpID;
	}
	public void setBonusEmpID(String bonusEmpID) {
		this.bonusEmpID = bonusEmpID;
	}
	public Date getBonusDate() {
		return bonusDate;
	}
	public void setBonusDate(Date bonusDate) {
		this.bonusDate = bonusDate;
	}
	public String getBonusReason() {
		return bonusReason;
	}
	public void setBonusReason(String bonusReason) {
		this.bonusReason = bonusReason;
	}
	public double getBonusAmount() {
		return bonusAmount;
	}
	public void setBonusAmount(double bonusAmount) {
		this.bonusAmount = bonusAmount;
	}
	public String getBonusDescription() {
		return bonusDescription;
	}
	public void setBonusDescription(String bonusDescription) {
		this.bonusDescription = bonusDescription;
	}
	public String getBonusStatus() {
		return bonusStatus;
	}
	public void setBonusStatus(String bonusStatus) {
		this.bonusStatus = bonusStatus;
	}
}
