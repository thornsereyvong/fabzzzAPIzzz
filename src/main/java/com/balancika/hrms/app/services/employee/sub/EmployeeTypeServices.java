package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Type;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Type employeeTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Type employeeTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String TypeName);
	public Type get(MeDataSource meDataSource, String ID);
	public Type getOffset(MeDataSource meDataSource, long offset);
	public List<Type> search(MeDataSource meDataSource, String ColumnName, String Value);
}
