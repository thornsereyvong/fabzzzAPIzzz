package com.balancika.hrms.app.entities.payroll;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Currency {
	private String currencyID;
	private String currencyName;
	private String currencyPlacing;
	private double currencyRate;
	private String currencyDescription;
	private boolean currencyDefault;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getCurrencyID() {
		return currencyID;
	}

	public void setCurrencyID(String currencyID) {
		this.currencyID = currencyID;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getCurrencyPlacing() {
		return currencyPlacing;
	}

	public void setCurrencyPlacing(String currencyPlacing) {
		this.currencyPlacing = currencyPlacing;
	}

	public double getCurrencyRate() {
		return currencyRate;
	}

	public void setCurrencyRate(double currencyRate) {
		this.currencyRate = currencyRate;
	}

	public String getCurrencyDescription() {
		return currencyDescription;
	}

	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}

	public boolean isCurrencyDefault() {
		return currencyDefault;
	}

	public void setCurrencyDefault(boolean currencyDefault) {
		this.currencyDefault = currencyDefault;
	}
	
	
	
}
