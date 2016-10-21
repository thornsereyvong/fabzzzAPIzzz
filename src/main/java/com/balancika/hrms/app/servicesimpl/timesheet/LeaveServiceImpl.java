package com.balancika.hrms.app.servicesimpl.timesheet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.timesheet.Leave;
import com.balancika.hrms.app.entities.timesheet.LeaveSummary;
import com.balancika.hrms.app.services.timesheet.LeaveServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("LeaveServiceImplJDBC")
public class LeaveServiceImpl implements LeaveServices {

	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Leave leave) {
		try {
			float LeaveTotal = 0;
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
			if (leave != null && tool.GetUtilYear(leave.getLeaveFrom()) == tool.GetUtilYear(leave.getLeaveTo())) {
				if(tool.CheckUtilDateNull(leave.getLeaveTo()).after(tool.CheckUtilDateNull(leave.getLeaveTo()))){
					return null;
				}
				if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("hourly") && !f1.format(tool.CheckUtilDateNull(leave.getLeaveFrom())).toString().equals(f1.format(tool.CheckUtilDateNull(leave.getLeaveTo())).toString())){
					return null;
				}
				String EmpID = tool.CheckStringNull(leave.getLeaveEmpID());
				String LeaveTypeID = tool.CheckStringNull(leave.getLeaveTypeID());
				String year = "" + tool.GetUtilYear(leave.getLeaveFrom());
				String l = "";
				l += "(";
				l += "'Temp_ID',";
				l += "'" + tool.CheckStringNull(leave.getLeaveEmpID()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveTel()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveEmail()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveReason()) + "',";
				l += "'" + WordUtils.capitalize(tool.CheckStringNull(leave.getLeaveDuration())) + "',";
				l += "'" + f.format(tool.CheckUtilDateNull(leave.getLeaveFrom())) + "',";
				l += "'" + f.format(tool.CheckUtilDateNull(leave.getLeaveTo())) + "',";
				long diff = tool.CheckUtilDateNull(leave.getLeaveTo()).getTime() - tool.CheckUtilDateNull(leave.getLeaveFrom()).getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffMinutes = diff / (60 * 1000) % 60;
				if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("full day")){
					l += diffDays + ",";
					LeaveTotal = Float.parseFloat(""+diffDays);
				}
				else if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("hourly")){
					if(diffMinutes > 0 && diffMinutes <= 30 ){
						l += (diffHours + 0.5) + ",";
						LeaveTotal = Float.parseFloat("" + (diffHours + 0.5));
					}else if(diffMinutes > 30){
						l += (diffHours + 1) + ",";
						LeaveTotal = Float.parseFloat("" + (diffHours + 1));
					}else{
						l += diffHours + ",";
						LeaveTotal = Float.parseFloat("" + diffHours);
					}	
				}
				
				l += "'" + tool.CheckStringNull(leave.getLeaveTypeID()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveDescription()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveAttachmentName()) + "',";
				l += "'" + tool.CheckStringNull(leave.getLeaveAttachmentPath()) + "',";
				l += "'Temp_Status',";
				l += "Temp_Amount,Temp_WorkHour";
				l += ")";
				if(LeaveTotal <= 0.0f){
					return null;
				}
				return tool.SPSelect(leave.meDataSource, "spHRMAddLeave", leave.meDataSource.getUserid(), EmpID, LeaveTypeID, year, WordUtils.capitalize(tool.CheckStringNull(leave.getLeaveDuration())), f.format(tool.CheckUtilDateNull(leave.getLeaveFrom())).toString(), Float.toString(LeaveTotal), l);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Leave leave) {
		try {
			float LeaveTotal = 0;
			DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			DateFormat f1 = new SimpleDateFormat("yyyy-MM-dd");
			if(leave != null && tool.GetUtilYear(leave.getLeaveFrom()) == tool.GetUtilYear(leave.getLeaveTo())){
				if(tool.CheckUtilDateNull(leave.getLeaveTo()).after(tool.CheckUtilDateNull(leave.getLeaveTo()))){
					return null;
				}
				if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("hourly") && !f1.format(tool.CheckUtilDateNull(leave.getLeaveFrom())).toString().equals(f1.format(tool.CheckUtilDateNull(leave.getLeaveTo())).toString())){
					return null;
				}
				String LeaveID = tool.CheckStringNull(leave.getLeaveID());
				String EmpID = tool.CheckStringNull(leave.getLeaveEmpID());
				String LeaveTypeID = tool.CheckStringNull(leave.getLeaveTypeID());
				String year = "" + tool.GetUtilYear(leave.getLeaveFrom());
				String l = "";
				l += "Leave_ID='" + tool.CheckStringNull(leave.getLeaveID()) + "',";
				l += "Leave_EmpID='" + tool.CheckStringNull(leave.getLeaveEmpID()) + "',";
				l += "Leave_Tel='" + tool.CheckStringNull(leave.getLeaveTel()) + "',";
				l += "Leave_Email='" + tool.CheckStringNull(leave.getLeaveEmail()) + "',";
				l += "Leave_Reason='" + tool.CheckStringNull(leave.getLeaveReason()) + "',";
				l += "Leave_Duration='" + WordUtils.capitalize(tool.CheckStringNull(leave.getLeaveDuration())) + "',";
				l += "Leave_From='" + f.format(tool.CheckUtilDateNull(leave.getLeaveFrom())) + "',";
				l += "Leave_To='" + f.format(tool.CheckUtilDateNull(leave.getLeaveTo())) + "',";
				long diff = tool.CheckUtilDateNull(leave.getLeaveTo()).getTime() - tool.CheckUtilDateNull(leave.getLeaveFrom()).getTime();
				long diffDays = diff / (24 * 60 * 60 * 1000);
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffMinutes = diff / (60 * 1000) % 60;
				if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("full day")){
					l += "Leave_Total=" + diffDays + ",";
					LeaveTotal = Float.parseFloat(""+diffDays);
				}
				else if(tool.CheckStringNull(leave.getLeaveDuration()).toLowerCase().equals("hourly")){
					if(diffMinutes > 0 && diffMinutes <= 30 ){
						l += "Leave_Total=" + (diffHours + 0.5) + ",";
						LeaveTotal = Float.parseFloat("" + (diffHours + 0.5));
					}else if(diffMinutes > 30){
						l += "Leave_Total=" + (diffHours + 1) + ",";
						LeaveTotal = Float.parseFloat("" + (diffHours + 1));
					}else{
						l += "Leave_Total=" + diffHours + ",";
						LeaveTotal = Float.parseFloat("" + diffHours);
					}	
				}
				l += "Leave_TypeID='" + tool.CheckStringNull(leave.getLeaveTypeID()) + "',";
				l += "Leave_Description='" + tool.CheckStringNull(leave.getLeaveDescription()) + "',";
				l += "Leave_AttachmentName='" + tool.CheckStringNull(leave.getLeaveAttachmentName()) + "',";
				l += "Leave_AttachmentPath='" + tool.CheckStringNull(leave.getLeaveAttachmentPath()) + "',";
				l += "Leave_Status='Temp_Status',Leave_Amount=Temp_Amount";
				
				return tool.SPSelect(leave.meDataSource, "spHRMUpdateLeave", leave.meDataSource.getUserid(), LeaveID, EmpID, LeaveTypeID, year, WordUtils.capitalize(tool.CheckStringNull(leave.getLeaveDuration())), Float.toString(LeaveTotal), l);
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteLeave", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}
	boolean check = false;
	Leave l = null;
	@Override
	public Leave get(MeDataSource meDataSource, String ID) {
		l = new Leave();
		Thread t = new Thread(new Runnable() {
	         public void run()
	         {
	        	 try {
	     			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetLeaveID", meDataSource.getUserid(), ID);
	     			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
	     			if(Data.size()>0){
	     				for(ConcurrentHashMap<String, Object> c : Data){
	     					l.setLeaveID(c.get("Leave_ID").toString());
	     					l.setLeaveEmpID(c.get("Leave_EmpID").toString());
	     					l.setLeaveTel(c.get("Leave_Tel").toString());
	     					l.setLeaveEmail(c.get("Leave_Email").toString());
	     					l.setLeaveReason(c.get("Leave_Reason").toString());
	     					l.setLeaveDuration(c.get("Leave_Duration").toString());
	     					l.setLeaveFrom((Date)c.get("Leave_From"));
	     					l.setLeaveTo((Date)c.get("Leave_To"));
	     					l.setLeaveTotal((float)c.get("Leave_Total"));
	     					l.setLeaveTypeID(c.get("Leave_TypeID").toString());
	     					l.setLeaveDescription(c.get("Leave_Description").toString());
	     					l.setLeaveAttachmentName(c.get("Leave_AttachmentName").toString());
	     					l.setLeaveAttachmentPath(c.get("Leave_AttachmentPath").toString());
	     					l.setLeaveStatus(c.get("Leave_Status").toString());
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
	     						l.authorisationApproved = authorisationApproveds;
	     					}
	     					List<ConcurrentHashMap<String, Object>> Data3 = MainData.get(2);
	     					if(Data3.size() > 0){
	     						List<LeaveSummary> leaveSummaries = new ArrayList<LeaveSummary>();
	     						for(ConcurrentHashMap<String, Object> c3 : Data3){
	     							LeaveSummary ls = new LeaveSummary();
	     							ls.setLeaveTypeID(c3.get("LeaveType_ID").toString());
	     							ls.setLeaveTypeName(c3.get("LeaveType_Name").toString());
	     							ls.setLeaveTypePayStatus(c3.get("LeaveType_PayStatus").toString());
	     							ls.setLeaveTypeYear((int)c3.get("LeaveType_Year"));
	     							ls.setLeaveTypeAmountAllowed(c3.get("LeaveType_AmountAllowed").toString());
	     							ls.setLeaveTypeGenderRestriction(c3.get("LeaveType_GenderRestriction").toString());
	     							ls.setLeaveTypePaidType(c3.get("LeaveType_PayType").toString());
	     							ls.setLeaveTypePaidValue(Double.parseDouble(c3.get("LeaveType_PayAmount").toString()));
	     							ls.setLeaveTaken(Float.parseFloat(c3.get("Leave_Taken").toString()));
	     							ls.setLeavePending(Float.parseFloat(c3.get("Leave_Pending").toString()));
	     							ls.setLeaveBalance(Float.parseFloat(c3.get("Leave_Balance").toString()));
	     							leaveSummaries.add(ls);
	     						}
	     						l.leaveSummary = leaveSummaries;
	     					}
	     				}
	     			}
	     		} catch (Exception e) {
	     			
	     		}
	        }
		});
		try {
			t.start();
			t.join();
			return l;
		} catch (Exception e) {
		}
		return null;
	}

	@Override
	public List<Leave> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchLeave",meDataSource.getUserid(), ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Leave> leaves = new ArrayList<Leave>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Leave l = new Leave();
					l.setLeaveID(c.get("Leave_ID").toString());
					l.setLeaveEmpID(c.get("Leave_EmpID").toString());
					l.setLeaveTel(c.get("Leave_Tel").toString());
					l.setLeaveEmail(c.get("Leave_Email").toString());
					l.setLeaveReason(c.get("Leave_Reason").toString());
					l.setLeaveDuration(c.get("Leave_Duration").toString());
					l.setLeaveFrom((Date)c.get("Leave_From"));
					l.setLeaveTo((Date)c.get("Leave_To"));
					l.setLeaveTotal((float)c.get("Leave_Total"));
					l.setLeaveTypeID(c.get("Leave_TypeID").toString());
					l.setLeaveDescription(c.get("Leave_Description").toString());
					l.setLeaveAttachmentName(c.get("Leave_AttachmentName").toString());
					l.setLeaveAttachmentPath(c.get("Leave_AttachmentPath").toString());
					l.setLeaveStatus(c.get("Leave_Status").toString());
					leaves.add(l);
				}
			}
			return leaves;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Supervisor> Sub(MeDataSource meDataSource) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetLeaveSub", meDataSource.getUserid());
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
	public List<LeaveSummary> Sub(MeDataSource meDataSource, String empID, int year) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetLeaveSubSearch", empID, "" + year);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<LeaveSummary> leaveSummaries = new ArrayList<LeaveSummary>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				LeaveSummary ls = new LeaveSummary();
				ls.setLeaveTypeID(c.get("LeaveType_ID").toString());
				ls.setLeaveTypeName(c.get("LeaveType_Name").toString());
				ls.setLeaveTypePayStatus(c.get("LeaveType_PayStatus").toString());
				ls.setLeaveTypeYear((int)c.get("LeaveType_Year"));
				ls.setLeaveTypeAmountAllowed(c.get("LeaveType_AmountAllowed").toString());
				ls.setLeaveTypeGenderRestriction(c.get("LeaveType_GenderRestriction").toString());
				ls.setLeaveTypePaidType(c.get("LeaveType_PayType").toString());
				ls.setLeaveTypePaidValue(Double.parseDouble(c.get("LeaveType_PayAmount").toString()));
				ls.setLeaveTaken(Float.parseFloat(c.get("Leave_Taken").toString()));
				ls.setLeavePending(Float.parseFloat(c.get("Leave_Pending").toString()));
				ls.setLeaveBalance(Float.parseFloat(c.get("Leave_Balance").toString()));
				leaveSummaries.add(ls);
			}
			return leaveSummaries;
		}
		return null;
	}

}
