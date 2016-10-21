package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Deduction;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface DeductionServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Deduction deduction);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Deduction deduction);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Deduction get(MeDataSource meDataSource, String ID);
	public Deduction getOffset(MeDataSource meDataSource, long offset);
	public List<Deduction> search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> sub(MeDataSource meDataSource);
}
