package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.OverTime;
import com.balancika.hrms.app.entities.payroll.OverTimeComponent;
import com.balancika.hrms.app.services.payroll.OverTimeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.tool.TimeFormat;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("OverTimeServiceImplJDBC")
public class OverTimeServiceImpl implements OverTimeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(OverTime overTime) {
		try {
			if (overTime != null) {
				String EmpID = tool.CheckStringNull(overTime.getOvertimeEmpID());
				String ot = "";
				ot += "(";
				ot += "'Temp_ID',";
				ot += "'" + tool.CheckStringNull(overTime.getOvertimeEmpID()) + "',";
				ot += "'" + tool.CheckStringNull(overTime.getOvertimeOTComID()) + "',";
				ot += "'" + overTime.getOvertimeHours() + "',";
				ot += "'" + tool.CheckDateNull(overTime.getOvertimeDate()) + "',";
				ot += "'" + tool.CheckStringNull(overTime.getOvertimeReason()) + "',";
				ot += "'" + overTime.getOvertimeTimeIn() + "',";
				ot += "'" + overTime.getOvertimeTimeOut() + "',";
				ot += "'" + tool.CheckStringNull(overTime.getOvertimeDescription()) + "',";
				ot += "'Temp_Status'";
				ot += ")";
				
				return tool.SPSelect(overTime.meDataSource, "spHRMAddOvertime", overTime.meDataSource.getUserid(), EmpID, tool.CheckStringNull(overTime.getOvertimeOTComID()), ot);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(OverTime overTime) {
		try {
			if(overTime != null){
				String OvertimeID = tool.CheckStringNull(overTime.getOvertimeID());
				String EmpID = tool.CheckStringNull(overTime.getOvertimeEmpID());
				String ot = "";
				ot += "Overtime_ID='" + tool.CheckStringNull(overTime.getOvertimeID()) + "',";
				ot += "Overtime_EmpID='" + tool.CheckStringNull(overTime.getOvertimeEmpID()) + "',";
				ot += "Overtime_OTComID='" + tool.CheckStringNull(overTime.getOvertimeOTComID()) + "',";
				ot += "Overtime_Hours='" + overTime.getOvertimeHours() + "',";
				ot += "Overtime_Date='" + tool.CheckDateNull(overTime.getOvertimeDate()) + "',";
				ot += "Overtime_Reason='" + tool.CheckStringNull(overTime.getOvertimeReason()) + "',";
				ot += "Overtime_TimeIn='" + overTime.getOvertimeTimeIn() + "',";
				ot += "Overtime_TimeOut='" + overTime.getOvertimeTimeOut() + "',";
				ot += "Overtime_Description='" + tool.CheckStringNull(overTime.getOvertimeDescription()) + "',";
				ot += "Overtime_Status='Temp_Status'";
				
				return tool.SPSelect(overTime.meDataSource, "spHRMUpdateOvertime", overTime.meDataSource.getUserid(), OvertimeID, EmpID, tool.CheckStringNull(overTime.getOvertimeOTComID()), ot);
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteOvertime", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public OverTime get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetOvertimeID", meDataSource.getUserid(), ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					OverTime ot = new OverTime();
					ot.setOvertimeID(c.get("Overtime_ID").toString());
					ot.setOvertimeEmpID(c.get("Overtime_EmpID").toString());
					ot.setOvertimeOTComID(c.get("Overtime_OTComID").toString());
					ot.setOvertimeHours(Float.parseFloat(c.get("Overtime_Hours").toString()));
					ot.setOvertimeDate(tool.ConvertDate(c.get("Overtime_Date").toString()));
					ot.setOvertimeReason(c.get("Overtime_Reason").toString());
					ot.setOvertimeTimeIn(tool.ConvertTime(c.get("Overtime_TimeIn").toString(), TimeFormat.FullHour));
					ot.setOvertimeTimeOut(tool.ConvertTime(c.get("Overtime_TimeOut").toString(), TimeFormat.FullHour));
					ot.setOvertimeDescription(c.get("Overtime_Description").toString());
					ot.setOvertimeStatus(c.get("Overtime_Status").toString());
					List<ConcurrentHashMap<String, Object>> Data2 = MainData.get(1);
					if(Data2.size()>0){
						List<AuthorisationApproved> authorisationApproveds = new ArrayList<AuthorisationApproved>();
						for(ConcurrentHashMap<String, Object> c2 : Data2){
							AuthorisationApproved supervisor = new AuthorisationApproved();
							supervisor.setEmp_ID(c2.get("EmpID").toString());
							supervisor.setEmp_Name(c2.get("EmpName").toString());
							supervisor.setEmp_Email(c2.get("EmpEmail").toString());
							supervisor.setEmp_CompanyEmail(c2.get("Emp_CompanyEmail").toString());
							supervisor.setEmp_Position(c2.get("Position").toString());
							supervisor.setEmp_PositionKh(c2.get("PositionKhmer").toString());
							supervisor.setEmp_PositionLevel(c2.get("Position_Level").toString());
							supervisor.setEmp_UserName(c2.get("PositionKhmer").toString());
							supervisor.setEmp_UserName(c2.get("User_Name").toString());
							supervisor.setAuth_Status(c2.get("Auth_Status").toString());
							authorisationApproveds.add(supervisor);
						}
						ot.authorisationApproved = authorisationApproveds;
					}
					return ot;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public OverTime getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OverTime> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchOverTime",meDataSource.getUserid(), ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<OverTime> overTimes = new ArrayList<OverTime>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					OverTime ot = new OverTime();
					ot.setOvertimeID(c.get("Overtime_ID").toString());
					ot.setOvertimeEmpID(c.get("Overtime_EmpID").toString());
					ot.setOvertimeOTComID(c.get("Overtime_OTComID").toString());
					ot.setOvertimeHours(Float.parseFloat(c.get("Overtime_Hours").toString()));
					ot.setOvertimeDate(tool.ConvertDate(c.get("Overtime_Date").toString()));
					ot.setOvertimeReason(c.get("Overtime_Reason").toString());
					ot.setOvertimeTimeIn(tool.ConvertTime(c.get("Overtime_TimeIn").toString(), TimeFormat.FullHour));
					ot.setOvertimeTimeOut(tool.ConvertTime(c.get("Overtime_TimeOut").toString(), TimeFormat.FullHour));
					ot.setOvertimeDescription(c.get("Overtime_Description").toString());
					ot.setOvertimeStatus(c.get("Overtime_Status").toString());
					overTimes.add(ot);
				}
			}
			return overTimes;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Supervisor> sub(MeDataSource meDataSource) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetOvertimeSub", meDataSource.getUserid());
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
		return supervisors;
	}

	@Override
	public List<OverTimeComponent> SubSearchOvertime(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMOvertimeSubSearch", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<OverTimeComponent> OTC = new ArrayList<OverTimeComponent>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					OverTimeComponent otc = new OverTimeComponent();
					otc.setoTComID(c.get("OTCom_ID").toString());
					otc.setoTComName(c.get("OTCom_Name").toString());
					otc.setOtComPayType(c.get("OTCom_PayType").toString());
					otc.setOtComPayAmount(Double.parseDouble(c.get("OTCom_PayAmount").toString()));
					OTC.add(otc);
				}
			}
			return OTC;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
