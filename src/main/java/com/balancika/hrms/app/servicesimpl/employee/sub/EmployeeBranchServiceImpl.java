package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Branch;
import com.balancika.hrms.app.services.employee.sub.EmployeeBranchServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeBranchServiceImplJDBC")
public class EmployeeBranchServiceImpl implements EmployeeBranchServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Branch br) {
		try {
			if (br != null) {
				String BranchName = tool.CheckStringNull(br.getBranch_Name());
				String branch = "";
				branch += "(";
				branch += "'Temp_ID',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Name()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Tel()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Description()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Address()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_HomeNo()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Street()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Village()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_District()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Commune()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_City()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_State()) + "',";
				branch += "'" + tool.CheckStringNull(br.getBranch_Country()) + "'";
				branch += ")";
				return tool.SPSelect(br.meDataSource, "spHRMAddEmployeeBranch", br.meDataSource.getUserid(), BranchName.toLowerCase(), branch);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Branch EB) {
		try {
			if(EB != null){
				if(EB != null){
					String BranchName = tool.CheckStringNull(EB.getBranch_Name());
					String branch = "";
					branch += "Branch_ID='" + tool.CheckStringNull(EB.getBranch_ID()) + "',";
					branch += "Branch_Name='" + tool.CheckStringNull(EB.getBranch_Name()) + "',";
					branch += "Branch_Tel='" + tool.CheckStringNull(EB.getBranch_Tel()) + "',";
					branch += "Branch_Description='" + tool.CheckStringNull(EB.getBranch_Description()) + "',";
					branch += "Branch_Address='" + tool.CheckStringNull(EB.getBranch_Address()) + "',";
					branch += "Branch_HomeNo='" + tool.CheckStringNull(EB.getBranch_HomeNo()) + "',";
					branch += "Branch_Street='" + tool.CheckStringNull(EB.getBranch_Street()) + "',";
					branch += "Branch_Village='" + tool.CheckStringNull(EB.getBranch_Village()) + "',";
					branch += "Branch_District='" + tool.CheckStringNull(EB.getBranch_District()) + "',";
					branch += "Branch_Commune='" + tool.CheckStringNull(EB.getBranch_Commune()) + "',";
					branch += "Branch_City='" + tool.CheckStringNull(EB.getBranch_City()) + "',";
					branch += "Branch_State='" + tool.CheckStringNull(EB.getBranch_State()) + "',";
					branch += "Branch_Country='" + tool.CheckStringNull(EB.getBranch_Country()) + "'";
					return tool.SPSelect(EB.meDataSource, "spHRMUpdateEmployeeBranch", EB.meDataSource.getUserid(), "" + EB.getBranch_ID(), BranchName.toLowerCase(), branch);
				}
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeBranch", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Branch get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeBranchID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Branch eb = new Branch();
					eb.setBranch_ID(c.get("Branch_ID").toString());
					eb.setBranch_Name(c.get("Branch_Name").toString());
					eb.setBranch_Tel(c.get("Branch_Tel").toString());
					eb.setBranch_Description(c.get("Branch_Description").toString());
					eb.setBranch_Address(c.get("Branch_Address").toString());
					eb.setBranch_HomeNo(c.get("Branch_HomeNo").toString());
					eb.setBranch_Street(c.get("Branch_Street").toString());
					eb.setBranch_Village(c.get("Branch_Village").toString());
					eb.setBranch_District(c.get("Branch_District").toString());
					eb.setBranch_Commune(c.get("Branch_Commune").toString());
					eb.setBranch_City(c.get("Branch_City").toString());
					eb.setBranch_State(c.get("Branch_State").toString());
					eb.setBranch_Country(c.get("Branch_Country").toString());
					return eb;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Branch getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Branch> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeBranch", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Branch> EB = new ArrayList<Branch>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Branch eb = new Branch();
					eb.setBranch_ID(c.get("Branch_ID").toString());
					eb.setBranch_Name(c.get("Branch_Name").toString());
					eb.setBranch_Tel(c.get("Branch_Tel").toString());
					eb.setBranch_Description(c.get("Branch_Description").toString());
					eb.setBranch_Address(c.get("Branch_Address").toString());
					eb.setBranch_HomeNo(c.get("Branch_HomeNo").toString());
					eb.setBranch_Street(c.get("Branch_Street").toString());
					eb.setBranch_Village(c.get("Branch_Village").toString());
					eb.setBranch_District(c.get("Branch_District").toString());
					eb.setBranch_Commune(c.get("Branch_Commune").toString());
					eb.setBranch_City(c.get("Branch_City").toString());
					eb.setBranch_State(c.get("Branch_State").toString());
					eb.setBranch_Country(c.get("Branch_Country").toString());
					EB.add(eb);
				}
			}
			return EB;
		} catch (Exception e) {
			
		}
		return null;
	}

}
