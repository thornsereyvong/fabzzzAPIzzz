package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.InsuranceType;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeInsuranceTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(InsuranceType insuranceTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(InsuranceType insuranceTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String InsuranceTypeName);
	public InsuranceType get(MeDataSource meDataSource, String ID);
	public InsuranceType getOffset(MeDataSource meDataSource, long offset);
	public List<InsuranceType> search(MeDataSource meDataSource, String ColumnName, String Value);

}
