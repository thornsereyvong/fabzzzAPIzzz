package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Deduction;
import com.balancika.hrms.app.services.payroll.DeductionServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("DeductionServiceImplJDBC")
public class DeductionServiceImpl implements DeductionServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Deduction deduction) {
		try {
			if (deduction != null) {
				String EmpID = tool.CheckStringNull(deduction.getDeductionEmpID());
				String b = "";
				b += "(";
				b += "'Temp_ID',";
				b += "'" + tool.CheckStringNull(deduction.getDeductionEmpID()) + "',";
				b += "'" + tool.CheckDateNull(deduction.getDeductionDate()) + "',";
				b += "'" + tool.CheckStringNull(deduction.getDeductionReason()) + "',";
				b += "'" + deduction.getDeductionAmount() + "',";
				b += "'" + tool.CheckStringNull(deduction.getDeductionDescription()) + "',";
				b += "'Temp_Status'";
				b += ")";
				return tool.SPSelect(deduction.meDataSource, "spHRMAddDeduction", deduction.meDataSource.getUserid(), EmpID, b);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Deduction deduction) {
		try {
			if (deduction != null) {
				String b = "";
				String b_ID = deduction.getDeductionID();
				String EmpID = tool.CheckStringNull(deduction.getDeductionEmpID());
				b = "Deduction_ID='" + tool.CheckStringNull(deduction.getDeductionID()) + "',";
				b += "Deduction_EmpID='" + tool.CheckStringNull(deduction.getDeductionEmpID()) + "',";
				b += "Deduction_Date='" + tool.CheckDateNull(deduction.getDeductionDate()) + "',";
				b += "Deduction_Reason='" + tool.CheckStringNull(deduction.getDeductionReason()) + "',";
				b += "Deduction_Amount='" + deduction.getDeductionAmount() + "',";
				b += "Deduction_Description='" + tool.CheckStringNull(deduction.getDeductionDescription()) + "',";
				b += "Deduction_Status='Temp_Status'";
				return tool.SPSelect(deduction.meDataSource, "spHRMUpdateDeduction", deduction.meDataSource.getUserid(), "" + b_ID, EmpID, b);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteDeduction", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Deduction get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetDeductionID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Deduction deduction = new Deduction();
					deduction.setDeductionID(c.get("Deduction_ID").toString());
					deduction.setDeductionEmpID(c.get("Deduction_EmpID").toString());
					deduction.setDeductionDate(tool.ConvertDate(c.get("Deduction_Date").toString()));
					deduction.setDeductionReason(c.get("Deduction_Reason").toString());
					deduction.setDeductionAmount((double)c.get("Deduction_Amount"));
					deduction.setDeductionDescription(c.get("Deduction_Description").toString());
					deduction.setDeductionStatus(c.get("Deduction_Status").toString());
					List<ConcurrentHashMap<String, Object>> Data2 = MainData.get(1);
					if(Data2.size()>0){
						List<AuthorisationApproved> authorisationApproveds = new ArrayList<AuthorisationApproved>();
						for(ConcurrentHashMap<String, Object> c2 : Data2){
							AuthorisationApproved supervisor = new AuthorisationApproved();
							supervisor.setEmp_ID(c2.get("EmpID").toString());
							supervisor.setEmp_Name(c2.get("EmpName").toString());
							supervisor.setEmp_Email(c2.get("EmpEmail").toString());
							supervisor.setEmp_CompanyEmail(c2.get("Emp_CompanyEmail").toString());
							supervisor.setEmp_Position(c2.get("Position").toString());
							supervisor.setEmp_PositionKh(c2.get("PositionKhmer").toString());
							supervisor.setEmp_PositionLevel(c2.get("Position_Level").toString());
							supervisor.setEmp_UserName(c2.get("PositionKhmer").toString());
							supervisor.setEmp_UserName(c2.get("User_Name").toString());
							supervisor.setAuth_Status(c2.get("Auth_Status").toString());
							authorisationApproveds.add(supervisor);
						}
						deduction.authorisationApproved = authorisationApproveds;
					}
					return deduction;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Deduction getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deduction> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Deduction> deductions = new ArrayList<Deduction>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchDeduction", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Deduction deduction = new Deduction();
					deduction.setDeductionID(c.get("Deduction_ID").toString());
					deduction.setDeductionEmpID(c.get("Deduction_EmpID").toString());
					deduction.setDeductionDate(tool.ConvertDate(c.get("Deduction_Date").toString()));
					deduction.setDeductionReason(c.get("Deduction_Reason").toString());
					deduction.setDeductionAmount((double)c.get("Deduction_Amount"));
					deduction.setDeductionDescription(c.get("Deduction_Description").toString());
					deduction.setDeductionStatus(c.get("Deduction_Status").toString());
					deductions.add(deduction);
				}
			}
			return deductions;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Supervisor> sub(MeDataSource meDataSource) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetDeductionSub");
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Supervisor> supervisors = new ArrayList<Supervisor>();
		if(Data.size()>0){
			for(ConcurrentHashMap<String, Object> c : Data){
				Supervisor supervisor = new Supervisor();
				supervisor.setEmp_ID(c.get("EmpID").toString());
				supervisor.setEmp_Name(c.get("EmpName").toString());
				supervisor.setEmp_Email(c.get("EmpEmail").toString());
				supervisor.setEmp_CompanyEmail(c.get("Emp_CompanyEmail").toString());
				supervisor.setEmp_Position(c.get("Position").toString());
				supervisor.setEmp_PositionKh(c.get("PositionKhmer").toString());
				supervisor.setEmp_PositionLevel(c.get("Position_Level").toString());
				supervisor.setEmp_UserName(c.get("PositionKhmer").toString());
				supervisor.setEmp_UserName(c.get("User_Name").toString());
				supervisors.add(supervisor);
			}
		}
		return supervisors;
	}

}
