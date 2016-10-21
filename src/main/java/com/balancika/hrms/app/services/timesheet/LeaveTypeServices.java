package com.balancika.hrms.app.services.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface LeaveTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(LeaveType leaveType);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(LeaveType leaveType);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public LeaveType get(MeDataSource meDataSource, String ID);
	public List<LeaveType> search(MeDataSource meDataSource, String ColumnName, String Value);
}
