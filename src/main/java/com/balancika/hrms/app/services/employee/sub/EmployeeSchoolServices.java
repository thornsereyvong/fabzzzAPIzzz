package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.School;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeSchoolServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(School schools);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(School schools);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public School get(MeDataSource meDataSource, String ID);
	public School getOffset(MeDataSource meDataSource, long offset);
	public List<School> search(MeDataSource meDataSource, String ColumnName, String Value);
}
