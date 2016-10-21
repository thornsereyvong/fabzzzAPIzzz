package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.InsuranceType;
import com.balancika.hrms.app.services.employee.sub.EmployeeInsuranceTypeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeInsuranceTypeServiceImplJDBC")
public class EmployeeInsuranceTypeServiceImpl implements EmployeeInsuranceTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(InsuranceType it) {
		try {
				if(it != null){
					String InsuranceTypeName = tool.CheckStringNull(it.getInsuranceType_Name());
					String InsuranceType = "";
					InsuranceType += "(";
					InsuranceType += "'" + tool.CheckStringNull(it.getInsuranceType_Name()) + "'";
					InsuranceType += ")";
					return tool.SPSelect(it.meDataSource, "spHRMAddEmployeeInsuranceType", it.meDataSource.getUserid(), InsuranceTypeName.toLowerCase(), InsuranceType, "1");
				}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(InsuranceType insuranceTypes) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String InsuranceTypeName) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeInsuranceType", meDataSource.getUserid(), InsuranceTypeName);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public InsuranceType get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InsuranceType getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InsuranceType> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<InsuranceType> IT = new ArrayList<InsuranceType>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeInsuranceType", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					InsuranceType it = new InsuranceType();
					it.setInsuranceType_Name(c.get("InsuranceType_Name").toString());
					IT.add(it);
				}
			}
			return IT;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
