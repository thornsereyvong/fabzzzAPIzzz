package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;







import com.balancika.hrms.app.entities.employee.sub.MembershipType;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface EmployeeMembershipTypeServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(MembershipType employeeMembershipTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(MembershipType employeeMembershipTypes);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String employeeMembershipTypes);
	public MembershipType get(MeDataSource meDataSource, String MembershipType_Name);
	public MembershipType getOffset(MeDataSource meDataSource, long offset);
	public List<MembershipType> search(MeDataSource meDataSource, String ColumnName, String Value);
}
