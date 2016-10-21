package com.balancika.hrms.app.entities.authorisation;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AuthorisationApprove {
	private String authProcessID;
	private String authProcessName;
	private String authID;
	private String authGroupID;
	private String authEmpID;
	private String authStatus;
	private boolean authEdit;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	
	public String getAuthProcessID() {
		return authProcessID;
	}

	public void setAuthProcessID(String authProcessID) {
		this.authProcessID = authProcessID;
	}

	public String getAuthProcessName() {
		return authProcessName;
	}

	public void setAuthProcessName(String authProcessName) {
		this.authProcessName = authProcessName;
	}

	public String getAuthID() {
		return authID;
	}

	public void setAuthID(String authID) {
		this.authID = authID;
	}

	public String getAuthGroupID() {
		return authGroupID;
	}

	public void setAuthGroupID(String authGroupID) {
		this.authGroupID = authGroupID;
	}

	public String getAuthEmpID() {
		return authEmpID;
	}

	public void setAuthEmpID(String authEmpID) {
		this.authEmpID = authEmpID;
	}

	public String getAuthStatus() {
		return authStatus;
	}

	public void setAuthStatus(String authStatus) {
		this.authStatus = authStatus;
	}

	public boolean isAuthEdit() {
		return authEdit;
	}

	public void setAuthEdit(boolean authEdit) {
		this.authEdit = authEdit;
	}
	
}
