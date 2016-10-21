package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.EmployeeAllowance;
import com.balancika.hrms.app.entities.payroll.EmployeeAllowances;
import com.balancika.hrms.app.services.payroll.EmployeeAllowanceServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeAllowanceServiceImplJDBC")
public class EmployeeAllowanceServiceImpl implements EmployeeAllowanceServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeAllowances employeeAllowances) {
		try {
			if (employeeAllowances != null) {
				String All = "";
				String EmpID="";
				for(EmployeeAllowance ea : employeeAllowances.employeeAllowance){
					EmpID = tool.CheckStringNull(ea.getAllowanceEmpID());
					All += "(";
					All += "'" + tool.CheckStringNull(ea.getAllowanceEmpID()) + "',";
					All += "'" + tool.CheckStringNull(ea.getAllowanceID()) + "'";
					All += "),";
				}
				if (All != "") {
					All = All.substring(0, All.length() - 1);
				}
				return tool.SPSelect(employeeAllowances.meDataSource, "spHRMAddEmployeeAllowance", employeeAllowances.meDataSource.getUserid(), EmpID, All);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeAllowances employeeAllowances) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeAllowance", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public EmployeeAllowances get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAllowanceEmployeeID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			EmployeeAllowances employeeAllowance = new EmployeeAllowances();
			List<EmployeeAllowance> EA = new ArrayList<EmployeeAllowance>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					EmployeeAllowance ea = new EmployeeAllowance();
					ea.setAllowanceEmpID(c.get("Allowance_EmpID").toString());
					ea.setAllowanceID(c.get("Allowance_ID").toString());
					EA.add(ea);
				}
				employeeAllowance.employeeAllowance=EA;
				return employeeAllowance;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public EmployeeAllowances getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeAllowances search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeAllowance", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			EmployeeAllowances employeeAllowance = new EmployeeAllowances();
			List<EmployeeAllowance> EA = new ArrayList<EmployeeAllowance>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					EmployeeAllowance ea = new EmployeeAllowance();
					ea.setAllowanceEmpID(c.get("Allowance_EmpID").toString());
					ea.setAllowanceID(c.get("Allowance_ID").toString());
					EA.add(ea);
				}
			}
			employeeAllowance.employeeAllowance=EA;
			return employeeAllowance;
		} catch (Exception e) {
			
		}
		return null;
	}

}
