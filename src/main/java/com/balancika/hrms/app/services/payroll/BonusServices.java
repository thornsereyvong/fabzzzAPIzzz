package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Bonus;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface BonusServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Bonus bonus);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Bonus bonus);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Bonus get(MeDataSource meDataSource, String ID);
	public Bonus getOffset(MeDataSource meDataSource, long offset);
	public List<Bonus> search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> sub(MeDataSource meDataSource);
}
