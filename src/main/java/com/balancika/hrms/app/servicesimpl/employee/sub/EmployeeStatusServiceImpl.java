package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Status;
import com.balancika.hrms.app.services.employee.sub.EmployeeStatusServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeStatusServiceImplJDBC")
public class EmployeeStatusServiceImpl implements EmployeeStatusServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Status es) {
		try {
			if(es != null){
				String statusName = tool.CheckStringNull(es.getStatus_Name());
				String status = "";
				status += "(";
				status += "'" + tool.CheckStringNull(es.getStatus_Name()) + "'";
				status += ")";
				return tool.SPSelect(es.meDataSource, "spHRMAddEmployeeStatus", es.meDataSource.getUserid(), statusName.toLowerCase(), status, "1");
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Status employeeStatus) {
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeStatus", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Status get(MeDataSource meDataSource, String StatusID) {
		
		return null;
	}

	@Override
	public Status getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Status> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Status> ES = new ArrayList<Status>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeStatus", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Status es = new Status();
					es.setStatus_Name(c.get("Status_Name").toString());
					ES.add(es);
				}
			}
			return ES;
		} catch (Exception e) {
			
		}
		return null;
	}

	
}
