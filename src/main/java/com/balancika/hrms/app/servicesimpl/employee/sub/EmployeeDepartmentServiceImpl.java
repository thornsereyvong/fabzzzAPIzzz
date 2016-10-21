package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Department;
import com.balancika.hrms.app.services.employee.sub.EmployeeDepartmentServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeDepartmentServiceImplJDBC")
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Department ed) {
		try {
			if (ed != null) {
				String departmentName = tool.CheckStringNull(ed.getDepartment_Name());
				String department = "";
				department += "(";
				department += "'Temp_ID',";
				department += "'" + tool.CheckStringNull(ed.getDepartment_Name()) + "',";
				department += "'" + tool.CheckStringNull(ed.getDepartment_Description()) + "',";
				department += "'" + tool.CheckStringNull(ed.getDepartment_Parent()) + "'";
				department += ")";
				return tool.SPSelect(ed.meDataSource, "spHRMAddEmployeeDepartment", ed.meDataSource.getUserid(), departmentName.toLowerCase(), department);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Department ED) {
		try {
			if(ED != null){
				if(ED != null){
					String departmentName = tool.CheckStringNull(ED.getDepartment_Name());
					String department  = "";
					String Department_ID = ED.getDepartment_ID();
					department += "Department_ID='" + tool.CheckStringNull(ED.getDepartment_ID()) + "',";
					department += "Department_Name='" + tool.CheckStringNull(ED.getDepartment_Name()) + "',";
					department += "Department_Description='" + tool.CheckStringNull(ED.getDepartment_Description()) + "',";
					department += "Department_Parent='" + tool.CheckStringNull(ED.getDepartment_Parent()) + "'";
					return tool.SPSelect(ED.meDataSource, "spHRMUpdateEmployeeDepartment",ED.meDataSource.getUserid(), ""+Department_ID, departmentName.toLowerCase(), department);
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeDepartment", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Department get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeDepartmentID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Department ed = new Department();
					ed.setDepartment_ID(c.get("Department_ID").toString());
					ed.setDepartment_Name(c.get("Department_Name").toString());
					ed.setDepartment_Description(c.get("Department_Description").toString());
					ed.setDepartment_Parent(c.get("Department_Parent").toString());
					return ed;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Department getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Department> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Department> ED = new ArrayList<Department>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeDepartment", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Department ed = new Department();
					ed.setDepartment_ID(c.get("Department_ID").toString());
					ed.setDepartment_Name(c.get("Department_Name").toString());
					ed.setDepartment_Description(c.get("Department_Description").toString());
					ed.setDepartment_Parent(c.get("Department_Parent").toString());
					ED.add(ed);
				}
				
			}
			return ED;
		} catch (Exception e) {
			
		}
		return null;
	}

}
