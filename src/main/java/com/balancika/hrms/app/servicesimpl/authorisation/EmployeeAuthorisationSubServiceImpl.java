package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.Authorisation;
import com.balancika.hrms.app.entities.authorisation.AuthorisationDetail;
import com.balancika.hrms.app.entities.authorisation.AuthorisationProcess;
import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisationSub;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.authorisation.EmployeeAuthorisationSubServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeAuthorisationSubServiceImplJDBC")
public class EmployeeAuthorisationSubServiceImpl implements EmployeeAuthorisationSubServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public EmployeeAuthorisationSub get(MeDataSource meDataSource) {
		EmployeeAuthorisationSub employeeAuthorisationSub = new EmployeeAuthorisationSub();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeAuthorisationSub");
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Supervisor> employee = new ArrayList<Supervisor>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Supervisor supervisor = new Supervisor();
				supervisor.setEmp_ID(c.get("EmpID").toString());
				supervisor.setEmp_Name(c.get("EmpName").toString());
				supervisor.setEmp_Email(c.get("EmpEmail").toString());
				supervisor.setEmp_CompanyEmail(c.get("EmpEmail").toString());
				supervisor.setEmp_Position(c.get("Position").toString());
				supervisor.setEmp_PositionKh(c.get("PositionKhmer").toString());
				supervisor.setEmp_PositionLevel(c.get("Position_Level").toString());
				supervisor.setEmp_UserName(c.get("PositionKhmer").toString());
				supervisor.setEmp_UserName(c.get("User_Name").toString());
				employee.add(supervisor);
			}
		}
		employeeAuthorisationSub.employee = employee;
		
		Data = MainData.get(1);
		List<AuthorisationProcess> authorisationProcess = new ArrayList<AuthorisationProcess>();
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				AuthorisationProcess authProcess = new AuthorisationProcess();
				authProcess.setAuthProcess(c.get("Auth_Process").toString());
				authorisationProcess.add(authProcess);
			}
		}
		employeeAuthorisationSub.authorisationProcess = authorisationProcess;
		
		Data = MainData.get(2);
		List<Authorisation> authorisations = new ArrayList<Authorisation>();
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				Authorisation authorisation = new Authorisation();
				List<AuthorisationDetail> authorisationDetails = new ArrayList<AuthorisationDetail>();
				authorisation.setAuthID(c.get("Auth_ID").toString());
				authorisation.setAuthName(c.get("Auth_Name").toString());
				authorisation.setAuthType(c.get("Auth_Type").toString());
				authorisation.setAuthAndOr(c.get("Auth_AndOr").toString());
				authorisation.setAuthAmount((c.get("Auth_Amount").toString().equals(""))? 0 : (int)c.get("Auth_Amount"));
				authorisation.authorisationDetail = authorisationDetails;
				authorisations.add(authorisation);
			}
		}
		employeeAuthorisationSub.authorisation = authorisations;
		
		return employeeAuthorisationSub;
	}
	
}
