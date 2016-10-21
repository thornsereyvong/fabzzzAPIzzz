package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.Allowance;
import com.balancika.hrms.app.services.payroll.AllowanceServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("AllowanceServiceImplJDBC")
public class AllowanceServiceImpl implements AllowanceServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Allowance allowance) {
		try {
			if (allowance != null) {
				String AllowanceName = tool.CheckStringNull(allowance.getAllowanceName());
				String All = "";
				All += "(";
				All += "'Temp_ID',";
				All += "'" + tool.CheckStringNull(allowance.getAllowanceName()) + "',";
				All += "'" + tool.CheckStringNull(allowance.getAllowancePayType()) + "',";
				All += "" + allowance.getAllowancePayAmount() + "";
				All += ")";
				
				java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				String AllHis = "";
				AllHis += "(";
				AllHis += "'Temp_ID',";
				AllHis += "'" + now + "',";
				AllHis += "'" + tool.CheckStringNull(allowance.getAllowancePayType()) + "',";
				AllHis += "" + allowance.getAllowancePayAmount() + "";
				AllHis += ")";
				return tool.SPSelect(allowance.meDataSource, "spHRMAddAllowance", allowance.meDataSource.getUserid(), AllowanceName.toLowerCase(), All, AllHis);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Allowance allowance) {
		try {
			if(allowance != null){
				String AllowanceID = tool.CheckStringNull(allowance.getAllowanceID());
				String AllowanceName = tool.CheckStringNull(allowance.getAllowanceName());
				String All = "";
				All += "Allowance_ID='" + tool.CheckStringNull(allowance.getAllowanceID()) + "',";
				All += "Allowance_Name='" + tool.CheckStringNull(allowance.getAllowanceName()) + "',";
				All += "Allowance_PayType='" + tool.CheckStringNull(allowance.getAllowancePayType()) + "',";
				All += "Allowance_PayAmount=" + allowance.getAllowancePayAmount() + "";
				
				java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				String AllHis = "";
				AllHis += "(";
				AllHis += "'" + tool.CheckStringNull(allowance.getAllowanceID()) + "',";
				AllHis += "'" + now + "',";
				AllHis += "'" + tool.CheckStringNull(allowance.getAllowancePayType()) + "',";
				AllHis += "" + allowance.getAllowancePayAmount() + "";
				AllHis += ")";
				return tool.SPSelect(allowance.meDataSource, "spHRMUpdateAllowance", allowance.meDataSource.getUserid(), "" + AllowanceID, AllowanceName.toLowerCase(), All, AllHis);
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteAllowance", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Allowance get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAllowanceID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Allowance all = new Allowance();
					all.setAllowanceID(c.get("Allowance_ID").toString());
					all.setAllowanceName(c.get("Allowance_Name").toString());
					all.setAllowancePayType(c.get("Allowance_PayType").toString());
					all.setAllowancePayAmount((double)c.get("Allowance_PayAmount"));
					return all;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Allowance getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Allowance> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchAllowance", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
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
			}
			return allowances;
		} catch (Exception e) {
			
		}
		return null;
	}

}
