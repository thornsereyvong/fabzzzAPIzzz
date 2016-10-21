package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Category;
import com.balancika.hrms.app.services.employee.sub.EmployeeCategoryServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;


@Service("EmployeeCategoryServiceImplJDBC")
public class EmployeeCategoryServiceImpl implements EmployeeCategoryServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Category ec) {
		try {
			if (ec != null) {
				String CategoryName = tool.CheckStringNull(ec.getCategory_Name());
				String category = "";
				category += "(";
				category += "'" + tool.CheckStringNull(ec.getCategory_Name()) + "'";
				category += ")";
				return tool.SPSelect(ec.meDataSource, "spHRMAddEmployeeCategory", ec.meDataSource.getUserid(), CategoryName.toLowerCase(), category, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Category employeeCategories) {
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeCategory", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Category get(MeDataSource meDataSource, String ID) {
		return null;
	}

	@Override
	public Category getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Category> EC = new ArrayList<Category>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeCategory", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Category ec = new Category();
					ec.setCategory_Name(c.get("Category_Name").toString());
					EC.add(ec);
				}
			}
			return EC;
		} catch (Exception e) {
			
		}
		return null;
	}

}
