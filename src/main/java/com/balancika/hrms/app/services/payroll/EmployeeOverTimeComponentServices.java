package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.EmployeeOverTimeComponents;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeOverTimeComponentServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeOverTimeComponents employeeOverTimeComponents);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeOverTimeComponents employeeOverTimeComponents);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public EmployeeOverTimeComponents get(MeDataSource meDataSource, String ID);
	public EmployeeOverTimeComponents getOffset(MeDataSource meDataSource, long offset);
	public EmployeeOverTimeComponents search(MeDataSource meDataSource, String ColumnName, String Value);
}
