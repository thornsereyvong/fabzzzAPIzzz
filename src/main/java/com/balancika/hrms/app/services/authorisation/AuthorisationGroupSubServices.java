package com.balancika.hrms.app.services.authorisation;

import java.util.List;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AuthorisationGroupSubServices {
	public List<Supervisor> get(MeDataSource meDataSource);
}
