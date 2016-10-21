package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.OverTimeComponent;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface OverTimeComponentServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(OverTimeComponent overTimeComponent);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(OverTimeComponent overTimeComponent);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public OverTimeComponent get(MeDataSource meDataSource, String ID);
	public OverTimeComponent getOffset(MeDataSource meDataSource, long offset);
	public List<OverTimeComponent> search(MeDataSource meDataSource, String ColumnName, String Value);
}
