package com.balancika.hrms.app.services.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.authorisation.AuthorisationGroup;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AuthorisationGroupServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(AuthorisationGroup authorisationGroups);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(AuthorisationGroup authorisationGroups);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public AuthorisationGroup get(MeDataSource meDataSource, String ID);
	public AuthorisationGroup getOffset(MeDataSource meDataSource, long offset);
	public List<AuthorisationGroup> search(MeDataSource meDataSource, String ColumnName, String Value);
}
