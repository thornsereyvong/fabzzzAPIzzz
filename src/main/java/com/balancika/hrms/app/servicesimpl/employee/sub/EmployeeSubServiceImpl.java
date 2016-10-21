package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.Employee;
import com.balancika.hrms.app.entities.employee.EmployeeAttachment;
import com.balancika.hrms.app.entities.employee.EmployeeContract;
import com.balancika.hrms.app.entities.employee.EmployeeEducation;
import com.balancika.hrms.app.entities.employee.EmployeeExperience;
import com.balancika.hrms.app.entities.employee.EmployeeFamily;
import com.balancika.hrms.app.entities.employee.EmployeeInsurance;
import com.balancika.hrms.app.entities.employee.EmployeeLanguage;
import com.balancika.hrms.app.entities.employee.EmployeeMemberShip;
import com.balancika.hrms.app.entities.employee.EmployeeSkill;
import com.balancika.hrms.app.entities.employee.EmployeeSocialCommunication;
import com.balancika.hrms.app.entities.employee.EmployeeTraining;
import com.balancika.hrms.app.entities.employee.EmployeeUser;
import com.balancika.hrms.app.entities.employee.sub.Bank;
import com.balancika.hrms.app.entities.employee.sub.Branch;
import com.balancika.hrms.app.entities.employee.sub.Category;
import com.balancika.hrms.app.entities.employee.sub.ContractType;
import com.balancika.hrms.app.entities.employee.sub.Country;
import com.balancika.hrms.app.entities.employee.sub.Department;
import com.balancika.hrms.app.entities.employee.sub.Insurance;
import com.balancika.hrms.app.entities.employee.sub.InsuranceType;
import com.balancika.hrms.app.entities.employee.sub.Language;
import com.balancika.hrms.app.entities.employee.sub.Level;
import com.balancika.hrms.app.entities.employee.sub.MembershipType;
import com.balancika.hrms.app.entities.employee.sub.Nationality;
import com.balancika.hrms.app.entities.employee.sub.Position;
import com.balancika.hrms.app.entities.employee.sub.Nationals;
import com.balancika.hrms.app.entities.employee.sub.School;
import com.balancika.hrms.app.entities.employee.sub.SocialCommunication;
import com.balancika.hrms.app.entities.employee.sub.Status;
import com.balancika.hrms.app.entities.employee.sub.EmployeeSub;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.employee.sub.Type;
import com.balancika.hrms.app.entities.employee.sub.WorkShift;
import com.balancika.hrms.app.services.employee.sub.EmployeeSubServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeSubServiceImplJDBC")
public class EmployeeSubServiceImpl implements EmployeeSubServices{
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public EmployeeSub get(MeDataSource meDataSource) {
		try {
			EmployeeSub ES = new EmployeeSub();
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeSub");
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			
			if(Data.size()>0){
				ArrayList<Bank> EB = new ArrayList<Bank>();
				for(ConcurrentHashMap<String, Object> c : Data){
					Bank eb = new Bank();
					eb.setBank_ID((c.get("Bank_ID").toString() == "")? 0 : (int)c.get("Bank_ID"));
					eb.setBank_Name(c.get("Bank_Name").toString());
					eb.setBank_Description(c.get("Bank_Description").toString());
					EB.add(eb);
				}
				ES.bank = EB;
			}
			
			Data = MainData.get(1);
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
			ES.branch = EB;
			
			Data = MainData.get(2);
			List<Category> EC = new ArrayList<Category>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Category ec = new Category();
					ec.setCategory_Name(c.get("Category_Name").toString());
					EC.add(ec);
				}
			}
			ES.category = EC;
			
