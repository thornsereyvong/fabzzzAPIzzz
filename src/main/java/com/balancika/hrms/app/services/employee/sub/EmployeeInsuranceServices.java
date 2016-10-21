package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Insurance;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeInsuranceServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Insurance insurances);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Insurance insurances);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Insurance get(MeDataSource meDataSource, String ID);
	public Insurance getOffset(MeDataSource meDataSource, long offset);
	public List<Insurance> search(MeDataSource meDataSource, String ColumnName, String Value);
}
