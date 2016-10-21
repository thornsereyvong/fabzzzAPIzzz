package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Type;
import com.balancika.hrms.app.services.employee.sub.EmployeeTypeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeTypeServiceImplJDBC")
public class EmployeeTypeServiceImpl implements EmployeeTypeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;


	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Type et) {
		try {
			if (et != null) {
				String typeName = tool.CheckStringNull(et.getType_Name());
				String type = "";
				type += "(";
				type += "'" + tool.CheckStringNull(et.getType_Name()) + "'";
				type += ")";
				return tool.SPSelect(et.meDataSource, "spHRMAddEmployeeType", et.meDataSource.getUserid(), typeName.toLowerCase(), type, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Type et) {
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String TypeName) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeType", meDataSource.getUserid(), TypeName);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Type get(MeDataSource meDataSource, String ID) {
		return null;
	}

	@Override
	public Type getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Type> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Type> ET = new ArrayList<Type>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeType", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Type et = new Type();
					et.setType_Name(c.get("Type_Name").toString());
					ET.add(et);
				}
			}
			return ET;
		} catch (Exception e) {
			
		}
		return null;
	}

}
