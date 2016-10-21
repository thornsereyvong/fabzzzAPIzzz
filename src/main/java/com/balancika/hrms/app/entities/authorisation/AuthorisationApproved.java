package com.balancika.hrms.app.entities.authorisation;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;

public class AuthorisationApproved extends Supervisor {
	private String Auth_Status;

	public String getAuth_Status() {
		return Auth_Status;
	}

	public void setAuth_Status(String auth_Status) {
		Auth_Status = auth_Status;
	}
}
