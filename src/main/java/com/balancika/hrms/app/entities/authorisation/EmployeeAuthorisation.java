package com.balancika.hrms.app.entities.authorisation;

public class EmployeeAuthorisation {
	private String EmpID;
	private String AuthProcess;
	private String AuthID;
	
	public String getEmpID() {
		return EmpID;
	}
	public void setEmpID(String empID) {
		EmpID = empID;
	}
	public String getAuthProcess() {
		return AuthProcess;
	}
	public void setAuthProcess(String authProcess) {
		AuthProcess = authProcess;
	}
	public String getAuthID() {
		return AuthID;
	}
	public void setAuthID(String authID) {
		AuthID = authID;
	}

}
