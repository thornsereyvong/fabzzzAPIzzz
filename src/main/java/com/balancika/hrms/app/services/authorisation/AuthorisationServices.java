package com.balancika.hrms.app.services.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.authorisation.Authorisation;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AuthorisationServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Authorisation authorisations);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Authorisation authorisations);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Authorisation get(MeDataSource meDataSource, String ID);
	public Authorisation getOffset(MeDataSource meDataSource, long offset);
	public List<Authorisation> search(MeDataSource meDataSource, String ColumnName, String Value);
}
