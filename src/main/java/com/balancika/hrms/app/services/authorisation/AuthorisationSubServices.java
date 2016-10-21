package com.balancika.hrms.app.services.authorisation;

import com.balancika.hrms.app.entities.authorisation.AuthorisationSub;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AuthorisationSubServices {
	public AuthorisationSub get(MeDataSource meDataSource);
}
