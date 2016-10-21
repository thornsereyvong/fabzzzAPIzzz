package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Position;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeePositionServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Position employeePositions);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Position employeePositions);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Position get(MeDataSource meDataSource, String ID);
	public Position getOffset(MeDataSource meDataSource, long offset);
	public List<Position> search(MeDataSource meDataSource, String ColumnName, String Value);
}
