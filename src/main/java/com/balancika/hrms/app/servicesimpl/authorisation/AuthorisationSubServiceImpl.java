package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationGroup;
import com.balancika.hrms.app.entities.authorisation.AuthorisationSub;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.authorisation.AuthorisationSubServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("AuthorisationSubServiceImplJDBC")
public class AuthorisationSubServiceImpl implements AuthorisationSubServices{
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public AuthorisationSub get(MeDataSource meDataSource) {
		AuthorisationSub authorisationSub = new AuthorisationSub();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationSub");
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Supervisor> supervisors = new ArrayList<Supervisor>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Supervisor supervisor = new Supervisor();
				supervisor.setEmp_ID(c.get("EmpID").toString());
				supervisor.setEmp_Name(c.get("EmpName").toString());
				supervisor.setEmp_Email(c.get("EmpEmail").toString());
				supervisor.setEmp_CompanyEmail(c.get("Emp_CompanyEmail").toString());
				supervisor.setEmp_Position(c.get("Position").toString());
				supervisor.setEmp_PositionKh(c.get("PositionKhmer").toString());
				supervisor.setEmp_PositionLevel(c.get("Position_Level").toString());
				supervisor.setEmp_UserName(c.get("PositionKhmer").toString());
				supervisor.setEmp_UserName(c.get("User_Name").toString());
				supervisors.add(supervisor);
			}
		}
		authorisationSub.employee = supervisors;
		
		Data = MainData.get(1);
		List<AuthorisationGroup> authorisationGroups = new ArrayList<AuthorisationGroup>();
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				AuthorisationGroup authorisationGroup = new AuthorisationGroup();
				authorisationGroup.setAuthGroupID(c.get("AuthGroup_ID").toString());
				authorisationGroup.setAuthGroupName(c.get("AuthGroup_Name").toString());
				authorisationGroup.setAuthGroupDescription(c.get("AuthGroup_Description").toString());
				
				authorisationGroups.add(authorisationGroup);
			}
		}
		authorisationSub.authorisationGroup = authorisationGroups;
		
		return authorisationSub;
	}
	
}
