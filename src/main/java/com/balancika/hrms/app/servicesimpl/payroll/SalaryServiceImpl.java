package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Payroll;
import com.balancika.hrms.app.entities.payroll.Salary;
import com.balancika.hrms.app.entities.payroll.SalarySub;
import com.balancika.hrms.app.services.payroll.SalaryServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("SalaryServiceImplJDBC")
public class SalaryServiceImpl implements SalaryServices{
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Salary salary) {
		try {
			if (salary != null) {
				String s = "";
				s += "(";
				s += "'" + tool.CheckStringNull(salary.getSalaryEmpID()) + "',";
				s += "'" + tool.CheckStringNull(salary.getSalaryPayrollID()) + "',";
				s += "'" + tool.CheckStringNull(salary.getSalaryType()) + "',";
				s += salary.getSalaryAmount() + ",";
				s += "'TempDay'";
				s += ")";
				return tool.SPSelect(salary.meDataSource, "spHRMAddSalary", salary.meDataSource.getUserid(), tool.CheckStringNull(salary.getSalaryEmpID()), tool.CheckStringNull(salary.getSalaryPayrollID()), tool.CheckDateNull(salary.getSalaryStartDate()).toString(), s);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Salary salary) {
		try {
			if(salary != null){
				if(salary != null){
					String EmpID = tool.CheckStringNull(salary.getSalaryEmpID());
					String s = "";
					s += "Salary_EmpID='" + tool.CheckStringNull(salary.getSalaryEmpID()) + "',";
					s += "Salary_PayrollID='" + tool.CheckStringNull(salary.getSalaryPayrollID()) + "',";
					s += "Salary_Type='" + tool.CheckStringNull(salary.getSalaryType()) + "',";
					s += "Salary_Amount=" + salary.getSalaryAmount() + ",";
					s += "Salary_StartDate='TempDay'";
//					Calendar c = Calendar.getInstance(); 
//					c.setTime(tool.CheckDateNull(salary.getSalaryStartDate()));
//					c.add(Calendar.MONTH, -1);
//					java.sql.Date EndDate = new java.sql.Date(c.getTime().getTime());
					return tool.SPSelect(salary.meDataSource, "spHRMUpdateSalary", salary.meDataSource.getUserid(), "" + EmpID, tool.CheckStringNull(salary.getSalaryPayrollID()), tool.CheckDateNull(salary.getSalaryStartDate()).toString(), s);
				}
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetSalaryID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Salary> salaries = new ArrayList<Salary>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Salary s = new Salary();
					s.setSalaryEmpID(c.get("Salary_EmpID").toString());
					s.setSalaryPayrollID(c.get("Salary_PayrollID").toString());
					s.setSalaryType(c.get("Salary_Type").toString());
					s.setSalaryAmount(Double.parseDouble(c.get("Salary_Amount").toString()));
					s.setSalaryStartDate(tool.ConvertDate(c.get("Salary_StartDate").toString()));
					salaries.add(s);
				}
				return salaries;
			}
			
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Salary getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Salary> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchSalary", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Salary> salaries = new ArrayList<Salary>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Salary s = new Salary();
					s.setSalaryEmpID(c.get("Salary_EmpID").toString());
					s.setSalaryPayrollID(c.get("Salary_PayrollID").toString());
					s.setSalaryType(c.get("Salary_Type").toString());
					s.setSalaryAmount(Double.parseDouble(c.get("Salary_Amount").toString()));
					s.setSalaryStartDate(tool.ConvertDate(c.get("Salary_StartDate").toString()));
					salaries.add(s);
				}
			}
			return salaries;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public SalarySub Sub(MeDataSource meDataSource) {
		SalarySub salarySub = new SalarySub();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetSalarySub");
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Supervisor> supervisors = new ArrayList<Supervisor>();
		List<Payroll> payrolls = new ArrayList<Payroll>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Supervisor supervisor = new Supervisor();
				supervisor.setEmp_ID(c.get("EmpID").toString());
				supervisor.setEmp_Name(c.get("EmpName").toString());
				supervisor.setEmp_Email(c.get("EmpEmail").toString());
				supervisor.setEmp_CompanyEmail(c.get("EmpEmail").toString());
				supervisor.setEmp_Position(c.get("Position").toString());
				supervisor.setEmp_PositionKh(c.get("PositionKhmer").toString());
				supervisor.setEmp_PositionLevel(c.get("Position_Level").toString());
				supervisor.setEmp_UserName(c.get("PositionKhmer").toString());
				supervisor.setEmp_UserName(c.get("User_Name").toString());
				supervisors.add(supervisor);
			}
			salarySub.employee = supervisors;
		}
		Data = MainData.get(1);
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
			salarySub.payroll = payrolls;
		}
		return salarySub;
	}

}
