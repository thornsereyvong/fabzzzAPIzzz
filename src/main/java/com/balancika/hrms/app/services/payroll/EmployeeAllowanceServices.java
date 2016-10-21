package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.EmployeeAllowances;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeAllowanceServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeAllowances employeeAllowances);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeAllowances employeeAllowances);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public EmployeeAllowances get(MeDataSource meDataSource, String ID);
	public EmployeeAllowances getOffset(MeDataSource meDataSource, long offset);
	public EmployeeAllowances search(MeDataSource meDataSource, String ColumnName, String Value);
}
