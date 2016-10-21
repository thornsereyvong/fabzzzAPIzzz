package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Language;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeLanguageServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Language employeeLanguages);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Language employeeLanguages);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Language get(MeDataSource meDataSource, String ID);
	public Language getOffset(MeDataSource meDataSource, long offset);
	public List<Language> search(MeDataSource meDataSource, String ColumnName, String Value);
}
