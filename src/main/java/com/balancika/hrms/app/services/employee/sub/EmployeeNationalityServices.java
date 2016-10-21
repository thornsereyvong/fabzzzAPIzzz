package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Nationality;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeNationalityServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Nationality nationalities);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Nationality nationalities);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String Name);
	public Nationality get(MeDataSource meDataSource, String ID);
	public Nationality getOffset(MeDataSource meDataSource, long offset);
	public List<Nationality> search(MeDataSource meDataSource, String ColumnName, String Value);
}