			Data = MainData.get(3);
			List<ContractType> ECT = new ArrayList<ContractType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					ContractType ect = new ContractType();
					ect.setContactType_Name(c.get("ContractType_Name").toString());
					ECT.add(ect);
				}
			}
			ES.contractType = ECT;
			
			Data = MainData.get(4);
			List<Position> EP = new ArrayList<Position>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Position ep = new Position();
					ep.setPosition_ID((c.get("Position_ID").toString() == "")? 0 : (int)c.get("Position_ID"));
					ep.setPosition_Name(c.get("Position").toString());
					ep.setPosition_NameKh(c.get("PositionKhmer").toString());
					ep.setPosition_Level((c.get("Position_Level").toString() == "")? 0 : (int)c.get("Position_Level"));
					ep.setPosition_Description(c.get("Position_Description").toString());
					EP.add(ep);
				}
			}
			ES.position = EP;
			
			Data = MainData.get(5);
			List<Status> ESt = new ArrayList<Status>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Status es = new Status();
					es.setStatus_Name(c.get("Status_Name").toString());
					ESt.add(es);
				}
			}
			ES.status = ESt;
			
			Data = MainData.get(6);
			List<Type> ET = new ArrayList<Type>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Type et = new Type();
					et.setType_Name(c.get("Type_Name").toString());
					ET.add(et);
				}
			}
			ES.type = ET;
			
			Data = MainData.get(7);
			List<Department> ED = new ArrayList<Department>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Department ed = new Department();
					ed.setDepartment_ID(c.get("Department_ID").toString());
					ed.setDepartment_Name(c.get("Department_Name").toString());
					ed.setDepartment_Description(c.get("Department_Description").toString());
					ED.add(ed);
				}
				
			}
			ES.department = ED;
			
			Data = MainData.get(8);
			List<MembershipType> EMT = new ArrayList<MembershipType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					MembershipType emt = new MembershipType();
					emt.setMembershipType_Name(c.get("MembershipType_Name").toString());
					EMT.add(emt);
				}
			}
			ES.membershipType = EMT;
			
			Data = MainData.get(9);
			List<Language> EL = new ArrayList<Language>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Language el = new Language();
					el.setLanguage_Name(c.get("Language_Name").toString());
					EL.add(el);
				}
			}
			ES.language = EL;
			
			Data = MainData.get(10);
			List<Level> ELevel = new ArrayList<Level>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Level el = new Level();
					el.setLevel_Name(c.get("Level_Name").toString());
					ELevel.add(el);
				}
			}
			ES.level = ELevel;
			
			Data = MainData.get(11);
			List<InsuranceType> IT = new ArrayList<InsuranceType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					InsuranceType it = new InsuranceType();
					it.setInsuranceType_Name(c.get("InsuranceType_Name").toString());
					IT.add(it);
				}
			}
			ES.insuranceType = IT;
			
			Data = MainData.get(12);
			List<SocialCommunication> SC = new ArrayList<SocialCommunication>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					SocialCommunication sc = new SocialCommunication();
					sc.setSocialCommunication_Name(c.get("SocialCommunication_Name").toString());
					SC.add(sc);
				}
			}
			ES.socialCommunication = SC;
			
			
			Data = MainData.get(13);
			List<Nationality> N = new ArrayList<Nationality>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationality n = new Nationality();
					n.setNationality_Name(c.get("Nationnality_Name").toString());
					N.add(n);
				}
			}
			ES.nationality = N;
			
			Data = MainData.get(14);
			List<Nationals> nationals = new ArrayList<Nationals>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationals r = new Nationals();
					r.setNationals_Name(c.get("Nationals_Name").toString());
					nationals.add(r);
				}
			}
			ES.nationals = nationals;
			
			Data = MainData.get(15);
			List<School> schools = new ArrayList<School>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					School s = new School();
					s.setSchool_Name(c.get("School_Name").toString());
					schools.add(s);
				}
			}
			ES.school = schools;
			
			Data = MainData.get(16);
			List<Supervisor> supervisors = new ArrayList<Supervisor>();
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
			}
			ES.supervisor = supervisors;
			
			Data = MainData.get(17);
			List<WorkShift> workShifts = new ArrayList<WorkShift>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					WorkShift workShift = new WorkShift();
					workShift.setShift_ID(c.get("Shift_ID").toString());
					workShift.setShift_Name(c.get("Shift_Name").toString());
					workShifts.add(workShift);
				}
			}
			ES.workShift = workShifts;
			
			Data = MainData.get(18);
			List<Insurance> IN = new ArrayList<Insurance>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Insurance in = new Insurance();
					in.setInsurance_ID((c.get("Insurance_ID").toString() == "")? 0 : (int)c.get("Insurance_ID"));
					in.setInsurance_Name(c.get("Insurance_Name").toString());
					in.setInsurance_Company(c.get("Insurance_Company").toString());
					in.setInsurance_Type(c.get("Insurance_Type").toString());
					in.setInsurance_Description(c.get("Insurance_Description").toString());
					IN.add(in);
				}
				
			}
			ES.insurance = IN;
			
			Data = MainData.get(19);
			List<Country> countries = new ArrayList<Country>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Country country = new Country();
					country.setCountryName(c.get("Country_Name").toString());
					countries.add(country);
				}
				
			}
			ES.country = countries;
						
			return ES;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public EmployeeSub get(MeDataSource meDataSource, String ID) {
		try {
			EmployeeSub ES = new EmployeeSub();
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeSubUpdate", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			
			if(Data.size()>0){
				ArrayList<Bank> EB = new ArrayList<Bank>();
				for(ConcurrentHashMap<String, Object> c : Data){
					Bank eb = new Bank();
					eb.setBank_ID((c.get("Bank_ID").toString() == "")? 0 : (int)c.get("Bank_ID"));
					eb.setBank_Name(c.get("Bank_Name").toString());
					eb.setBank_Description(c.get("Bank_Description").toString());
					EB.add(eb);
				}
				ES.bank = EB;
			}
			
			Data = MainData.get(1);
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
			ES.branch = EB;
			
			Data = MainData.get(2);
			List<Category> EC = new ArrayList<Category>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Category ec = new Category();
					ec.setCategory_Name(c.get("Category_Name").toString());
					EC.add(ec);
				}
			}
			ES.category = EC;
			
			Data = MainData.get(3);
			List<ContractType> ECT = new ArrayList<ContractType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					ContractType ect = new ContractType();
					ect.setContactType_Name(c.get("ContractType_Name").toString());
					ECT.add(ect);
				}
			}
			ES.contractType = ECT;
			
			Data = MainData.get(4);
			List<Position> EP = new ArrayList<Position>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Position ep = new Position();
					ep.setPosition_ID((c.get("Position_ID").toString() == "")? 0 : (int)c.get("Position_ID"));
					ep.setPosition_Name(c.get("Position").toString());
					ep.setPosition_NameKh(c.get("PositionKhmer").toString());
					ep.setPosition_Level((c.get("Position_Level").toString() == "")? 0 : (int)c.get("Position_Level"));
					ep.setPosition_Description(c.get("Position_Description").toString());
					EP.add(ep);
				}
			}
			ES.position = EP;
			
			Data = MainData.get(5);
			List<Status> ESt = new ArrayList<Status>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Status es = new Status();
					es.setStatus_Name(c.get("Status_Name").toString());
					ESt.add(es);
				}
			}
			ES.status = ESt;
			
			Data = MainData.get(6);
			List<Type> ET = new ArrayList<Type>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Type et = new Type();
					et.setType_Name(c.get("Type_Name").toString());
					ET.add(et);
				}
			}
			ES.type = ET;
			
			Data = MainData.get(7);
			List<Department> ED = new ArrayList<Department>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Department ed = new Department();
					ed.setDepartment_ID(c.get("Department_ID").toString());
					ed.setDepartment_Name(c.get("Department_Name").toString());
					ed.setDepartment_Description(c.get("Department_Description").toString());
					ED.add(ed);
				}
				
			}
			ES.department = ED;
			
			Data = MainData.get(8);
			List<MembershipType> EMT = new ArrayList<MembershipType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					MembershipType emt = new MembershipType();
					emt.setMembershipType_Name(c.get("MembershipType_Name").toString());
					EMT.add(emt);
				}
			}
			ES.membershipType = EMT;
			
			Data = MainData.get(9);
			List<Language> EL = new ArrayList<Language>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Language el = new Language();
					el.setLanguage_Name(c.get("Language_Name").toString());
					EL.add(el);
				}
			}
			ES.language = EL;
			
			Data = MainData.get(10);
			List<Level> ELevel = new ArrayList<Level>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Level el = new Level();
					el.setLevel_Name(c.get("Level_Name").toString());
					ELevel.add(el);
				}
			}
			ES.level = ELevel;
			
			Data = MainData.get(11);
			List<InsuranceType> IT = new ArrayList<InsuranceType>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					InsuranceType it = new InsuranceType();
					it.setInsuranceType_Name(c.get("InsuranceType_Name").toString());
					IT.add(it);
				}
			}
			ES.insuranceType = IT;
			
			Data = MainData.get(12);
			List<SocialCommunication> SC = new ArrayList<SocialCommunication>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					SocialCommunication sc = new SocialCommunication();
					sc.setSocialCommunication_Name(c.get("SocialCommunication_Name").toString());
					SC.add(sc);
				}
			}
			ES.socialCommunication = SC;
			
			
			Data = MainData.get(13);
			List<Nationality> N = new ArrayList<Nationality>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationality n = new Nationality();
					n.setNationality_Name(c.get("Nationnality_Name").toString());
					N.add(n);
				}
			}
			ES.nationality = N;
			
			Data = MainData.get(14);
			List<Nationals> nationals = new ArrayList<Nationals>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Nationals r = new Nationals();
					r.setNationals_Name(c.get("Nationals_Name").toString());
					nationals.add(r);
				}
			}
			ES.nationals = nationals;
			
			Data = MainData.get(15);
			List<School> schools = new ArrayList<School>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					School s = new School();
					s.setSchool_Name(c.get("School_Name").toString());
					schools.add(s);
				}
			}
			ES.school = schools;
			
			Data = MainData.get(16);
			List<Supervisor> supervisors = new ArrayList<Supervisor>();
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
			}
			ES.supervisor = supervisors;
			
			Data = MainData.get(17);
			List<WorkShift> workShifts = new ArrayList<WorkShift>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					WorkShift workShift = new WorkShift();
					workShift.setShift_ID(c.get("Shift_ID").toString());
					workShift.setShift_Name(c.get("Shift_Name").toString());
					workShifts.add(workShift);
				}
			}
			ES.workShift = workShifts;
			
			Data = MainData.get(18);
			List<Insurance> IN = new ArrayList<Insurance>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Insurance in = new Insurance();
					in.setInsurance_ID((c.get("Insurance_ID").toString() == "")? 0 : (int)c.get("Insurance_ID"));
					in.setInsurance_Name(c.get("Insurance_Name").toString());
					in.setInsurance_Company(c.get("Insurance_Company").toString());
					in.setInsurance_Type(c.get("Insurance_Type").toString());
					in.setInsurance_Description(c.get("Insurance_Description").toString());
					IN.add(in);
				}
				
			}
			ES.insurance = IN;
			
			Data = MainData.get(19);
			List<Country> countries = new ArrayList<Country>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Country country = new Country();
					country.setCountryName(c.get("Country_Name").toString());
					countries.add(country);
				}
				
			}
			ES.country = countries;
			
			Data = MainData.get(20);
			if(Data.size()>0){	
				for(ConcurrentHashMap<String, Object> c : Data){
					Employee e = new Employee();
					e.setEmp_ID(c.get("EmpID").toString());
					e.setEmp_Name(c.get("EmpName").toString());
					e.setEmp_NameKh(c.get("EmpNameKh").toString());
					e.setEmp_Salutation(c.get("Emp_Salutation").toString());
					e.setEmp_Sex(c.get("EmpSex").toString());
					e.setEmp_MaritalStatus(c.get("Emp_MaritalStatus").toString());
					e.setEmp_DOB(tool.ConvertDate(c.get("EmpDOB").toString()));
					e.setEmp_ICNo(c.get("EmpICNo").toString());
					e.setEmp_NSSFID(c.get("Emp_NSSFID").toString());
					e.setEmp_PassportID(c.get("Emp_PassportID").toString());
					e.setEmp_VisaExpire(tool.ConvertDate(c.get("Emp_VisaExpire").toString()));
					e.setEmp_Tel1(c.get("Emp_Tel1").toString());
					e.setEmp_Tel2(c.get("Emp_Tel2").toString());
					e.setEmp_HomeTel(c.get("Emp_HomeTel").toString());
					e.setEmp_CompanyTel(c.get("Emp_CompanyTel").toString());
					e.setEmp_EmergencyPersonName(c.get("Emp_EmergencyPersonName").toString());
					e.setEmp_EmergencyRelationship(c.get("Emp_EmergencyRelationship").toString());
					e.setEmp_EmergencyTel(c.get("Emp_EmergencyTel").toString());
					e.setEmp_Email(c.get("EmpEmail").toString());
					e.setEmp_CompanyEmail(c.get("Emp_CompanyEmail").toString());
					e.setEmp_Website(c.get("EmpWebsite").toString());
					e.setEmp_Address(c.get("EmpAddress").toString());
					e.setEmp_AddressKh(c.get("EmpAddressKh").toString());
					e.setEmp_PositionID((c.get("Emp_PositionID").toString() == "")? 0 : (int)c.get("Emp_PositionID"));
					e.setEmp_Img(c.get("EmpImg").toString());
					e.setEmp_Status(c.get("EmpStatus").toString());
					e.setEmp_Date(tool.ConvertDate(c.get("EmpDate").toString()));
					e.setEmp_Supervisor(c.get("Supervisor").toString());
					e.setEmp_ContactDate(tool.ConvertDate(c.get("ContactDate").toString()));
					e.setEmp_Grade(c.get("Emp_Grade").toString());
					e.setEmp_Type(c.get("Emp_Type").toString());
					e.setEmp_Category(c.get("Emp_Category").toString());
					e.setEmp_DepartmentID(c.get("Emp_DepartmentID").toString());
					e.setEmp_BranchID(c.get("Emp_BranchID").toString());
					e.setEmp_Nationality(c.get("Emp_Nationality").toString());
					e.setEmp_Nationals(c.get("Emp_Nationals").toString());
					e.setEmp_BankID((c.get("Emp_BankID").toString() == "")? 0 : (int)c.get("Emp_BankID"));
					e.setEmp_AccountNo(c.get("Emp_AccountNo").toString());
					e.setEmp_ShiftType(c.get("Emp_ShiftType").toString());
					e.setEmp_ShiftID(c.get("Emp_ShiftID").toString());
					e.setEmp_AllowLogin((c.get("Emp_AllowLogin").equals((Object)"")) ? 0 : (int)c.get("Emp_AllowLogin"));
					e.setEmp_NotificationEmail((c.get("Emp_NotificationEmail").equals((Object)"")) ? 0 : (int)c.get("Emp_NotificationEmail"));
					e.setEmp_JoinDate(tool.ConvertDate(c.get("Emp_JoinDate").toString()));
					e.setEmp_HomeNo(c.get("Emp_HomeNo").toString());
					e.setEmp_Street(c.get("Emp_Street").toString());
					e.setEmp_Village(c.get("Emp_Village").toString());	
					e.setEmp_District(c.get("Emp_District").toString());	
					e.setEmp_Commune(c.get("Emp_Commune").toString());	
					e.setEmp_City(c.get("Emp_City").toString());
					e.setEmp_State(c.get("Emp_State").toString());
					e.setEmp_Country(c.get("Emp_Country").toString());
					e.setEmp_PermanentAddress(c.get("Emp_PermanentAddress").toString());	
					e.setEmp_PermanentHomeNo(c.get("Emp_PermanentHomeNo").toString());	
					e.setEmp_PermanentStreet(c.get("Emp_PermanentStreet").toString());	
					e.setEmp_PermanentVillage(c.get("Emp_PermanentVillage").toString());	
					e.setEmp_PermanentDistrict(c.get("Emp_PermanentDistrict").toString());	
					e.setEmp_PermanentCommune(c.get("Emp_PermanentCommune").toString());	
					e.setEmp_PermanentCity(c.get("Emp_PermanentCity").toString());
					e.setEmp_PermanentState(c.get("Emp_PermanentState").toString());
					e.setEmp_PermanentCountry(c.get("Emp_PermanentCountry").toString());
					e.setEmp_Description(c.get("Emp_Description").toString());
					
					List<EmployeeSocialCommunication> TempES = new ArrayList<EmployeeSocialCommunication>();
					Data = MainData.get(21);
					if(Data.size()>0){	
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeSocialCommunication es = new EmployeeSocialCommunication();
							es.setEmp_ID(d.get("Emp_ID").toString());
							es.setSc_Name(d.get("SocialCommunication").toString());
							es.setSc_Value(d.get("SocialCommunication_Value").toString());
							TempES.add(es);
						}
					}
					e.emp_socialcommuncation = TempES;
					
					List<EmployeeSkill> TempSK = new ArrayList<EmployeeSkill>();
					Data = MainData.get(22);
					if(Data.size()>0){	
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeSkill sk = new EmployeeSkill();
							sk.setEmp_ID(d.get("Emp_ID").toString());
							sk.setSkill_Name(d.get("Skill_Name").toString());
							sk.setSkill_Level(d.get("Skill_Level").toString());
							sk.setSkill_Description(d.get("Skill_Description").toString());
							TempSK.add(sk);
						}
					}
					e.emp_skill = TempSK;
					
					List<EmployeeLanguage> TempL = new ArrayList<EmployeeLanguage>();
					Data = MainData.get(23);
					if(Data.size()>0){	
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeLanguage l = new EmployeeLanguage();
							l.setEmp_ID(d.get("Emp_ID").toString());
							l.setLanguage(d.get("Language").toString());
							l.setLanguage_ReadLevel(d.get("Language_ReadLevel").toString());
							l.setLanguage_WriteLevel(d.get("Language_WriteLevel").toString());
							l.setLanguage_SpeakLevel(d.get("Language_SpeakLevel").toString());
							l.setLanguage_UnderstandLevel(d.get("Language_UnderstandLevel").toString());
							l.setLanguage_Type(d.get("Language_Type").toString());
							TempL.add(l);
						}				
					}
					e.emp_language = TempL;
					
					List<EmployeeEducation> Temped = new ArrayList<EmployeeEducation>();
					Data = MainData.get(24);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeEducation ed = new EmployeeEducation();
							ed.setEmp_ID(d.get("Emp_ID").toString());
							ed.setEdu_Name(d.get("Edu_Name").toString());
							ed.setEdu_StartDate(tool.ConvertDate(d.get("Edu_StartDate").toString()));
							ed.setEdu_EndDate(tool.ConvertDate(d.get("Edu_EndDate").toString()));
							ed.setEdu_Degree(d.get("Edu_Degree").toString());
							ed.setEdu_School(d.get("Edu_School").toString());
							ed.setEdu_Major(d.get("Edu_Major").toString());
							ed.setEdu_Description(d.get("Edu_Description").toString());
							ed.setEdu_AttachFile(d.get("Edu_Attachfile").toString());
							Temped.add(ed);
						}					
					}
					e.emp_education = Temped;
					
					List<EmployeeExperience> Tempex = new ArrayList<EmployeeExperience>();
					Data = MainData.get(25);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeExperience ex = new EmployeeExperience();
							ex.setEmp_ID(d.get("Emp_ID").toString());
							ex.setEx_Position(d.get("Ex_Position").toString());
							ex.setEx_Company(d.get("Ex_Company").toString());
							ex.setEx_StartDate(tool.ConvertDate(d.get("Ex_StartDate").toString()));
							ex.setEx_EndDate(tool.ConvertDate(d.get("Ex_EndDate").toString()));
							ex.setEx_Description(d.get("Ex_Description").toString());
							Tempex.add(ex);
						}
					}
					e.emp_experience = Tempex;
					
					List<EmployeeFamily> Tempfa = new ArrayList<EmployeeFamily>();
					Data = MainData.get(26);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeFamily fa = new EmployeeFamily();
							fa.setEmp_ID(d.get("Emp_ID").toString());
							fa.setFam_Name(d.get("Fam_Name").toString());
							fa.setFam_DOB(tool.ConvertDate(d.get("Fam_DOB").toString()));
							fa.setFam_NameKh(d.get("Fam_NameKh").toString());
							fa.setFam_Relative(d.get("Fam_Relative").toString());
							fa.setFam_Occupation(d.get("Fam_Occupation").toString());
							fa.setFam_Tel(d.get("Fam_Tel").toString());
							fa.setFam_TaxDeduct((d.get("Fam_TaxDeduct").toString() == "") ? 0 : (int)d.get("Fam_TaxDeduct"));
							Tempfa.add(fa);
						}
					}
					e.emp_family = Tempfa;
					
					List<EmployeeContract> TempCon = new ArrayList<EmployeeContract>();
					Data = MainData.get(27);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeContract con = new EmployeeContract();
							con.setEmp_ID(d.get("Emp_ID").toString());
							con.setCon_Name(d.get("Con_Name").toString());
							con.setCon_Type(d.get("Con_Type").toString());
							con.setCon_StartDate(tool.ConvertDate(d.get("Con_StartDate").toString()));
							con.setCon_EndDate(tool.ConvertDate(d.get("Con_EndDate").toString()));
							con.setCon_Description(d.get("Con_Description").toString());
							con.setCon_EmpPositionID((d.get("Con_EmpPositionID").toString() == "") ? 0 : (int)d.get("Con_EmpPositionID"));
							con.setCon_EmpType(d.get("Con_EmpType").toString());
							con.setCon_EmpCategory(d.get("Con_EmpCategory").toString());
							con.setCon_EmpGrade(d.get("Con_EmpGrade").toString());
							con.setCon_EmpBranchID((d.get("Con_EmpBranchID").toString() == "")? 0 :(int)d.get("Con_EmpBranchID"));
							con.setCon_EmpDepartmentID((d.get("Con_EmpDepartmentID").toString() == "")? 0 : (int)d.get("Con_EmpDepartmentID"));
							con.setCon_AttachFile(d.get("Con_AttachFile").toString());
							TempCon.add(con);
						}
					}
					e.emp_contact = TempCon;
					
					List<EmployeeTraining> TempTrain = new ArrayList<EmployeeTraining>();
					Data = MainData.get(28);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeTraining train = new EmployeeTraining();
							train.setEmp_ID(d.get("Emp_ID").toString());
							train.setTrain_InstituteName(d.get("Train_InstituteName").toString());
							train.setTrain_Certificate(d.get("Train_Certificate").toString());
							train.setTrain_Course(d.get("Train_Course").toString());
							train.setTrain_StartDate(tool.ConvertDate(d.get("Train_StartDate").toString()));
							train.setTrain_EndDate(tool.ConvertDate(d.get("Train_EndDate").toString()));
							train.setTrain_Description(d.get("Train_Description").toString());
							train.setTrain_AttachFile(d.get("Train_AttachFile").toString());
							TempTrain.add(train);
						}
					}
					e.emp_training = TempTrain;
					
					ArrayList<EmployeeAttachment> TempAttach = new ArrayList<EmployeeAttachment>();
					Data = MainData.get(29);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeAttachment attach = new EmployeeAttachment();
							attach.setEmp_ID(d.get("Emp_ID").toString());
							attach.setAtt_FileName(d.get("Att_FileName").toString());
							attach.setAtt_FilePath(d.get("Att_FilePath").toString());
							TempAttach.add(attach);
						}
					}
					e.emp_attachment  = TempAttach;
					
					List<EmployeeMemberShip> TempMembership = new ArrayList<EmployeeMemberShip>();
					Data = MainData.get(30);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeMemberShip mem = new EmployeeMemberShip();
							mem.setEmp_ID(d.get("Emp_ID").toString());
							mem.setMem_Name(d.get("Mem_Name").toString());
							mem.setMem_Institute(d.get("Mem_Institute").toString());
							mem.setMem_GrantedOn(tool.ConvertDate(d.get("Mem_GrantedOn").toString()));
							mem.setMem_ValidThru(tool.ConvertDate(d.get("Mem_ValidThru").toString()));
							mem.setMem_Type(d.get("Mem_Type").toString());
							mem.setMem_Description(d.get("Mem_Description").toString());
							mem.setMem_Attachfile(d.get("Mem_Attachfile").toString());
							TempMembership.add(mem);
						}
					}
					e.emp_membership = TempMembership;
					
					List<EmployeeInsurance> TempInsurance = new ArrayList<EmployeeInsurance>();
					Data = MainData.get(31);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeInsurance ins = new EmployeeInsurance();
							ins.setEmp_ID(d.get("Emp_ID").toString());
							ins.setIns_InsuranceID((d.get("Ins_InsuranceID").toString() == "")? 0 : (int)d.get("Ins_InsuranceID"));
							ins.setIns_StartDate(tool.ConvertDate(d.get("Ins_StartDate").toString()));
							ins.setIns_ExpireDate(tool.ConvertDate(d.get("Ins_ExpireDate").toString()));
							ins.setIns_Description(d.get("Ins_Description").toString());
							ins.setIns_SumInsured((d.get("Ins_SumInsured").toString() == "")? 0 : (double)d.get("Ins_SumInsured"));
							ins.setIns_Premium((d.get("Ins_Premium").toString() == "")? 0 : (double)d.get("Ins_Premium"));
							TempInsurance.add(ins);
						}
					}
					e.emp_insurance = TempInsurance;
					
					Data = MainData.get(32);
					if(Data.size()>0){
						for(ConcurrentHashMap<String, Object> d : Data){
							EmployeeUser user = new EmployeeUser();
							user.setUser_Name(d.get("User_Name").toString());
							//user.setUser_Password(d.get("User_Password").toString());
							user.setUser_Password("");
							e.emp_user = user;
						}					
					}
				ES.employee = e;
				}
			}		
			return ES;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
