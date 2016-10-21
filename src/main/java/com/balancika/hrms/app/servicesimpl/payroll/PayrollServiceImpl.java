package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.Payroll;
import com.balancika.hrms.app.services.payroll.PayrollServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("PayrollServiceImplJDBC")
public class PayrollServiceImpl implements PayrollServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Payroll payroll) {
		try {
			if (payroll != null) {
				String PayrollName = tool.CheckStringNull(payroll.getPayrollName());
				String p = "";
				p += "(";
				p += "'Temp_ID',";
				p += "'" + tool.CheckStringNull(payroll.getPayrollName()) + "',";
				p += "'" + tool.CheckStringNull(payroll.getPayrollType()) + "',";
				p += "'" + tool.CheckDateNull(payroll.getPayrollStartDate()) + "',";
				p += "'" + tool.CheckDateNull(payroll.getPayrollStartDate()) + "',";
				p += "'" + tool.CheckDateNull(payroll.getPayrollStartDate()) + "'";
				p += ")";
				return tool.SPSelect(payroll.meDataSource, "spHRMAddPayroll", payroll.meDataSource.getUserid(), PayrollName, p);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Payroll payroll) {
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeletePayroll", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Payroll get(MeDataSource meDataSource, String ID) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetPayrollID", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Payroll p = new Payroll();
				p.setPayrollID(c.get("Payroll_ID").toString());
				p.setPayrollName(c.get("Payroll_Name").toString());
				p.setPayrollType(c.get("Payroll_Type").toString());
				p.setPayrollStartDate(tool.ConvertDate(c.get("Payroll_StartDate").toString()));
				p.setPayrollLastSubmitDate(tool.ConvertDate(c.get("Payroll_LastSubmitDate").toString()));
				p.setPayrollSubmitDate(tool.ConvertDate(c.get("Payroll_SubmitDate").toString()));
				return p;
			}
		}
		return null;
	}

	@Override
	public Payroll getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Payroll> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Payroll> payrolls = new ArrayList<Payroll>();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchPayroll", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Payroll p = new Payroll();
				p.setPayrollID(c.get("Payroll_ID").toString());
				p.setPayrollName(c.get("Payroll_Name").toString());
				p.setPayrollType(c.get("Payroll_Type").toString());
				p.setPayrollStartDate(tool.ConvertDate(c.get("Payroll_StartDate").toString()));
				p.setPayrollLastSubmitDate(tool.ConvertDate(c.get("Payroll_LastSubmitDate").toString()));
				p.setPayrollSubmitDate(tool.ConvertDate(c.get("Payroll_SubmitDate").toString()));
				payrolls.add(p);
			}
			return payrolls;
		}
		return null;
	}

}
