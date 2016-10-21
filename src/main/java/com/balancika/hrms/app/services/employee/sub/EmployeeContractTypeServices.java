package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.ContractType;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeContractTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(ContractType employeeContactTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(ContractType employeeContactTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public ContractType get(MeDataSource meDataSource, String ID);
	public ContractType getOffset(MeDataSource meDataSource, long offset);
	public List<ContractType> search(MeDataSource meDataSource, String ColumnName, String Value);
}
