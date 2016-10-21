package com.balancika.hrms.app.entities.payroll;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class OverTimeComponent {
	private String oTComID;
	private String oTComName;
	private String otComPayType;
	private double otComPayAmount;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getoTComID() {
		return oTComID;
	}
	public void setoTComID(String oTComID) {
		this.oTComID = oTComID;
	}
	public String getoTComName() {
		return oTComName;
	}
	public void setoTComName(String oTComName) {
		this.oTComName = oTComName;
	}
	public String getOtComPayType() {
		return otComPayType;
	}
	public void setOtComPayType(String otComPayType) {
		this.otComPayType = otComPayType;
	}
	public double getOtComPayAmount() {
		return otComPayAmount;
	}
	public void setOtComPayAmount(double otComPayAmount) {
		this.otComPayAmount = otComPayAmount;
	}
}
