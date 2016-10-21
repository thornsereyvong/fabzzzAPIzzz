package com.balancika.hrms.app.entities.authorisation;

import java.util.List;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;

public class AuthorisationSub {
	public List<Supervisor> employee;
	public List<AuthorisationGroup> authorisationGroup;
}
