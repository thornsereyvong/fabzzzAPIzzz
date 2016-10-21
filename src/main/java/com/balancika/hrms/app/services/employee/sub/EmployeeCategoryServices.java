package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Category;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeCategoryServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Category employeeCategories);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Category employeeCategories);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource,String ID);
	public Category get(MeDataSource meDataSource, String ID);
	public Category getOffset(MeDataSource meDataSource, long offset);
	public List<Category> search(MeDataSource meDataSource, String ColumnName, String Value);
}
