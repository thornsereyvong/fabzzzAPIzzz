package com.balancika.hrms.app.services.authorisation;

import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisationSub;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeAuthorisationSubServices {
	
	public EmployeeAuthorisationSub get(MeDataSource meDataSource);
}
