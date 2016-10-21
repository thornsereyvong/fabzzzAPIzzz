package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.Payroll;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface PayrollServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Payroll payroll);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Payroll payroll);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Payroll get(MeDataSource meDataSource, String ID);
	public Payroll getOffset(MeDataSource meDataSource, long offset);
	public List<Payroll> search(MeDataSource meDataSource, String ColumnName, String Value);
}
