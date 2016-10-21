package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Department;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeDepartmentServices {
	
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Department employeeDepartments);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Department employeeDepartments);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Department get(MeDataSource meDataSource, String ID);
	public Department getOffset(MeDataSource meDataSource, long offset);
	public List<Department> search(MeDataSource meDataSource, String ColumnName, String Value);
}
