package com.balancika.hrms.app.services.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.timesheet.EmployeeLeaveTypes;
import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeLeaveTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeLeaveTypes employeeLeaveTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeLeaveTypes employeeLeaveTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public EmployeeLeaveTypes get(MeDataSource meDataSource, String ID);
	public EmployeeLeaveTypes search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> Sub(MeDataSource meDataSource);
	public List<LeaveType> Sub(MeDataSource meDataSource, String ID, int Year);
}
