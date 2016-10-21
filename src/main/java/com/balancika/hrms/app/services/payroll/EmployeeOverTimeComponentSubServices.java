package com.balancika.hrms.app.services.payroll;

import com.balancika.hrms.app.entities.payroll.EmployeeOverTimeComponentSub;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeOverTimeComponentSubServices {
	public EmployeeOverTimeComponentSub get(MeDataSource meDataSource);
}
