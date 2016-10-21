package com.balancika.hrms.app.entities.authorisation;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Authorisation {
	private String authID;
	private String authName;
	private String authType;
	private String authAndOr;
	private int authAmount;
	
	public List<AuthorisationDetail> authorisationDetail;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getAuthID() {
		return authID;
	}

	public void setAuthID(String authID) {
		this.authID = authID;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getAuthType() {
		return authType;
	}

	public void setAuthType(String authType) {
		this.authType = authType;
	}

	public String getAuthAndOr() {
		return authAndOr;
	}

	public void setAuthAndOr(String authAndOr) {
		this.authAndOr = authAndOr;
	}

	public int getAuthAmount() {
		return authAmount;
	}

	public void setAuthAmount(int authAmount) {
		this.authAmount = authAmount;
	}
	
}
