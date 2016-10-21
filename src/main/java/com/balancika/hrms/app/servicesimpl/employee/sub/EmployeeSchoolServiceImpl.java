package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.School;
import com.balancika.hrms.app.services.employee.sub.EmployeeSchoolServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeSchoolServiceImplJDBC")
public class EmployeeSchoolServiceImpl implements EmployeeSchoolServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(School school) {
		try {
			if(school != null){
				String SchoolName = tool.CheckStringNull(school.getSchool_Name());
				String Sch = "";
				Sch += "(";
				Sch += "'" + tool.CheckStringNull(school.getSchool_Name()) + "'";
				Sch += ")";
				return tool.SPSelect(school.meDataSource, "spHRMAddEmployeeSchool", school.meDataSource.getUserid(), SchoolName.toLowerCase(), Sch, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(School school) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeSchool", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public School get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public School getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<School> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<School> schools = new ArrayList<School>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeSchool", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					School s = new School();
					s.setSchool_Name(c.get("School_Name").toString());
					schools.add(s);
				}
			}
			return schools;
		} catch (Exception e) {
			
		}
		return null;
	}

}
