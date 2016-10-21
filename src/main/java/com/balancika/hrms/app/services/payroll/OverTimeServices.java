package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.OverTime;
import com.balancika.hrms.app.entities.payroll.OverTimeComponent;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface OverTimeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(OverTime overTime);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(OverTime overTime);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public OverTime get(MeDataSource meDataSource, String ID);
	public OverTime getOffset(MeDataSource meDataSource, long offset);
	public List<OverTime> search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> sub(MeDataSource meDataSource);
	public List<OverTimeComponent> SubSearchOvertime(MeDataSource meDataSource, String ID);
}
