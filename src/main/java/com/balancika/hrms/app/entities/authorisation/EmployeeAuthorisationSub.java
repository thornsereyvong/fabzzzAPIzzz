package com.balancika.hrms.app.entities.authorisation;

import java.util.List;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;

public class EmployeeAuthorisationSub {
	public List<Supervisor> employee;
	public List<AuthorisationProcess> authorisationProcess;
	public List<Authorisation> authorisation;
}
