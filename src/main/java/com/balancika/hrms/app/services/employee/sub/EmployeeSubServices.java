package com.balancika.hrms.app.services.employee.sub;

import com.balancika.hrms.app.entities.employee.sub.EmployeeSub;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeSubServices {
	public EmployeeSub get(MeDataSource meDataSource);
	public EmployeeSub get(MeDataSource meDataSource, String ID);
}
