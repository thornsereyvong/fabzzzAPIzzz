package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Bank;
import com.balancika.hrms.app.services.employee.sub.EmployeeBankServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeBankServiceImplJDBC")
public class EmployeeBankServiceImpl implements EmployeeBankServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Bank eb) {
		try {
			if (eb != null) {
				String BankName = tool.CheckStringNull(eb.getBank_Name());
				String bank = "";
				bank += "(";
				bank += "'Temp_ID',";
				bank += "'" + tool.CheckStringNull(eb.getBank_Name()) + "',";
				bank += "'" + tool.CheckStringNull(eb.getBank_Description()) + "'";
				bank += ")";
				return tool.SPSelect(eb.meDataSource, "spHRMAddEmployeeBank", eb.meDataSource.getUserid(), BankName.toLowerCase(), bank);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Bank EB) {
		try {
			if (EB != null) {
				String Bank = "";
				int Bank_ID = EB.getBank_ID();
				String BankName = tool.CheckStringNull(EB.getBank_Name());
				Bank += "Bank_ID='" + EB.getBank_ID() + "',";
				Bank += "Bank_Name='" + tool.CheckStringNull(EB.getBank_Name()) + "',";
				Bank += "Bank_Description='" + tool.CheckStringNull(EB.getBank_Description()) + "'";
				return tool.SPSelect(EB.meDataSource, "spHRMUpdateEmployeeBank", EB.meDataSource.getUserid(), "" + Bank_ID, BankName.toLowerCase(), Bank);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeBank", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Bank get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeBankID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Bank eb = new Bank();
					eb.setBank_ID((c.get("Bank_ID").toString() == "")? 0 : (int)c.get("Bank_ID"));
					eb.setBank_Name(c.get("Bank_Name").toString());
					eb.setBank_Description(c.get("Bank_Description").toString());
					return eb;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Bank getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bank> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Bank> EB = new ArrayList<Bank>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeBank", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Bank eb = new Bank();
					eb.setBank_ID((c.get("Bank_ID").toString() == "")? 0 : (int)c.get("Bank_ID"));
					eb.setBank_Name(c.get("Bank_Name").toString());
					eb.setBank_Description(c.get("Bank_Description").toString());
					EB.add(eb);
				}
				
			}
			return EB;
		} catch (Exception e) {
			
		}
		return null;
	}

}
