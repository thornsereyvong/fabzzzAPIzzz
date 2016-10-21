package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Nationality;
import com.balancika.hrms.app.services.employee.sub.EmployeeNationalityServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("NationalityServiceImplJDBC")
public class EmployeeNationalityServiceImpl implements EmployeeNationalityServices{
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Nationality n) {
		try {
			if(n != null){
				String NationalityName = tool.CheckStringNull(n.getNationality_Name());
				String Nationality = "";
				Nationality += "(";
				Nationality += "'" + tool.CheckStringNull(n.getNationality_Name()) + "'";
				Nationality += ")";
				return tool.SPSelect(n.meDataSource, "spHRMAddEmployeeNationality", n.meDataSource.getUserid(), NationalityName.toLowerCase(), Nationality, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Nationality nationalities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String Name) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeNationality", meDataSource.getUserid(), Name);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Nationality get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nationality getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nationality> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Nationality> N = new ArrayList<Nationality>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeNationality", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationality n = new Nationality();
					n.setNationality_Name(c.get("Nationnality_Name").toString());
					N.add(n);
				}
			}
			return N;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
