package com.balancika.hrms.app.services.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.timesheet.Leave;
import com.balancika.hrms.app.entities.timesheet.LeaveSummary;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface LeaveServices{
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Leave leave);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Leave leave);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Leave get(MeDataSource meDataSource, String ID);
	public List<Leave> search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> Sub(MeDataSource meDataSource);
	public List<LeaveSummary> Sub(MeDataSource meDataSource, String empID, int year);
}
