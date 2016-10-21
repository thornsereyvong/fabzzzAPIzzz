package com.balancika.hrms.app.servicesimpl.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.timesheet.EmployeeLeaveType;
import com.balancika.hrms.app.entities.timesheet.EmployeeLeaveTypes;
import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.services.timesheet.EmployeeLeaveTypeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeLeaveTypeServiceImplJDBC")
public class EmployeeLeaveTypeServiceImpl implements EmployeeLeaveTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(EmployeeLeaveTypes employeeLeaveTypes) {
		try {
			if(employeeLeaveTypes != null){
				String EmpLT = "";
				String EmpID = "";
				for(EmployeeLeaveType employeeLeaveType : employeeLeaveTypes.employeeLeaveTypes){
					EmpLT += "(";
					EmpLT += "'" + tool.CheckStringNull(employeeLeaveType.getLeaveEmpID()) + "',";
					EmpLT += employeeLeaveType.getLeaveYear() + ",";
					EmpLT += "'" + tool.CheckStringNull(employeeLeaveType.getLeaveTypeID()) + "'";
					EmpLT += "),";
					EmpID = tool.CheckStringNull(employeeLeaveType.getLeaveEmpID());
				}
				if (EmpLT != "") {
					EmpLT = EmpLT.substring(0, EmpLT.length() - 1);
					return tool.SPSelect(employeeLeaveTypes.meDataSource, "spHRMAddEmployeeLeaveType", employeeLeaveTypes.meDataSource.getUserid(), EmpID, EmpLT);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(EmployeeLeaveTypes employeeLeaveTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeLeaveType", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public EmployeeLeaveTypes get(MeDataSource meDataSource, String ID) {
		EmployeeLeaveTypes employeeLeaveTypes = new EmployeeLeaveTypes();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeIDLeaveType", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			List<EmployeeLeaveType> empLeaveTypes = new ArrayList<EmployeeLeaveType>();
			for(ConcurrentHashMap<String, Object> c : Data){
				EmployeeLeaveType empLeaveType = new EmployeeLeaveType();
				empLeaveType.setLeaveEmpID(c.get("Leave_EmpID").toString());
				empLeaveType.setLeaveYear((int)c.get("Leave_Year"));
				empLeaveType.setLeaveTypeID(c.get("Leave_TypeID").toString());
				empLeaveTypes.add(empLeaveType);
			}
			if(empLeaveTypes.size()>0){
				employeeLeaveTypes.employeeLeaveTypes = empLeaveTypes;
			}
			return employeeLeaveTypes;
		}
		return null;
	}

	@Override
	public EmployeeLeaveTypes search(MeDataSource meDataSource, String ColumnName, String Value) {
		EmployeeLeaveTypes employeeLeaveTypes = new EmployeeLeaveTypes();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeLeaveType", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			List<EmployeeLeaveType> empLeaveTypes = new ArrayList<EmployeeLeaveType>();
			for(ConcurrentHashMap<String, Object> c : Data){
				EmployeeLeaveType empLeaveType = new EmployeeLeaveType();
				empLeaveType.setLeaveEmpID(c.get("Leave_EmpID").toString());
				empLeaveType.setLeaveYear((int)c.get("Leave_Year"));
				empLeaveType.setLeaveTypeID(c.get("Leave_TypeID").toString());
				empLeaveTypes.add(empLeaveType);
			}
			if(empLeaveTypes.size()>0){
				employeeLeaveTypes.employeeLeaveTypes = empLeaveTypes;
			}
			return employeeLeaveTypes;
		}
		return null;
	}

	@Override
	public List<Supervisor> Sub(MeDataSource meDataSource) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeLeaveTypeSub");
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Supervisor> supervisors = new ArrayList<Supervisor>();
			Data = MainData.get(1);
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
				return supervisors;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<LeaveType> Sub(MeDataSource meDataSource, String ID, int Year) {
		try {
			List<LeaveType> leaveTypes = new ArrayList<LeaveType>();
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeLeaveTypeSubSearch", ID, ""+Year);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					LeaveType lt = new LeaveType();
					lt.setLeaveTypeID(c.get("LeaveType_ID").toString());
					lt.setLeaveTypeName(c.get("LeaveType_Name").toString());
					lt.setLeaveTypePayStatus(c.get("LeaveType_PayStatus").toString());
					lt.setLeaveTypeYear((int)c.get("LeaveType_Year"));
					lt.setLeaveTypeAmountAllowed(c.get("LeaveType_AmountAllowed").toString());
					lt.setLeaveTypeGenderRestriction(c.get("LeaveType_GenderRestriction").toString());
					lt.setLeaveTypePaidType(c.get("LeaveType_PayType").toString());
					lt.setLeaveTypePaidValue(Double.parseDouble(c.get("LeaveType_PayAmount").toString()));
					leaveTypes.add(lt);
				}
				return leaveTypes;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
