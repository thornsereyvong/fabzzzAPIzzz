package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Insurance;
import com.balancika.hrms.app.services.employee.sub.EmployeeInsuranceServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeInsuranceServiceImplJDBC")
public class EmployeeInsuranceServiceImpl implements EmployeeInsuranceServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Insurance in) {
		try {
			if (in != null) {
				String InsuranceName = tool.CheckStringNull(in.getInsurance_Name());
				String InsuranceType = tool.CheckStringNull(in.getInsurance_Type());
				String Insurance = "";
				Insurance += "(";
				Insurance += "'Temp_ID',";
				Insurance += "'" + tool.CheckStringNull(in.getInsurance_Name()) + "',";
				Insurance += "'" + tool.CheckStringNull(in.getInsurance_Company()) + "',";
				Insurance += "'" + tool.CheckStringNull(in.getInsurance_Type()) + "',";
				Insurance += "'" + tool.CheckStringNull(in.getInsurance_Description()) + "'";
				Insurance += ")";
				return tool.SPSelect(in.meDataSource, "spHRMAddEmployeeInsurance",in.meDataSource.getUserid(), InsuranceName.toLowerCase(), Insurance, InsuranceType);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Insurance IN) {
		try {
			if (IN != null) {
				String Insurance = "";
				int InsuranceID = IN.getInsurance_ID();
				String InsuranceName = tool.CheckStringNull(IN.getInsurance_Name());
				String InsuranceType = tool.CheckStringNull(IN.getInsurance_Type());
				Insurance += "Insurance_ID='" + IN.getInsurance_ID() + "',";
				Insurance += "Insurance_Name='" + tool.CheckStringNull(IN.getInsurance_Name()) + "',";
				Insurance += "Insurance_Company='" + tool.CheckStringNull(IN.getInsurance_Company()) + "',";
				Insurance += "Insurance_Type='" + tool.CheckStringNull(IN.getInsurance_Type()) + "',";
				Insurance += "Insurance_Description='" + tool.CheckStringNull(IN.getInsurance_Description()) + "'";
				return tool.SPSelect(IN.meDataSource, "spHRMUpdateEmployeeInsurance", IN.meDataSource.getUserid(), "" + InsuranceID, InsuranceName.toLowerCase(), Insurance, InsuranceType);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String InsuranceID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeInsurance", meDataSource.getUserid(), InsuranceID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Insurance get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeInsuranceID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Insurance in = new Insurance();
					in.setInsurance_ID((c.get("Insurance_ID").toString() == "")? 0 : (int)c.get("Insurance_ID"));
					in.setInsurance_Name(c.get("Insurance_Name").toString());
					in.setInsurance_Company(c.get("Insurance_Company").toString());
					in.setInsurance_Type(c.get("Insurance_Type").toString());
					in.setInsurance_Description(c.get("Insurance_Description").toString());
					return in;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Insurance getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Insurance> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Insurance> IN = new ArrayList<Insurance>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeInsurance", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Insurance in = new Insurance();
					in.setInsurance_ID((c.get("Insurance_ID").toString() == "")? 0 : (int)c.get("Insurance_ID"));
					in.setInsurance_Name(c.get("Insurance_Name").toString());
					in.setInsurance_Company(c.get("Insurance_Company").toString());
					in.setInsurance_Type(c.get("Insurance_Type").toString());
					in.setInsurance_Description(c.get("Insurance_Description").toString());
					IN.add(in);
				}
				
			}
			return IN;
		} catch (Exception e) {
			
		}
		return null;
	}

}
