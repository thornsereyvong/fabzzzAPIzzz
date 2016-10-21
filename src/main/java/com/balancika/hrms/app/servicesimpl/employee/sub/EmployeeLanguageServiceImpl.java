package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Language;
import com.balancika.hrms.app.services.employee.sub.EmployeeLanguageServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeLanguageServiceImplJDBC")
public class EmployeeLanguageServiceImpl implements EmployeeLanguageServices {

	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Language el) {
		try {
			if(el != null){
				String LanguageName = tool.CheckStringNull(el.getLanguage_Name());
				String Language = "";
				Language += "(";
				Language += "'" + tool.CheckStringNull(el.getLanguage_Name()) + "'";
				Language += ")";
				return tool.SPSelect(el.meDataSource, "spHRMAddEmployeeLanguage", el.meDataSource.getUserid(), LanguageName.toLowerCase(), Language, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Language employeeLanguages) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String LanuguageName) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeLanguage", meDataSource.getUserid(), LanuguageName);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Language get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Language getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Language> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Language> EL = new ArrayList<Language>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeLanguage", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Language el = new Language();
					el.setLanguage_Name(c.get("Language_Name").toString());
					EL.add(el);
				}
			}
			return EL;
		} catch (Exception e) {
			
		}
		return null;
	}

}
