package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Nationals;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeNationalsServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Nationals nationals);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Nationals nationals);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String Name);
	public Nationals get(MeDataSource meDataSource, String ID);
	public Nationals getOffset(MeDataSource meDataSource, long offset);
	public List<Nationals> search(MeDataSource meDataSource, String ColumnName, String Value);
}
