package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisation;
import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisations;
import com.balancika.hrms.app.services.authorisation.EmployeeAuthorisationServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeAuthorisationServiceImplJDBC")
public class EmployeeAuthorisationServiceImpl implements EmployeeAuthorisationServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeAuthorisations employeeAuthorisations) {
		try {
			if(employeeAuthorisations != null){
				String EmpAuth = "";
				String EmpID = "";
				for(EmployeeAuthorisation empAuthorisation : employeeAuthorisations.employeeAuthorisation){
					EmpAuth += "(";
					EmpAuth += "'" + tool.CheckStringNull(empAuthorisation.getEmpID()) + "',";
					EmpAuth += "'" + tool.CheckStringNull(empAuthorisation.getAuthProcess()) + "',";
					EmpAuth += "'" + tool.CheckStringNull(empAuthorisation.getAuthID()) + "'";
					EmpAuth += "),";
					EmpID = tool.CheckStringNull(empAuthorisation.getEmpID());
				}
				if (EmpAuth != "") {
					EmpAuth = EmpAuth.substring(0, EmpAuth.length() - 1);
					return tool.SPSelect(employeeAuthorisations.meDataSource, "spHRMAddEmployeeAuthorisation", employeeAuthorisations.meDataSource.getUserid(), EmpID, EmpAuth);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeAuthorisation", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public EmployeeAuthorisations get(MeDataSource meDataSource, String ID) {
		EmployeeAuthorisations employeeAuthorisations = new EmployeeAuthorisations();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeIDAuthorisation", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			List<EmployeeAuthorisation> empAuthorisations = new ArrayList<EmployeeAuthorisation>();
			for(ConcurrentHashMap<String, Object> c : Data){
				EmployeeAuthorisation EmpAuth = new EmployeeAuthorisation();
				EmpAuth.setEmpID(c.get("Emp_ID").toString());
				EmpAuth.setAuthProcess(c.get("Auth_Process").toString());
				EmpAuth.setAuthID(c.get("Auth_ID").toString());
				empAuthorisations.add(EmpAuth);
			}
			if(empAuthorisations.size()>0){
				employeeAuthorisations.employeeAuthorisation = empAuthorisations;
			}
			return employeeAuthorisations;
		}
		return null;
	}

	@Override
	public EmployeeAuthorisations getOffset(MeDataSource meDataSource, long offset) {
		EmployeeAuthorisations employeeAuthorisations = new EmployeeAuthorisations();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeAuthorisationOffset", Long.toString(offset));
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			List<EmployeeAuthorisation> empAuthorisations = new ArrayList<EmployeeAuthorisation>();
			for(ConcurrentHashMap<String, Object> c : Data){
				EmployeeAuthorisation EmpAuth = new EmployeeAuthorisation();
				EmpAuth.setEmpID(c.get("Emp_ID").toString());
				EmpAuth.setAuthProcess(c.get("Auth_Process").toString());
				EmpAuth.setAuthID(c.get("Auth_ID").toString());
				empAuthorisations.add(EmpAuth);
			}
			if(empAuthorisations.size()>0){
				employeeAuthorisations.employeeAuthorisation = empAuthorisations;
			}
			return employeeAuthorisations;
		}
		return null;
	}

	@Override
	public EmployeeAuthorisations search(MeDataSource meDataSource, String ColumnName, String Value) {
		EmployeeAuthorisations employeeAuthorisations = new EmployeeAuthorisations();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeAuthorisation", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			List<EmployeeAuthorisation> empAuthorisations = new ArrayList<EmployeeAuthorisation>();
			for(ConcurrentHashMap<String, Object> c : Data){
				EmployeeAuthorisation EmpAuth = new EmployeeAuthorisation();
				EmpAuth.setEmpID(c.get("Emp_ID").toString());
				EmpAuth.setAuthProcess(c.get("Auth_Process").toString());
				EmpAuth.setAuthID(c.get("Auth_ID").toString());
				empAuthorisations.add(EmpAuth);
			}
			if(empAuthorisations.size()>0){
				employeeAuthorisations.employeeAuthorisation = empAuthorisations;
			}
			return employeeAuthorisations;
		}
		return null;
	}

}
