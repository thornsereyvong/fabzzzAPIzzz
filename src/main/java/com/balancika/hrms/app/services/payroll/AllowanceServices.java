package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.Allowance;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface AllowanceServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Allowance allowance);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Allowance allowance);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Allowance get(MeDataSource meDataSource, String ID);
	public Allowance getOffset(MeDataSource meDataSource, long offset);
	public List<Allowance> search(MeDataSource meDataSource, String ColumnName, String Value);
}	
