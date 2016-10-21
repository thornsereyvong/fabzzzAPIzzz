package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Level;
import com.balancika.hrms.app.services.employee.sub.EmployeeLevelServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeLevelServiceImplJDBC")
public class EmployeeLevelServiceImpl implements EmployeeLevelServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Level el) {
		try {
			if(el != null){
				String LevelName = tool.CheckStringNull(el.getLevel_Name());
				String Level = "";
				Level += "(";
				Level += "'" + tool.CheckStringNull(el.getLevel_Name()) + "'";
				Level += ")";
				return tool.SPSelect(el.meDataSource, "spHRMAddEmployeeLevel", el.meDataSource.getUserid(), LevelName.toLowerCase(), Level);
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Level employeeLevels) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String LevelName) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeLevel", meDataSource.getUserid(), LevelName);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Level get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Level getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Level> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Level> EL = new ArrayList<Level>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeLevel", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Level el = new Level();
					el.setLevel_Name(c.get("Level_Name").toString());
					EL.add(el);
				}
			}
			return EL;
		} catch (Exception e) {
			
		}
		return null;
	}

}
