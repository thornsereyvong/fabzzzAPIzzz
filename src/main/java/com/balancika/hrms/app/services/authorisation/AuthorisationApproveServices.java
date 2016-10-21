package com.balancika.hrms.app.services.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApprove;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AuthorisationApproveServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(AuthorisationApprove authorisationApprove);
	public List<AuthorisationApprove> get(MeDataSource meDataSource, String ID);
}
