package com.balancika.hrms.app.servicesimpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.Employee;
import com.balancika.hrms.app.entities.employee.EmployeeAttachment;
import com.balancika.hrms.app.entities.employee.EmployeeContract;
import com.balancika.hrms.app.entities.employee.EmployeeEducation;
import com.balancika.hrms.app.entities.employee.EmployeeExperience;
import com.balancika.hrms.app.entities.employee.EmployeeFamily;
import com.balancika.hrms.app.entities.employee.EmployeeFileDelete;
import com.balancika.hrms.app.entities.employee.EmployeeInsurance;
import com.balancika.hrms.app.entities.employee.EmployeeLanguage;
import com.balancika.hrms.app.entities.employee.EmployeeMemberShip;
import com.balancika.hrms.app.entities.employee.EmployeeSkill;
import com.balancika.hrms.app.entities.employee.EmployeeSocialCommunication;
import com.balancika.hrms.app.entities.employee.EmployeeTraining;
import com.balancika.hrms.app.entities.employee.EmployeeUser;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.EmployeeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("EmployeeServiceImplJDBC")
public class EmployeeServiceImpl implements EmployeeServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Employee e, HttpServletRequest servletRequest) {
		try {
			String employee = "";
				String Emp_Category = tool.CheckStringNull(e.getEmp_Category());
				String Emp_Nationality = tool.CheckStringNull(e.getEmp_Nationality());
				String Emp_Nationals = tool.CheckStringNull(e.getEmp_Nationals());
				String Emp_Status = tool.CheckStringNull(e.getEmp_Status());
				String Emp_Type = tool.CheckStringNull(e.getEmp_Type());
				String Emp_Country = tool.CheckStringNull(e.getEmp_Country());
				String Emp_PermanentCountry = tool.CheckStringNull(e.getEmp_PermanentCountry());
				String Emp_ContractType = "";
				String Emp_Language = "";
				String Emp_MembershipType = "";
				String Emp_School = "";
				String Emp_SocialCommunicaton = "";
				
						
				// employee += "'" + e.getEmp_ID() + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Name()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_NameKh()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Salutation()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Sex()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_MaritalStatus()) + "',";
				employee += "'" + tool.CheckDateNull(e.getEmp_DOB()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_ICNo()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_NSSFID()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PassportID()) + "',";
				employee += "'" + tool.CheckDateNull(e.getEmp_VisaExpire()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Tel1()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Tel2()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_HomeTel()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_CompanyTel()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_EmergencyPersonName()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_EmergencyRelationship()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_EmergencyTel()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Email()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_CompanyEmail()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Website()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Address()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_AddressKh()) + "',";
				employee += "'" + e.getEmp_PositionID() + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Img()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Status()) + "',";
				employee += "'" + tool.CheckDateNull(e.getEmp_Date()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Supervisor()) + "',";
				employee += "'" + tool.CheckDateNull(e.getEmp_ContactDate()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Grade()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Type()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Category()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_DepartmentID()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_BranchID()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Nationality()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Nationals()) + "',";
				employee += "'" + e.getEmp_BankID() + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_AccountNo()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_ShiftType()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_ShiftID()) + "',";
				employee += "'" + e.getEmp_AllowLogin() + "',";
				employee += "'" + e.getEmp_NotificationEmail() + "',";
				employee += "'" + tool.CheckDateNull(e.getEmp_JoinDate()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_HomeNo()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Street()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Village()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_District()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Commune()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_City()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_State()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Country()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentAddress()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentHomeNo()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentStreet()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentVillage()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentDistrict()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentCommune()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentCity()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentState()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_PermanentCountry()) + "',";
				employee += "'" + tool.CheckStringNull(e.getEmp_Description()) + "',";
				employee = employee.substring(0, employee.length() - 1);
				
				String SocialCommunication = "";
				if (e.emp_socialcommuncation != null) {
					for (EmployeeSocialCommunication es : e.emp_socialcommuncation) {
						if (es != null) {
							SocialCommunication += "(";
							SocialCommunication += "'TempEmp_ID',";
							SocialCommunication += "'" + es.getSc_Name() + "',";
							SocialCommunication += "'" + tool.CheckStringNull(es.getSc_Value()) + "'";
							SocialCommunication += "),";
							
							if(!tool.CheckStringNull(es.getSc_Name()).equals("")){
								Emp_SocialCommunicaton += tool.CheckStringNull(es.getSc_Name()) + ",";
							}
						}
					}
					if (SocialCommunication != "") {
						SocialCommunication = SocialCommunication.substring(0, SocialCommunication.length() - 1);
					}
				}
				
				String Skill = "";
				if (e.emp_skill != null) {
					for (EmployeeSkill sk : e.emp_skill) {
						if (sk != null) {
							Skill += "(";
							Skill += "'TempEmp_ID',";
							Skill += "'" + tool.CheckStringNull(sk.getSkill_Name()) + "',";
							Skill += "'" + tool.CheckStringNull(sk.getSkill_Level()) + "',";
							Skill += "'" + tool.CheckStringNull(sk.getSkill_Description()) + "'";
							Skill += "),";
						}
					}
					if (Skill != "") {
						Skill = Skill.substring(0, Skill.length() - 1);
					}
				}
				
				String Language = "";
				if (e.emp_language != null) {
					for (EmployeeLanguage l : e.emp_language) {
						if (l != null) {
							Language += "(";
							Language += "'TempEmp_ID',";
							Language += "'" + tool.CheckStringNull(l.getLanguage()) + "',";
							Language += "'" + tool.CheckStringNull(l.getLanguage_ReadLevel()) + "',";
							Language += "'" + tool.CheckStringNull(l.getLanguage_WriteLevel()) + "',";
							Language += "'" + tool.CheckStringNull(l.getLanguage_SpeakLevel()) + "',";
							Language += "'" + tool.CheckStringNull(l.getLanguage_UnderstandLevel()) + "',";
							Language += "'" + tool.CheckStringNull(l.getLanguage_Type()) + "'";
							Language += "),";
							
							if(!tool.CheckStringNull(l.getLanguage()).equals("")){
								Emp_Language += tool.CheckStringNull(l.getLanguage()) + ",";
							}
						}
					}
					if (Language != "") {
						Language = Language.substring(0, Language.length() - 1);
					}
				}
				
				// Education
				String Education = "";
				if (e.emp_education != null) {
					for (EmployeeEducation ed : e.emp_education) {
						if (ed != null) {
							Education += "(";
							Education += "'TempEmp_ID',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_Name()) + "',";
							Education += "'" + tool.CheckDateNull(ed.getEdu_StartDate()) + "',";
							Education += "'" + tool.CheckDateNull(ed.getEdu_EndDate()) + "',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_Degree()) + "',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_School()) + "',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_Major()) + "',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_Description()) + "',";
							Education += "'" + tool.CheckStringNull(ed.getEdu_AttachFile()) + "'";
							Education += "),";
							
							if(!tool.CheckStringNull(ed.getEdu_School()).equals("")){
								Emp_School += tool.CheckStringNull(ed.getEdu_School()) + ",";
							}
						}
					}
					if (Education != "") {
						Education = Education.substring(0, Education.length() - 1);
					}
				}
				
				// Experience
				String Experience = "";
				if (e.emp_experience != null) {
					for (EmployeeExperience ex : e.emp_experience) {
						if (ex != null) {
							Experience += "(";
							Experience += "'TempEmp_ID',";
							Experience += "'" + tool.CheckStringNull(ex.getEx_Position()) + "',";
							Experience += "'" + tool.CheckStringNull(ex.getEx_Company()) + "',";
							Experience += "'" + tool.CheckDateNull(ex.getEx_StartDate()) + "',";
							Experience += "'" + tool.CheckDateNull(ex.getEx_EndDate()) + "',";
							Experience += "'" + tool.CheckStringNull(ex.getEx_Description()) + "'";
							Experience += "),";
						}
					}
					if (Experience != "") {
						Experience = Experience.substring(0, Experience.length() - 1);
					}
				}

				// Family
				String Family = "";
				if (e.emp_family != null) {
					for (EmployeeFamily fa : e.emp_family) {
						if (fa != null) {
							Family += "(";
							Family += "'TempEmp_ID',";
							Family += "'" + tool.CheckStringNull(fa.getFam_Name()) + "',";
							Family += "'" + tool.CheckStringNull(fa.getFam_NameKh()) + "',";
							Family += "'" + tool.CheckDateNull(fa.getFam_DOB()) + "',";
							Family += "'" + tool.CheckStringNull(fa.getFam_Relative()) + "',";
							Family += "'" + tool.CheckStringNull(fa.getFam_Occupation()) + "',";
							Family += "'" + tool.CheckStringNull(fa.getFam_Tel()) + "',";
							Family += "'" + fa.getFam_TaxDeduct() + "'";
							Family += "),";
						}
					}
					if (Family != "") {
						Family = Family.substring(0, Family.length() - 1);
					}
				}

				// Contact
				String Contact = "";
				if (e.emp_contact != null) {
					for (EmployeeContract con : e.emp_contact) {
						if (con != null) {
							Contact += "(";
							Contact += "'TempEmp_ID',";
							Contact += "'" + tool.CheckStringNull(con.getCon_Name()) + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_Type()) + "',";
							Contact += "'" + tool.CheckDateNull(con.getCon_StartDate()) + "',";
							Contact += "'" + tool.CheckDateNull(con.getCon_EndDate()) + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_Description()) + "',";
							Contact += "'" + con.getCon_EmpPositionID() + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_EmpType()) + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_EmpCategory()) + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_EmpGrade()) + "',";
							Contact += "'" + con.getCon_EmpBranchID() + "',";
							Contact += "'" + con.getCon_EmpDepartmentID() + "',";
							Contact += "'" + tool.CheckStringNull(con.getCon_AttachFile()) + "'";
							Contact += "),";
							
							if(!tool.CheckStringNull(con.getCon_Type()).equals("")){
								Emp_ContractType += tool.CheckStringNull(con.getCon_Type()) + ",";
							}
							
						}
					}
					if (Contact != "") {
						Contact = Contact.substring(0, Contact.length() - 1);
					}
				}

				// Training
				String Train = "";
				if (e.emp_training != null) {
					for (EmployeeTraining tr : e.emp_training) {
						if (tr != null) {
							Train += "(";
							Train += "'TempEmp_ID',";
							Train += "'" + tool.CheckStringNull(tr.getTrain_InstituteName()) + "',";
							Train += "'" + tool.CheckStringNull(tr.getTrain_Certificate()) + "',";
							Train += "'" + tool.CheckStringNull(tr.getTrain_Course()) + "',";
							Train += "'" + tool.CheckDateNull(tr.getTrain_StartDate()) + "',";
							Train += "'" + tool.CheckDateNull(tr.getTrain_EndDate()) + "',";
							Train += "'" + tool.CheckStringNull(tr.getTrain_Description()) + "',";
							Train += "'" + tool.CheckStringNull(tr.getTrain_AttachFile()) + "'";
							Train += "),";
						}
					}
					if (Train != "") {
						Train = Train.substring(0, Train.length() - 1);
					}
				}

				// Attachment
				String Attachment = "";
				List<String> AttachmentPath = new ArrayList<String>();
				if (e.emp_attachment != null) {
					for (EmployeeAttachment att : e.emp_attachment) {
						if (att != null) {
							Attachment += "(";
							Attachment += "'TempEmp_ID',";
							Attachment += "'" + tool.CheckStringNull(att.getAtt_FileName()) + "',";
							Attachment += "'" + tool.CheckStringNull(att.getAtt_FilePath()) + "'";
							Attachment += "),";
							AttachmentPath.add( tool.CheckStringNull(att.getAtt_FilePath()));
						}
					}
					if (Attachment != "") {
						Attachment = Attachment.substring(0, Attachment.length() - 1);
					}
				}

				// Membership
				String Membership = "";
				if (e.emp_membership != null) {
					for (EmployeeMemberShip mem : e.emp_membership) {
						if (mem != null) {
							Membership += "(";
							Membership += "'TempEmp_ID',";
							Membership += "'" + tool.CheckStringNull(mem.getMem_Name()) + "',";
							Membership += "'" + tool.CheckStringNull(mem.getMem_Institute()) + "',";
							Membership += "'" + tool.CheckDateNull(mem.getMem_GrantedOn()) + "',";
							Membership += "'" + tool.CheckDateNull(mem.getMem_ValidThru()) + "',";
							Membership += "'" + tool.CheckStringNull(mem.getMem_Type()) + "',";
							Membership += "'" + tool.CheckStringNull(mem.getMem_Description()) + "',";
							Membership += "'" + tool.CheckStringNull(mem.getMem_Attachfile()) + "'";
							Membership += "),";
							
							if(!tool.CheckStringNull(mem.getMem_Type()).equals("")){
								Emp_MembershipType += tool.CheckStringNull(mem.getMem_Type()) + ",";
							}
						}
					}
					if (Membership != "") {
						Membership = Membership.substring(0, Membership.length() - 1);
					}
				}

				// Insurance
				String Insurance = "";
				if (e.emp_insurance != null) {
					for (EmployeeInsurance ins : e.emp_insurance) {
						if (ins != null) {
							Insurance += "(";
							Insurance += "'TempEmp_ID',";
							Insurance += "'" + ins.getIns_InsuranceID() + "',";
							Insurance += "'" + tool.CheckDateNull(ins.getIns_StartDate()) + "',";
							Insurance += "'" + tool.CheckDateNull(ins.getIns_ExpireDate()) + "',";
							Insurance += "'" + tool.CheckStringNull(ins.getIns_Description()) + "',";
							Insurance += "'" + ins.getIns_SumInsured() + "',";
							Insurance += "'" + ins.getIns_Premium() + "'";
							Insurance += "),";
							
						}
					}
					if (Insurance != "") {
						Insurance = Insurance.substring(0, Insurance.length() - 1);
					}
				}
				
				//User
				String User = "";
				if(e.emp_user != null){
					EmployeeUser u = e.emp_user;
					if(u != null){
						User += "(";
						User += "'" + tool.CheckStringNull(u.getUser_Name()) + "',";
						User += "'" + tool.CheckStringNull(u.getUser_Name()) + "',";
						User += "'" + tool.URLEncrypt(tool.CheckStringNull(u.getUser_Password())) + "',";
						User += "'" + "ESS" + "',";
						User += "'TempEmp_ID',";
						User += "'" + "Role-00002" + "'";
						User += "),";
					}
					if (User != "") {
						User = User.substring(0, User.length() - 1);
					}
				}
				if(!e.getEmp_Img().equals("")){
					if (e.meDataSource.getIp().equals("localhost")) {
						tool.MoveFile(e.meDataSource.getDb(), e.getEmp_Img(), servletRequest);
					} else {
						File f = tool.GetFile("Temp", e.getEmp_Img(), servletRequest);
						InputStream is = new FileInputStream(f);
						tool.SPExecute(e.meDataSource, "spHRMSaveFile", IOUtils.toByteArray(is), e.getEmp_Img());
					}
				}
				if(!Attachment.equals("") && AttachmentPath.size()>0){
					if(e.meDataSource.getIp().equals("localhost")){
						for(String fileName : AttachmentPath){
							tool.MoveFile(e.meDataSource.getDb(), fileName, servletRequest);
						}
					}
					else{
						for(String fileName : AttachmentPath){
							File f = tool.GetFile("Temp", fileName, servletRequest);
							InputStream is = new FileInputStream(f);
							tool.SPExecute(e.meDataSource, "spHRMSaveFile", IOUtils.toByteArray(is), fileName);
						}
						
					}
					
				}
				
				return tool.SPSelect(e.meDataSource, "spHRMAddEmployee", e.meDataSource.getUserid(), employee, SocialCommunication, Skill, Language, Education,Experience, Family, Contact, Train, Attachment, Membership, Insurance, User, Emp_Category, Emp_ContractType, Emp_Language, Emp_MembershipType, Emp_Nationality, Emp_Nationals, Emp_School, Emp_SocialCommunicaton, Emp_Status, Emp_Type, Emp_Country, Emp_PermanentCountry);
										
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean update(Employee e, HttpServletRequest servletRequest) {
		try {
			String EmpID = "";
			String employee = "";
				String Emp_Category = tool.CheckStringNull(e.getEmp_Category());
				String Emp_Nationality = tool.CheckStringNull(e.getEmp_Nationality());
				String Emp_Nationals = tool.CheckStringNull(e.getEmp_Nationals());
				String Emp_Status = tool.CheckStringNull(e.getEmp_Status());
				String Emp_Type = tool.CheckStringNull(e.getEmp_Type());
				String Emp_Country = tool.CheckStringNull(e.getEmp_Country());
				String Emp_PermanentCountry = tool.CheckStringNull(e.getEmp_PermanentCountry());
				String Emp_ContractType = "";
				String Emp_Language = "";
				String Emp_MembershipType = "";
				String Emp_School = "";
				String Emp_SocialCommunicaton = "";
				
				EmpID = tool.CheckStringNull(e.getEmp_ID());
				if(!EmpID.equals("") && !tool.CheckStringNull(e.getEmp_Name()).equals("")){
					employee += "EmpID='" + tool.CheckStringNull(e.getEmp_ID()) + "',";
					employee += "EmpName='" + tool.CheckStringNull(e.getEmp_Name()) + "',";
					employee += "EmpNameKh='" + tool.CheckStringNull(e.getEmp_NameKh()) + "',";
					employee += "Emp_Salutation='" + e.getEmp_Salutation() + "',";
					employee += "EmpSex='" + tool.CheckStringNull(e.getEmp_Sex()) + "',";
					employee += "Emp_MaritalStatus='" + tool.CheckStringNull(e.getEmp_MaritalStatus()) + "',";
					employee += "EmpDOB='" + tool.CheckDateNull(e.getEmp_DOB()) + "',";
					employee += "EmpICNo='" + tool.CheckStringNull(e.getEmp_ICNo()) + "',";
					employee += "Emp_NSSFID='" + tool.CheckStringNull(e.getEmp_NSSFID()) + "',";
					employee += "Emp_PassportID='" + tool.CheckStringNull(e.getEmp_PassportID()) + "',";
					employee += "Emp_VisaExpire='" + tool.CheckDateNull(e.getEmp_VisaExpire()) + "',";
					employee += "Emp_Tel1='" + tool.CheckStringNull(e.getEmp_Tel1()) + "',";
					employee += "Emp_Tel2='" + tool.CheckStringNull(e.getEmp_Tel2()) + "',";
					employee += "Emp_HomeTel='" + tool.CheckStringNull(e.getEmp_HomeTel()) + "',";
					employee += "Emp_CompanyTel='" + tool.CheckStringNull(e.getEmp_CompanyTel()) + "',";
					employee += "Emp_EmergencyPersonName='" + tool.CheckStringNull(e.getEmp_EmergencyPersonName()) + "',";
					employee += "Emp_EmergencyRelationship='" + tool.CheckStringNull(e.getEmp_EmergencyRelationship())
						+ "',";
					employee += "Emp_EmergencyTel='" + tool.CheckStringNull(e.getEmp_EmergencyTel()) + "',";
					employee += "EmpEmail='" + tool.CheckStringNull(e.getEmp_Email()) + "',";
					employee += "Emp_CompanyEmail='" + tool.CheckStringNull(e.getEmp_CompanyEmail()) + "',";
					employee += "EmpWebsite='" + tool.CheckStringNull(e.getEmp_Website()) + "',";
					employee += "EmpAddress='" + tool.CheckStringNull(e.getEmp_Address()) + "',";
					employee += "EmpAddressKh='" + tool.CheckStringNull(e.getEmp_AddressKh()) + "',";
					employee += "Emp_PositionID='" + e.getEmp_PositionID() + "',";
					employee += "EmpImg='" + tool.CheckStringNull(e.getEmp_Img()) + "',";
					employee += "EmpStatus='" + tool.CheckStringNull(e.getEmp_Status()) + "',";
					employee += "EmpDate='" + tool.CheckDateNull(e.getEmp_Date()) + "',";
					employee += "Supervisor='" + tool.CheckStringNull(e.getEmp_Supervisor()) + "',";
					employee += "ContactDate='" + tool.CheckDateNull(e.getEmp_ContactDate()) + "',";
					employee += "Emp_Grade='" + tool.CheckStringNull(e.getEmp_Grade()) + "',";
					employee += "Emp_Type='" + tool.CheckStringNull(e.getEmp_Type()) + "',";
					employee += "Emp_Category='" + tool.CheckStringNull(e.getEmp_Category()) + "',";
					employee += "Emp_DepartmentID='" + tool.CheckStringNull(e.getEmp_DepartmentID()) + "',";
					employee += "Emp_BranchID='" + tool.CheckStringNull(e.getEmp_BranchID()) + "',";
					employee += "Emp_Nationality='" + tool.CheckStringNull(e.getEmp_Nationality()) + "',";
					employee += "Emp_Nationals='" + tool.CheckStringNull(e.getEmp_Nationals()) + "',";
					employee += "Emp_BankID='" + e.getEmp_BankID() + "',";
					employee += "Emp_AccountNo='" + tool.CheckStringNull(e.getEmp_AccountNo()) + "',";
					employee += "Emp_ShiftType='" + tool.CheckStringNull(e.getEmp_ShiftType()) + "',";
					employee += "Emp_ShiftID='" + tool.CheckStringNull(e.getEmp_ShiftID()) + "',";
					employee += "Emp_AllowLogin='" + e.getEmp_AllowLogin() + "',";
					employee += "Emp_NotificationEmail='" + e.getEmp_NotificationEmail() + "',";
					employee += "Emp_JoinDate='" + tool.CheckDateNull(e.getEmp_JoinDate()) + "',";
					employee += "Emp_HomeNo='" + tool.CheckStringNull(e.getEmp_HomeNo()) + "',";
					employee += "Emp_Street='" + e.getEmp_Street() + "',";
					employee += "Emp_Village='" + e.getEmp_Village() + "',";
					employee += "Emp_District='" + e.getEmp_District() + "',";
					employee += "Emp_Commune='" + e.getEmp_Commune() + "',";
					employee += "Emp_City='" + e.getEmp_City() + "',";
					employee += "Emp_State='" + e.getEmp_State() + "',";
					employee += "Emp_Country='" + e.getEmp_Country() + "',";
					employee += "Emp_PermanentAddress='" + tool.CheckStringNull(e.getEmp_PermanentAddress()) + "',";
					employee += "Emp_PermanentHomeNo='" + tool.CheckStringNull(e.getEmp_PermanentHomeNo()) + "',";
					employee += "Emp_PermanentStreet='" + e.getEmp_PermanentStreet() + "',";
					employee += "Emp_PermanentVillage='" + e.getEmp_PermanentVillage() + "',";
					employee += "Emp_PermanentDistrict='" + e.getEmp_PermanentDistrict() + "',";
					employee += "Emp_PermanentCommune='" + e.getEmp_PermanentCommune() + "',";
					employee += "Emp_PermanentCity='" + e.getEmp_PermanentCity() + "',";
					employee += "Emp_PermanentState='" + e.getEmp_PermanentState() + "',";
					employee += "Emp_PermanentCountry='" + e.getEmp_PermanentCountry() + "',";
					employee += "Emp_Description='" + tool.CheckStringNull(e.getEmp_Description()) + "'";
				}
				
				// Social Communication
				String SocialCommunicationID  = "";
				String SocialCommunication = "";
				if (e.emp_socialcommuncation != null) {
					for (EmployeeSocialCommunication es : e.emp_socialcommuncation) {
						if (es != null) {
							SocialCommunicationID = tool.CheckStringNull(es.getEmp_ID());
							if(!SocialCommunicationID.equals("") && !tool.CheckStringNull(es.getSc_Name()).equals("")){
								SocialCommunication += "(";
								SocialCommunication += "'TempEmp_ID',";
								SocialCommunication += "'" + es.getSc_Name() + "',";
								SocialCommunication += "'" + tool.CheckStringNull(es.getSc_Value()) + "'";
								SocialCommunication += "),";
							
								if(!tool.CheckStringNull(es.getSc_Name()).equals("")){
									Emp_SocialCommunicaton += tool.CheckStringNull(es.getSc_Name()) + ",";
								}
							}
						}
					}
					if (SocialCommunication != "") {
						SocialCommunication = SocialCommunication.substring(0, SocialCommunication.length() - 1);
					}
				}
				
				// Skill
				String SkillID = "";
				String Skill = "";
				if (e.emp_skill != null) {
					for (EmployeeSkill sk : e.emp_skill) {
						if (sk != null) {
							SkillID = tool.CheckStringNull(sk.getEmp_ID());
							if(!SkillID.equals("") && !tool.CheckStringNull(sk.getSkill_Name()).equals("")){
								Skill += "(";
								Skill += "'TempEmp_ID',";
								Skill += "'" + tool.CheckStringNull(sk.getSkill_Name()) + "',";
								Skill += "'" + tool.CheckStringNull(sk.getSkill_Level()) + "',";
								Skill += "'" + tool.CheckStringNull(sk.getSkill_Description()) + "'";
								Skill += "),";
							}
						}
					}
				}

				if (Skill != "") {
					Skill = Skill.substring(0, Skill.length() - 1);
				}

				// Language
				String LanguageID = "";
				String Language = "";
				if (e.emp_language != null) {
					for (EmployeeLanguage l : e.emp_language) {
						if (l != null) {
							LanguageID = tool.CheckStringNull(l.getEmp_ID());
							if(!LanguageID.equals("") && !tool.CheckStringNull(l.getLanguage()).equals("")){
								Language += "(";
								Language += "'TempEmp_ID',";
								Language += "'" + tool.CheckStringNull(l.getLanguage()) + "',";
								Language += "'" + tool.CheckStringNull(l.getLanguage_ReadLevel()) + "',";
								Language += "'" + tool.CheckStringNull(l.getLanguage_WriteLevel()) + "',";
								Language += "'" + tool.CheckStringNull(l.getLanguage_SpeakLevel()) + "',";
								Language += "'" + tool.CheckStringNull(l.getLanguage_UnderstandLevel()) + "',";
								Language += "'" + tool.CheckStringNull(l.getLanguage_Type()) + "'";
								Language += "),";
							
								if(!tool.CheckStringNull(l.getLanguage()).equals("")){
									Emp_Language += tool.CheckStringNull(l.getLanguage()) + ",";
								}
							}
						}
					}
					if (Language != "") {
						Language = Language.substring(0, Language.length() - 1);
					}
				}

				// Education
				String EducationID = "";
				String Education = "";
				if (e.emp_education != null) {
					for (EmployeeEducation ed : e.emp_education) {
						if (ed != null) {
							EducationID = tool.CheckStringNull(ed.getEmp_ID());
							if(!EducationID.equals("") && (!tool.CheckStringNull(ed.getEdu_Name()).equals("") || !tool.CheckStringNull(ed.getEdu_School()).equals(""))){
								Education += "(";
								Education += "'TempEmp_ID',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_Name()) + "',";
								Education += "'" + tool.CheckDateNull(ed.getEdu_StartDate()) + "',";
								Education += "'" + tool.CheckDateNull(ed.getEdu_EndDate()) + "',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_Degree()) + "',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_School()) + "',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_Major()) + "',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_Description()) + "',";
								Education += "'" + tool.CheckStringNull(ed.getEdu_AttachFile()) + "'";
								Education += "),";
							
								if(!tool.CheckStringNull(ed.getEdu_School()).equals("")){
									Emp_School += tool.CheckStringNull(ed.getEdu_School()) + ",";
								}
							}
						}
					}
					if (Education != "") {
						Education = Education.substring(0, Education.length() - 1);
					}
				}

				// Experience
				String ExperienceID = "";
				String Experience = "";
				if (e.emp_experience != null) {
					for (EmployeeExperience ex : e.emp_experience) {
						if (ex != null) {
							ExperienceID = tool.CheckStringNull(ex.getEmp_ID());
							if(!ExperienceID.equals("") && !tool.CheckStringNull(ex.getEx_Position()).equals("")){
								Experience += "(";
								Experience += "'TempEmp_ID',";
								Experience += "'" + tool.CheckStringNull(ex.getEx_Position()) + "',";
								Experience += "'" + tool.CheckStringNull(ex.getEx_Company()) + "',";
								Experience += "'" + tool.CheckDateNull(ex.getEx_StartDate()) + "',";
								Experience += "'" + tool.CheckDateNull(ex.getEx_EndDate()) + "',";
								Experience += "'" + tool.CheckStringNull(ex.getEx_Description()) + "'";
								Experience += "),";
							}
						}
					}
					if (Experience != "") {
						Experience = Experience.substring(0, Experience.length() - 1);
					}
				}

				// Family
				String FamilyID = "";
				String Family = "";
				if (e.emp_family != null) {
					for (EmployeeFamily fa : e.emp_family) {
						if (fa != null) {
							FamilyID = tool.CheckStringNull(fa.getEmp_ID());
							if(!FamilyID.equals("") && (!tool.CheckStringNull(fa.getFam_Name()).equals("") || !tool.CheckStringNull(fa.getFam_NameKh()).equals(""))){
								Family += "(";
								Family += "'TempEmp_ID',";
								Family += "'" + tool.CheckStringNull(fa.getFam_Name()) + "',";
								Family += "'" + tool.CheckStringNull(fa.getFam_NameKh()) + "',";
								Family += "'" + tool.CheckDateNull(fa.getFam_DOB()) + "',";
								Family += "'" + tool.CheckStringNull(fa.getFam_Relative()) + "',";
								Family += "'" + tool.CheckStringNull(fa.getFam_Occupation()) + "',";
								Family += "'" + tool.CheckStringNull(fa.getFam_Tel()) + "',";
								Family += "'" + fa.getFam_TaxDeduct() + "'";
								Family += "),";
							}
						}
					}
					if (Family != "") {
						Family = Family.substring(0, Family.length() - 1);
					}
				}

				// Contact
				String ContractID = "";
				String Contract = "";
				if (e.emp_contact != null) {
					for (EmployeeContract con : e.emp_contact) {
						if (con != null) {
							ContractID = tool.CheckStringNull(con.getEmp_ID());
							if(!ContractID.equals("") && !tool.CheckStringNull(con.getCon_Name()).equals("")){
								Contract += "(";
								Contract += "'TempEmp_ID',";
								Contract += "'" + tool.CheckStringNull(con.getCon_Name()) + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_Type()) + "',";
								Contract += "'" + tool.CheckDateNull(con.getCon_StartDate()) + "',";
								Contract += "'" + tool.CheckDateNull(con.getCon_EndDate()) + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_Description()) + "',";
								Contract += "'" + con.getCon_EmpPositionID() + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_EmpType()) + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_EmpCategory()) + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_EmpGrade()) + "',";
								Contract += "'" + con.getCon_EmpBranchID() + "',";
								Contract += "'" + con.getCon_EmpDepartmentID() + "',";
								Contract += "'" + tool.CheckStringNull(con.getCon_AttachFile()) + "'";
								Contract += "),";

								if (!tool.CheckStringNull(con.getCon_Type()).equals("")) {
									Emp_ContractType += tool.CheckStringNull(con.getCon_Type()) + ",";
								}	
							}
						}
					}
					if (Contract != "") {
						Contract = Contract.substring(0, Contract.length() - 1);
					}
				}

				// Training
				String TrainID = "";
				String Train = "";
				if (e.emp_training != null) {
					for (EmployeeTraining tr : e.emp_training) {
						if (tr != null) {
							TrainID = tool.CheckStringNull(tr.getEmp_ID());
							if(!TrainID.equals("") && !tool.CheckStringNull(tr.getTrain_InstituteName()).equals("")){
								Train += "(";
								Train += "'TempEmp_ID',";
								Train += "'" + tool.CheckStringNull(tr.getTrain_InstituteName()) + "',";
								Train += "'" + tool.CheckStringNull(tr.getTrain_Certificate()) + "',";
								Train += "'" + tool.CheckStringNull(tr.getTrain_Course()) + "',";
								Train += "'" + tool.CheckDateNull(tr.getTrain_StartDate()) + "',";
								Train += "'" + tool.CheckDateNull(tr.getTrain_EndDate()) + "',";
								Train += "'" + tool.CheckStringNull(tr.getTrain_Description()) + "',";
								Train += "'" + tool.CheckStringNull(tr.getTrain_AttachFile()) + "'";
								Train += "),";
							}
						}
					}
					if (Train != "") {
						Train = Train.substring(0, Train.length() - 1);
					}
				}

				// Attachment
				String AttachmentID = "";
				String Attachment = "";
				List<String> AttachmentPath = new ArrayList<String>();
				if (e.emp_attachment != null) {
					for (EmployeeAttachment att : e.emp_attachment) {
						if (att != null) {
							AttachmentID = tool.CheckStringNull(att.getEmp_ID());
							if(!AttachmentID.equals("") && !tool.CheckStringNull(att.getAtt_FileName()).equals("")){
								Attachment += "(";
								Attachment += "'TempEmp_ID',";
								Attachment += "'" + tool.CheckStringNull(att.getAtt_FileName()) + "',";
								Attachment += "'" + tool.CheckStringNull(att.getAtt_FilePath()) + "'";
								Attachment += "),";
								AttachmentPath.add(tool.CheckStringNull(att.getAtt_FilePath()));
							}
						}
					}
					if (Attachment != "") {
						Attachment = Attachment.substring(0, Attachment.length() - 1);
					}
				}

				// Membership
				String MembershipID = "";
				String Membership = "";
				if (e.emp_membership != null) {
					for (EmployeeMemberShip mem : e.emp_membership) {
						if (mem != null) {
							MembershipID = tool.CheckStringNull(mem.getEmp_ID());
							if(!MembershipID.equals("") && !tool.CheckStringNull(mem.getMem_Name()).equals("")){
								Membership += "(";
								Membership += "'TempEmp_ID',";
								Membership += "'" + tool.CheckStringNull(mem.getMem_Name()) + "',";
								Membership += "'" + tool.CheckStringNull(mem.getMem_Institute()) + "',";
								Membership += "'" + tool.CheckDateNull(mem.getMem_GrantedOn()) + "',";
								Membership += "'" + tool.CheckDateNull(mem.getMem_ValidThru()) + "',";
								Membership += "'" + tool.CheckStringNull(mem.getMem_Type()) + "',";
								Membership += "'" + tool.CheckStringNull(mem.getMem_Description()) + "',";
								Membership += "'" + tool.CheckStringNull(mem.getMem_Attachfile()) + "'";
								Membership += "),";
							
								if(!tool.CheckStringNull(mem.getMem_Type()).equals("")){
									Emp_MembershipType += tool.CheckStringNull(mem.getMem_Type()) + ",";
								}
							}
						}
					}
					if (Membership != "") {
						Membership = Membership.substring(0, Membership.length() - 1);
					}
				}

				// Insurance
				String InsuranceID = "";
				String Insurance = "";
				if (e.emp_insurance != null) {
					for (EmployeeInsurance ins : e.emp_insurance) {
						if (ins != null) {
							InsuranceID = tool.CheckStringNull(ins.getEmp_ID());
							if(!InsuranceID.equals("") && ins.getIns_InsuranceID() != 0){
								Insurance += "(";
								Insurance += "'TempEmp_ID',";
								Insurance += "'" + ins.getIns_InsuranceID() + "',";
								Insurance += "'" + tool.CheckDateNull(ins.getIns_StartDate()) + "',";
								Insurance += "'" + tool.CheckDateNull(ins.getIns_ExpireDate()) + "',";
								Insurance += "'" + tool.CheckStringNull(ins.getIns_Description()) + "',";
								Insurance += "'" + ins.getIns_SumInsured() + "',";
								Insurance += "'" + ins.getIns_Premium() + "'";
								Insurance += "),";
							}
						}
					}
					if (Insurance != "") {
						Insurance = Insurance.substring(0, Insurance.length() - 1);
					}
				}
				
				//User
				String User = "";
				if(e.emp_user != null){
					EmployeeUser u = e.emp_user;
					if(u != null){
						if(!EmpID.equals("")){
							if(tool.CheckStringNull(u.getUser_Password()).toLowerCase().equals("password")){
								User += "User_ID='" + tool.CheckStringNull(u.getUser_Name()) + "',";
								User += "User_Name='" + tool.CheckStringNull(u.getUser_Name()) + "'";
							}
							else{
								User += "User_ID='" + tool.CheckStringNull(u.getUser_Name()) + "',";
								User += "User_Name='" + tool.CheckStringNull(u.getUser_Name()) + "',";
								User += "User_Password='" + tool.URLEncrypt(tool.CheckStringNull(u.getUser_Password())) + "'";
							}	
						}
					}
				}
				if(e.emp_filedelete != null){
					if(e.meDataSource.getIp().equals("localhost")|| e.meDataSource.getIp().equals("192.168.0.2") ){
						for(EmployeeFileDelete fileName : e.emp_filedelete){
							tool.DeleteFile(e.meDataSource.getDb(), fileName.getFileName(), servletRequest);
						}
					}
					else{
						String Temp="";
						for(EmployeeFileDelete fileName : e.emp_filedelete){
							Temp += fileName + "/";
						}
						tool.SPExecute(e.meDataSource, "spHRMDeleteFiles", Temp);
					}
				}
				if(!e.getEmp_Img().equals("")){
					if (e.meDataSource.getIp().equals("localhost")) {
						tool.MoveFile(e.meDataSource.getDb(), e.getEmp_Img(), servletRequest);
					} else {
						File f = tool.GetFile("Temp", e.getEmp_Img(), servletRequest);
						InputStream is = new FileInputStream(f);
						tool.SPExecute(e.meDataSource, "spHRMSaveFile", IOUtils.toByteArray(is), e.getEmp_Img());
					}
				}
				if(!Attachment.equals("") && AttachmentPath.size()>0){
					if(e.meDataSource.getIp().equals("localhost") || e.meDataSource.getIp().equals("192.168.0.2") ){
						for(String fileName : AttachmentPath){
							tool.MoveFile(e.meDataSource.getDb(), fileName, servletRequest);
						}
					}
					else{
						for(String fileName : AttachmentPath){
							File f = tool.GetFile("Temp", fileName, servletRequest);
							if(f.exists()){
								InputStream is = new FileInputStream(f);
								tool.SPExecute(e.meDataSource, "spHRMSaveFile", IOUtils.toByteArray(is), fileName);
							}
						}	
					}
				}
				if(EmpID.equals("")){
					return tool.SPExecute(e.meDataSource, "spHRMUpdateEmployee",e.meDataSource.getUserid(), EmpID, employee, SocialCommunicationID, SocialCommunication, SkillID, Skill, LanguageID, Language, EducationID, Education, ExperienceID, Experience, FamilyID, Family, ContractID, Contract, TrainID, Train, AttachmentID, Attachment, MembershipID, Membership, InsuranceID, Insurance, User, Emp_Category, Emp_ContractType, Emp_Language, Emp_MembershipType, Emp_Nationality, Emp_Nationals, Emp_School, Emp_SocialCommunicaton, Emp_Status, Emp_Type, Emp_Country, Emp_PermanentCountry);
				}else{
					ArrayList<List<ConcurrentHashMap<String, Object>>> Data = tool.SPSelect(e.meDataSource, "spHRMUpdateEmployee",e.meDataSource.getUserid(), EmpID, employee, SocialCommunicationID, SocialCommunication, SkillID, Skill, LanguageID, Language, EducationID, Education, ExperienceID, Experience, FamilyID, Family, ContractID, Contract, TrainID, Train, AttachmentID, Attachment, MembershipID, Membership, InsuranceID, Insurance, User, Emp_Category, Emp_ContractType, Emp_Language, Emp_MembershipType, Emp_Nationality, Emp_Nationals, Emp_School, Emp_SocialCommunicaton, Emp_Status, Emp_Type, Emp_Country, Emp_PermanentCountry);
					if (e.meDataSource.getIp().equals("localhost") || e.meDataSource.getIp().equals("192.168.0.2")) {
						for (ConcurrentHashMap<String, Object> delete : Data.get(0)) {
							if(!e.getEmp_Img().equals( delete.get("EmpImg").toString())){
								tool.DeleteFile(e.meDataSource.getDb(), delete.get("EmpImg").toString(), servletRequest);
							}
						}
					} else {
					String Temp = "";
					for (ConcurrentHashMap<String, Object> delete : Data.get(0)) {
						Temp += delete.get("EmpImg").toString() + "/";
						if (!e.getEmp_Img().equals(delete.get("EmpImg").toString())) {
							tool.SPExecute(e.meDataSource, "spHRMDeleteFiles", Temp);
						}
					}
						
					}
				}
				
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource,String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployee", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Employee get(MeDataSource meDataSource, String ID) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeEmpID", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
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
				Data = MainData.get(1);
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
				Data = MainData.get(2);
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
				Data = MainData.get(3);
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
				Data = MainData.get(4);
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
				Data = MainData.get(5);
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
				Data = MainData.get(6);
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
				Data = MainData.get(7);
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
				Data = MainData.get(8);
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
				Data = MainData.get(9);
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
				Data = MainData.get(10);
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
				Data = MainData.get(11);
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
				
				Data = MainData.get(12);
				if(Data.size()>0){
					for(ConcurrentHashMap<String, Object> d : Data){
						EmployeeUser user = new EmployeeUser();
						user.setUser_Name(d.get("User_Name").toString());
						//user.setUser_Password(d.get("User_Password").toString());
						user.setUser_Password("");
						e.emp_user = user;
					}					
				}
				
				
				return e;
			}
		}
		return null;
	}

	@Override
	public Employee getOffset(MeDataSource meDataSource, long offset) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetEmployeeOffset", Long.toString(offset));
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
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
				Data = MainData.get(1);
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
				Data = MainData.get(2);
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
				Data = MainData.get(3);
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
				Data = MainData.get(4);
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
				Data = MainData.get(5);
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
				Data = MainData.get(6);
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
				Data = MainData.get(7);
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
				Data = MainData.get(8);
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
				
				List<EmployeeAttachment> TempAttach = new ArrayList<EmployeeAttachment>();
				Data = MainData.get(9);
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
				Data = MainData.get(10);
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
				Data = MainData.get(11);
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
				
				Data = MainData.get(13);
				if(Data.size()>0){
					for(ConcurrentHashMap<String, Object> d : Data){
						EmployeeUser user = new EmployeeUser();
						user.setUser_Name(d.get("User_Name").toString());
						//user.setUser_Password(d.get("User_Password").toString());
						user.setUser_Password("");
						e.emp_user = user;
					}					
				}
				
				
				return e;
			}
		}
		return null;
	}

	@Override
	public List<Employee> search(MeDataSource meDataSource, String ColumnName, String Value) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployee", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		ArrayList<Employee> Emp = new ArrayList<Employee>();
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
				e.setEmp_PermanentCity(c.get("Emp_PermanentState").toString());
				e.setEmp_PermanentCountry(c.get("Emp_PermanentCountry").toString());
				e.setEmp_Description(c.get("Emp_Description").toString());
				Emp.add(e);
			}
			return Emp;				
		}
		return null;
	}

	@Override
	public List<Supervisor> list(MeDataSource meDataSource) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMListEmployee");
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Supervisor> Emp = new ArrayList<Supervisor>();
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
				supervisor.setEmp_DepartmentID(c.get("Emp_DepartmentID").toString());
				supervisor.setEmp_DepartmentName(c.get("Department_Name").toString());
				supervisor.setEmp_BranchID(c.get("Emp_BranchID").toString());
				supervisor.setEmp_BranchName(c.get("Branch_Name").toString());
				supervisor.setEmp_Supervisor(c.get("Supervisor").toString());
				supervisor.setEmp_Status(c.get("EmpStatus").toString());
				supervisor.setEmp_Tel(c.get("Emp_Tel1").toString());
				supervisor.setEmp_CompanyTel(c.get("Emp_CompanyTel").toString());
				Emp.add(supervisor);
			}
		}
		return Emp;
	}

}
