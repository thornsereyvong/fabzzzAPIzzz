package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApproved;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.Bonus;
import com.balancika.hrms.app.services.payroll.BonusServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("BonusServiceImplJDBC")
public class BonusServiceImpl implements BonusServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Bonus bonus) {
		try {
			if (bonus != null) {
				String EmpID = tool.CheckStringNull(bonus.getBonusEmpID());
				String b = "";
				b += "(";
				b += "'Temp_ID',";
				b += "'" + tool.CheckStringNull(bonus.getBonusEmpID()) + "',";
				b += "'" + tool.CheckDateNull(bonus.getBonusDate()) + "',";
				b += "'" + tool.CheckStringNull(bonus.getBonusReason()) + "',";
				b += "'" + bonus.getBonusAmount() + "',";
				b += "'" + tool.CheckStringNull(bonus.getBonusDescription()) + "',";
				b += "'Temp_Status'";
				b += ")";
				return tool.SPSelect(bonus.meDataSource, "spHRMAddBonus", bonus.meDataSource.getUserid(), EmpID, b);
			}			
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Bonus bonus) {
		try {
			if (bonus != null) {
				String b = "";
				String b_ID = bonus.getBonusID();
				String EmpID = tool.CheckStringNull(bonus.getBonusEmpID());
				b += "Bonus_ID='" + tool.CheckStringNull(bonus.getBonusID()) + "',";
				b += "Bonus_EmpID='" + tool.CheckStringNull(bonus.getBonusEmpID()) + "',";
				b += "Bonus_Date='" + tool.CheckDateNull(bonus.getBonusDate()) + "',";
				b += "Bonus_Reason='" + tool.CheckStringNull(bonus.getBonusReason()) + "',";
				b += "Bonus_Amount='" + bonus.getBonusAmount() + "',";
				b += "Bonus_Description='" + tool.CheckStringNull(bonus.getBonusDescription()) + "',";
				b += "Bonus_Status='Temp_Status'";
				return tool.SPSelect(bonus.meDataSource, "spHRMUpdateBonus", bonus.meDataSource.getUserid(), "" + b_ID, EmpID, b);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteBonus", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public Bonus get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetBonusID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Bonus b = new Bonus();
					b.setBonusID(c.get("Bonus_ID").toString());
					b.setBonusEmpID(c.get("Bonus_EmpID").toString());
					b.setBonusDate(tool.ConvertDate(c.get("Bonus_Date").toString()));
					b.setBonusReason(c.get("Bonus_Reason").toString());
					b.setBonusAmount((double)c.get("Bonus_Amount"));
					b.setBonusDescription(c.get("Bonus_Description").toString());
					b.setBonusStatus(c.get("Bonus_Status").toString());
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
						b.authorisationApproved = authorisationApproveds;
					}
					return b;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Bonus getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bonus> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Bonus> bonus = new ArrayList<Bonus>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchBonus", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Bonus b = new Bonus();
					b.setBonusID(c.get("Bonus_ID").toString());
					b.setBonusEmpID(c.get("Bonus_EmpID").toString());
					b.setBonusDate(tool.ConvertDate(c.get("Bonus_Date").toString()));
					b.setBonusReason(c.get("Bonus_Reason").toString());
					b.setBonusAmount((double)c.get("Bonus_Amount"));
					b.setBonusDescription(c.get("Bonus_Description").toString());
					b.setBonusStatus(c.get("Bonus_Status").toString());
					bonus.add(b);
				}
				
			}
			return bonus;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public List<Supervisor> sub(MeDataSource meDataSource) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetBonusSub");
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
