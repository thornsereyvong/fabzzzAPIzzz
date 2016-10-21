package com.balancika.hrms.app.services.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisations;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeAuthorisationServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeAuthorisations employeeAuthorisations);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public EmployeeAuthorisations get(MeDataSource meDataSource, String ID);
	public EmployeeAuthorisations getOffset(MeDataSource meDataSource, long offset);
	public EmployeeAuthorisations search(MeDataSource meDataSource, String ColumnName, String Value);
}
