package com.balancika.hrms.app.servicesimpl.timesheet;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang3.text.WordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.services.timesheet.LeaveTypeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("LeaveTypeServiceImplJDBC")
public class LeaveTypeServiceImpl implements LeaveTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(LeaveType leaveType) {
		try {
			if (leaveType != null) {
				String LeaveTypeName = tool.CheckStringNull(leaveType.getLeaveTypeName());
				String LeaveType = "";
				LeaveType += "(";
				LeaveType += "'Temp_ID',";
				LeaveType += "'" + tool.CheckStringNull(leaveType.getLeaveTypeName()) + "',";
				LeaveType += "'" + WordUtils.capitalize(tool.CheckStringNull(leaveType.getLeaveTypePayStatus())) + "',";
				LeaveType += leaveType.getLeaveTypeYear() + ",";
				LeaveType += "'" + tool.CheckStringNull(leaveType.getLeaveTypeAmountAllowed()) + "',";
				LeaveType += "'" + tool.CheckStringNull(leaveType.getLeaveTypeGenderRestriction()).toLowerCase() + "',";
				LeaveType += "'" + tool.CheckStringNull(leaveType.getLeaveTypePaidType()) + "',";
				LeaveType += "'" + leaveType.getLeaveTypePaidValue() + "'";
				LeaveType += ")";
				return tool.SPSelect(leaveType.meDataSource, "spHRMAddTimesheetLeaveType", leaveType.meDataSource.getUserid(), LeaveTypeName.toLowerCase(), LeaveType);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(LeaveType leaveType) {
		try {
				if(leaveType != null){
					String LeaveTypeName = tool.CheckStringNull(leaveType.getLeaveTypeName());
					String LeaveType = "";
					LeaveType += "LeaveType_ID='" + tool.CheckStringNull(leaveType.getLeaveTypeID()) + "',";
					LeaveType += "LeaveType_Name='" + tool.CheckStringNull(leaveType.getLeaveTypeName()) + "',";
					LeaveType += "LeaveType_PayStatus='" + WordUtils.capitalize(tool.CheckStringNull(leaveType.getLeaveTypePayStatus())) + "',";
					LeaveType += "LeaveType_Year=" + leaveType.getLeaveTypeYear() + ",";
					LeaveType += "LeaveType_AmountAllowed='" + tool.CheckStringNull(leaveType.getLeaveTypeAmountAllowed()) + "',";
					LeaveType += "LeaveType_GenderRestriction='" + tool.CheckStringNull(leaveType.getLeaveTypeGenderRestriction()).toLowerCase() + "',";
					LeaveType += "LeaveType_PayType='" + tool.CheckStringNull(leaveType.getLeaveTypePaidType()) + "',";
					LeaveType += "LeaveType_PayAmount='" + leaveType.getLeaveTypePaidValue() + "'";
					return tool.SPSelect(leaveType.meDataSource, "spHRMUpdateTimesheetLeaveType", leaveType.meDataSource.getUserid(), "" + leaveType.getLeaveTypeID(), LeaveTypeName.toLowerCase(), LeaveType);
				}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteTimesheetLeaveType", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public LeaveType get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetTimesheetLeaveTypeID", ID);
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
					return lt;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<LeaveType> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			List<LeaveType> leaveTypes = new ArrayList<LeaveType>();
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchTimesheetLeaveType", ColumnName, Value);
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
