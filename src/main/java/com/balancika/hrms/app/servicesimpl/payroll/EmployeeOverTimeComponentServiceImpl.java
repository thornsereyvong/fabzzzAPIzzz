package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.EmployeeOverTimeComponent;
import com.balancika.hrms.app.entities.payroll.EmployeeOverTimeComponents;
import com.balancika.hrms.app.services.payroll.EmployeeOverTimeComponentServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeOvertimeComponentServiceImplJDBC")
public class EmployeeOverTimeComponentServiceImpl implements EmployeeOverTimeComponentServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeOverTimeComponents employeeOverTimeComponents) {
		try {
			if (employeeOverTimeComponents != null) {
				String otc = "";
				String EmpID="";
				for(EmployeeOverTimeComponent eotc : employeeOverTimeComponents.employeeOverTimeComponent){
					EmpID = tool.CheckStringNull(eotc.getoTComEmpID());
					otc += "(";
					otc += "'" + tool.CheckStringNull(eotc.getoTComEmpID()) + "',";
					otc += "'" + tool.CheckStringNull(eotc.getoTComID()) + "'";
					otc += "),";
				}
				if (otc != "") {
					otc = otc.substring(0, otc.length() - 1);
				}
				return tool.SPSelect(employeeOverTimeComponents.meDataSource, "spHRMAddEmployeeOvertimeComponent", employeeOverTimeComponents.meDataSource.getUserid(), EmpID, otc);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeOverTimeComponents employeeOverTimeComponents) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeOvertimeComponent", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public EmployeeOverTimeComponents get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetOvertimeComponentEmployeeID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			EmployeeOverTimeComponents employeeOverTimeComponents = new EmployeeOverTimeComponents();
			List<EmployeeOverTimeComponent> EOTC = new ArrayList<EmployeeOverTimeComponent>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					EmployeeOverTimeComponent eotc = new EmployeeOverTimeComponent();
					eotc.setoTComEmpID(c.get("OTCom_EmpID").toString());
					eotc.setoTComID(c.get("OTCom_ID").toString());
					EOTC.add(eotc);
				}
				employeeOverTimeComponents.employeeOverTimeComponent=EOTC;
				return employeeOverTimeComponents;
			}
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public EmployeeOverTimeComponents getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeOverTimeComponents search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeOvertimeComponent", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			EmployeeOverTimeComponents employeeOverTimeComponents = new EmployeeOverTimeComponents();
			List<EmployeeOverTimeComponent> EOTC = new ArrayList<EmployeeOverTimeComponent>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					EmployeeOverTimeComponent eotc = new EmployeeOverTimeComponent();
					eotc.setoTComEmpID(c.get("OTCom_EmpID").toString());
					eotc.setoTComID(c.get("OTCom_ID").toString());
					EOTC.add(eotc);
				}
				employeeOverTimeComponents.employeeOverTimeComponent=EOTC;
				return employeeOverTimeComponents;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
