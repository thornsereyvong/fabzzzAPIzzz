package com.balancika.hrms.app.entities.authorisation;

public class AuthorisationDetail {
	private String authID;
	private String authEmpID;
	private String authGroupID;
	private String authGroupAndOr;
	private int authGroupAmount;
	
	public String getAuthID() {
		return authID;
	}
	public void setAuthID(String authID) {
		this.authID = authID;
	}
	public String getAuthEmpID() {
		return authEmpID;
	}
	public void setAuthEmpID(String authEmpID) {
		this.authEmpID = authEmpID;
	}
	public String getAuthGroupID() {
		return authGroupID;
	}
	public void setAuthGroupID(String authGroupID) {
		this.authGroupID = authGroupID;
	}
	public String getAuthGroupAndOr() {
		return authGroupAndOr;
	}
	public void setAuthGroupAndOr(String authGroupAndOr) {
		this.authGroupAndOr = authGroupAndOr;
	}
	public int getAuthGroupAmount() {
		return authGroupAmount;
	}
	public void setAuthGroupAmount(int authGroupAmount) {
		this.authGroupAmount = authGroupAmount;
	}
	
}
