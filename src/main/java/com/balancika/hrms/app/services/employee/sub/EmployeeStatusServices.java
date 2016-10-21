package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Status;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeStatusServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Status employeeStatus);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Status employeeStatus);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Status get(MeDataSource meDataSource, String ID);
	public Status getOffset(MeDataSource meDataSource, long offset);
	public List<Status> search(MeDataSource meDataSource, String ColumnName, String Value);
}
