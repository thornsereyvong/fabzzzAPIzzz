package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Bank;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeBankServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Bank employeeBanks);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Bank employeeBanks);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Bank get(MeDataSource meDataSource, String ID);
	public Bank getOffset(MeDataSource meDataSource, long offset);
	public List<Bank> search(MeDataSource meDataSource, String ColumnName, String Value);

}
