package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Nationals;
import com.balancika.hrms.app.services.employee.sub.EmployeeNationalsServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("NationalsServiceImplJDBC")
public class EmployeeNationalsServiceImpl implements EmployeeNationalsServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Nationals n) {
		try {
			if(n != null){
				String NationalsName = tool.CheckStringNull(n.getNationals_Name());
				String Nationals = "";
				Nationals += "(";
				Nationals += "'" + tool.CheckStringNull(n.getNationals_Name()) + "'";
				Nationals += ")";
				return tool.SPSelect(n.meDataSource, "spHRMAddEmployeeNationals", n.meDataSource.getUserid(), NationalsName.toLowerCase(), Nationals, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Nationals religions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource,	String Name) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeNationals", meDataSource.getUserid(), Name);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Nationals get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Nationals getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Nationals> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Nationals> R = new ArrayList<Nationals>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeNationals", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationals r = new Nationals();
					r.setNationals_Name(c.get("Nationals_Name").toString());
					R.add(r);
				}
			}
			return R;
		} catch (Exception e) {
			
		}
		return null;
	}

}
