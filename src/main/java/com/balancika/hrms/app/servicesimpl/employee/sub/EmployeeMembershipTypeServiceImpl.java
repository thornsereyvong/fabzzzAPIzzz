package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.MembershipType;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeMembershipTypeServiceImplJDBC")
public class EmployeeMembershipTypeServiceImpl implements com.balancika.hrms.app.services.employee.sub.EmployeeMembershipTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(MembershipType emt) {
		try {
			if(emt != null){
				String MembershipTypeName = tool.CheckStringNull(emt.getMembershipType_Name());
				String MembershipType = "";
				MembershipType += "(";
				MembershipType += "'" + tool.CheckStringNull(emt.getMembershipType_Name()) + "'";
				MembershipType += ")";
				return tool.SPSelect(emt.meDataSource, "spHRMAddEmployeeMembershipType", emt.meDataSource.getUserid(), MembershipTypeName.toLowerCase(), MembershipType, "1");
				}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(MembershipType employeeMembershipTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String MembershipType_Name) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeMembershipType", meDataSource.getUserid(), MembershipType_Name);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public MembershipType get(MeDataSource meDataSource, String MembershipType_Name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MembershipType getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MembershipType> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<MembershipType> EMT = new ArrayList<MembershipType>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeMembershipType", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					MembershipType emt = new MembershipType();
					emt.setMembershipType_Name(c.get("MembershipType_Name").toString());
					EMT.add(emt);
				}
			}
			return EMT;
		} catch (Exception e) {
			
		}
		return null;
	}

}
