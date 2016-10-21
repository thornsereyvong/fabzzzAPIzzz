package com.balancika.hrms.app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import com.balancika.hrms.app.entities.employee.Employee;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Employee employee, HttpServletRequest servletRequest);
	public boolean update(Employee mainemployee, HttpServletRequest servletRequest);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Employee get(MeDataSource meDataSource, String ID);
	public Employee getOffset(MeDataSource meDataSource, long offset);
	public List<Employee> search(MeDataSource meDataSource, String ColumnName, String Value);
	public List<Supervisor> list(MeDataSource meDataSource);
}
