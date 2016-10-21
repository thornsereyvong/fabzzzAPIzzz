package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Branch;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeBranchServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Branch employeeBranchs);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Branch employeeBranchs);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Branch get(MeDataSource meDataSource, String ID);
	public Branch getOffset(MeDataSource meDataSource, long offset);
	public List<Branch> search(MeDataSource meDataSource, String ColumnName, String Value);

}
