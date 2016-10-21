package com.balancika.hrms.app.entities.payroll;

import java.sql.Date;
import java.util.List;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Deduction {
	private String deductionID;
	private String deductionEmpID;
	private String deductionReason;
	private double deductionAmount;
	private Date deductionDate;
	private String deductionDescription;
	private String deductionStatus;
	
	public List<AuthorisationApproved> authorisationApproved;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getDeductionID() {
		return deductionID;
	}

	public void setDeductionID(String deductionID) {
		this.deductionID = deductionID;
	}

	public String getDeductionEmpID() {
		return deductionEmpID;
	}

	public void setDeductionEmpID(String deductionEmpID) {
		this.deductionEmpID = deductionEmpID;
	}

	public String getDeductionReason() {
		return deductionReason;
	}

	public void setDeductionReason(String deductionReason) {
		this.deductionReason = deductionReason;
	}

	public double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public Date getDeductionDate() {
		return deductionDate;
	}

	public void setDeductionDate(Date deductionDate) {
		this.deductionDate = deductionDate;
	}

	public String getDeductionDescription() {
		return deductionDescription;
	}

	public void setDeductionDescription(String deductionDescription) {
		this.deductionDescription = deductionDescription;
	}

	public String getDeductionStatus() {
		return deductionStatus;
	}

	public void setDeductionStatus(String deductionStatus) {
		this.deductionStatus = deductionStatus;
	}
}
