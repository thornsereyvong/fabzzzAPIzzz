package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Allowance;
import com.balancika.hrms.app.entities.payroll.EmployeeAllowanceSub;
import com.balancika.hrms.app.services.payroll.EmployeeAllowanceSubServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeAllowanceSubServiceImplJDBC")
public class EmployeeAllowanceSubServiceImpl implements EmployeeAllowanceSubServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public EmployeeAllowanceSub get(MeDataSource meDataSource) {
		EmployeeAllowanceSub employeeAllowanceSub = new EmployeeAllowanceSub();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeAllowanceSub");
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
			employeeAllowanceSub.employee = supervisors;
		}
		Data = MainData.get(1);
		List<Allowance> allowances = new ArrayList<Allowance>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Allowance all = new Allowance();
				all.setAllowanceID(c.get("Allowance_ID").toString());
				all.setAllowanceName(c.get("Allowance_Name").toString());
				all.setAllowancePayType(c.get("Allowance_PayType").toString());
				all.setAllowancePayAmount((double)c.get("Allowance_PayAmount"));
				allowances.add(all);
			}
			employeeAllowanceSub.allowance = allowances;
		}
		return employeeAllowanceSub;
		
	}

}
