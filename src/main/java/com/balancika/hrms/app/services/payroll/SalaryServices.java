package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.Salary;
import com.balancika.hrms.app.entities.payroll.SalarySub;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface SalaryServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Salary salary);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Salary salary);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public List<Salary> get(MeDataSource meDataSource, String ID);
	public Salary getOffset(MeDataSource meDataSource, long offset);
	public List<Salary> search(MeDataSource meDataSource, String ColumnName, String Value);
	public SalarySub Sub(MeDataSource meDataSource);
}
