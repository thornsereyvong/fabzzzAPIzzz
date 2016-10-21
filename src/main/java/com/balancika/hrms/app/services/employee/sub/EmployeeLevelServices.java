package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Level;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeLevelServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Level employeeLevels);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Level employeeLevels);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Level get(MeDataSource meDataSource, String ID);
	public Level getOffset(MeDataSource meDataSource, long offset);
	public List<Level> search(MeDataSource meDataSource, String ColumnName, String Value);
}
