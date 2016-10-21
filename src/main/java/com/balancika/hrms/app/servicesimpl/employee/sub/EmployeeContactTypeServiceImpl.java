package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.ContractType;
import com.balancika.hrms.app.services.employee.sub.EmployeeContractTypeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeContractTypeServiceImplJDBC")
public class EmployeeContactTypeServiceImpl implements EmployeeContractTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(ContractType ect) {
		try {
			if (ect != null) {
				String ContactTypeName = tool.CheckStringNull(ect.getContactType_Name());
				String ContactType = "";
				ContactType += "(";
				ContactType += "'" + tool.CheckStringNull(ect.getContactType_Name()) + "'";
				ContactType += ")";
				return tool.SPSelect(ect.meDataSource, "spHRMAddEmployeeContractType", ect.meDataSource.getUserid(), ContactTypeName.toLowerCase(), ContactType, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(ContractType employeeContactTypes) {
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ContactTypeName) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeContractType", meDataSource.getUserid(), ContactTypeName);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public ContractType get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeContractTypeID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					ContractType ect = new ContractType();
					ect.setContactType_Name(c.get("ContractType_Name").toString());
					return ect;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public ContractType getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContractType> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<ContractType> ECT = new ArrayList<ContractType>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeContractType", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					ContractType ect = new ContractType();
					ect.setContactType_Name(c.get("ContractType_Name").toString());
					ECT.add(ect);
				}
			}
			return ECT;
		} catch (Exception e) {
			
		}
		return null;
	}

}
