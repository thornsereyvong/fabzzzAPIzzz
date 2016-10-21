package com.balancika.hrms.app.entities.employee;

import java.sql.Date;
import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Employee {
	
	private String Emp_ID;
	private String Emp_Name;
	private String Emp_NameKh;
	private String Emp_Salutation;
	private String Emp_Sex;
	private String Emp_MaritalStatus;
	private Date Emp_DOB;
	private String Emp_ICNo;
	private String Emp_PassportID;
	private String Emp_NSSFID;
	private Date Emp_VisaExpire;
	private String Emp_Tel1;
	private String Emp_Tel2;
	private String Emp_HomeTel;
	private String Emp_CompanyTel;
	private String Emp_EmergencyPersonName;
	private String Emp_EmergencyRelationship;
	private String Emp_EmergencyTel;
	private String Emp_Email;
	private String Emp_CompanyEmail;
	private String Emp_Website;
	private String Emp_Address;
	private String Emp_AddressKh;
	private int Emp_PositionID;
	private String Emp_Img;
	private String Emp_Status;
	private Date Emp_Date;
	private String Emp_Supervisor;
	private Date Emp_ContactDate;
	private String Emp_Grade;
	private String Emp_Type;
	private String Emp_Category;
	private String Emp_DepartmentID;
	private String Emp_BranchID;
	private String Emp_AccountNo;
	private int Emp_BankID;
	private String Emp_Nationality;
	private String Emp_Nationals;
	private String Emp_ShiftType;
	private String Emp_ShiftID;
	private int Emp_AllowLogin;
	private int Emp_NotificationEmail;
	private Date Emp_JoinDate;
	private String Emp_HomeNo;
	private String Emp_Street;
	private String Emp_Village;
	private String Emp_District;
	private String Emp_Commune;
	private String Emp_City;
	private String Emp_State;
	private String Emp_Country;
	private String Emp_PermanentAddress;
	private String Emp_PermanentHomeNo;
	private String Emp_PermanentStreet;
	private String Emp_PermanentVillage;
	private String Emp_PermanentDistrict;
	private String Emp_PermanentCommune;
	private String Emp_PermanentCity;
	private String Emp_PermanentState;
	private String Emp_PermanentCountry;
	private String Emp_Description;

	public List<EmployeeSocialCommunication> emp_socialcommuncation;
	public List<EmployeeEducation> emp_education;
	public List<EmployeeSkill> emp_skill;
	public List<EmployeeLanguage> emp_language;
	public List<EmployeeExperience> emp_experience;
	public List<EmployeeFamily> emp_family;
	public List<EmployeeContract> emp_contact;
	public List<EmployeeTraining> emp_training;
	public List<EmployeeMemberShip> emp_membership;
	public List<EmployeeAttachment> emp_attachment;
	public List<EmployeeInsurance> emp_insurance;
	public EmployeeUser emp_user;
	public List<EmployeeFileDelete> emp_filedelete;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getEmp_ID() {
		return Emp_ID;
	}
	public void setEmp_ID(String emp_ID) {
		Emp_ID = emp_ID;
	}
	public String getEmp_Name() {
		return Emp_Name;
	}
	public void setEmp_Name(String emp_Name) {
		Emp_Name = emp_Name;
	}
	public String getEmp_NameKh() {
		return Emp_NameKh;
	}
	public void setEmp_NameKh(String emp_NameKh) {
		Emp_NameKh = emp_NameKh;
	}
	public String getEmp_Salutation() {
		return Emp_Salutation;
	}
	public void setEmp_Salutation(String emp_Salutation) {
		Emp_Salutation = emp_Salutation;
	}
	public String getEmp_Sex() {
		return Emp_Sex;
	}
	public void setEmp_Sex(String emp_Sex) {
		Emp_Sex = emp_Sex;
	}
	public String getEmp_MaritalStatus() {
		return Emp_MaritalStatus;
	}
	public void setEmp_MaritalStatus(String emp_MaritalStatus) {
		Emp_MaritalStatus = emp_MaritalStatus;
	}
	public Date getEmp_DOB() {
		return Emp_DOB;
	}
	public void setEmp_DOB(Date emp_DOB) {
		Emp_DOB = emp_DOB;
	}
	public String getEmp_ICNo() {
		return Emp_ICNo;
	}
	public void setEmp_ICNo(String emp_ICNo) {
		Emp_ICNo = emp_ICNo;
	}
	public String getEmp_PassportID() {
		return Emp_PassportID;
	}
	public void setEmp_PassportID(String emp_PassportID) {
		Emp_PassportID = emp_PassportID;
	}
	public String getEmp_NSSFID() {
		return Emp_NSSFID;
	}
	public void setEmp_NSSFID(String emp_NSSFID) {
		Emp_NSSFID = emp_NSSFID;
	}
	public Date getEmp_VisaExpire() {
		return Emp_VisaExpire;
	}
	public void setEmp_VisaExpire(Date emp_VisaExpire) {
		Emp_VisaExpire = emp_VisaExpire;
	}
	public String getEmp_Tel1() {
		return Emp_Tel1;
	}
	public void setEmp_Tel1(String emp_Tel1) {
		Emp_Tel1 = emp_Tel1;
	}
	public String getEmp_Tel2() {
		return Emp_Tel2;
	}
	public void setEmp_Tel2(String emp_Tel2) {
		Emp_Tel2 = emp_Tel2;
	}
	public String getEmp_HomeTel() {
		return Emp_HomeTel;
	}
	public void setEmp_HomeTel(String emp_HomeTel) {
		Emp_HomeTel = emp_HomeTel;
	}
	public String getEmp_CompanyTel() {
		return Emp_CompanyTel;
	}
	public void setEmp_CompanyTel(String emp_CompanyTel) {
		Emp_CompanyTel = emp_CompanyTel;
	}
	public String getEmp_EmergencyPersonName() {
		return Emp_EmergencyPersonName;
	}
	public void setEmp_EmergencyPersonName(String emp_EmergencyPersonName) {
		Emp_EmergencyPersonName = emp_EmergencyPersonName;
	}
	public String getEmp_EmergencyRelationship() {
		return Emp_EmergencyRelationship;
	}
	public void setEmp_EmergencyRelationship(String emp_EmergencyRelationship) {
		Emp_EmergencyRelationship = emp_EmergencyRelationship;
	}
	public String getEmp_EmergencyTel() {
		return Emp_EmergencyTel;
	}
	public void setEmp_EmergencyTel(String emp_EmergencyTel) {
		Emp_EmergencyTel = emp_EmergencyTel;
	}
	public String getEmp_Email() {
		return Emp_Email;
	}
	public void setEmp_Email(String emp_Email) {
		Emp_Email = emp_Email;
	}
	public String getEmp_Website() {
		return Emp_Website;
	}
	public void setEmp_Website(String emp_Website) {
		Emp_Website = emp_Website;
	}
	public String getEmp_Address() {
		return Emp_Address;
	}
	public void setEmp_Address(String emp_Address) {
		Emp_Address = emp_Address;
	}
	public int getEmp_PositionID() {
		return Emp_PositionID;
	}
	public void setEmp_PositionID(int emp_PositionID) {
		Emp_PositionID = emp_PositionID;
	}
	public String getEmp_Img() {
		return Emp_Img;
	}
	public void setEmp_Img(String emp_Img) {
		Emp_Img = emp_Img;
	}
	public String getEmp_Status() {
		return Emp_Status;
	}
	public void setEmp_Status(String emp_Status) {
		Emp_Status = emp_Status;
	}
	public Date getEmp_Date() {
		return Emp_Date;
	}
	public void setEmp_Date(Date emp_Date) {
		Emp_Date = emp_Date;
	}
	public String getEmp_Supervisor() {
		return Emp_Supervisor;
	}
	public void setEmp_Supervisor(String emp_Supervisor) {
		Emp_Supervisor = emp_Supervisor;
	}
	public Date getEmp_ContactDate() {
		return Emp_ContactDate;
	}
	public void setEmp_ContactDate(Date emp_ContactDate) {
		Emp_ContactDate = emp_ContactDate;
	}
	public String getEmp_Grade() {
		return Emp_Grade;
	}
	public void setEmp_Grade(String emp_Grade) {
		Emp_Grade = emp_Grade;
	}
	public String getEmp_Type() {
		return Emp_Type;
	}
	public void setEmp_Type(String emp_Type) {
		Emp_Type = emp_Type;
	}
	public String getEmp_Category() {
		return Emp_Category;
	}
	public void setEmp_Category(String emp_Category) {
		Emp_Category = emp_Category;
	}
	public String getEmp_DepartmentID() {
		return Emp_DepartmentID;
	}
	public void setEmp_DepartmentID(String emp_DepartmentID) {
		Emp_DepartmentID = emp_DepartmentID;
	}
	public String getEmp_BranchID() {
		return Emp_BranchID;
	}
	public void setEmp_BranchID(String emp_BranchID) {
		Emp_BranchID = emp_BranchID;
	}
	public String getEmp_AccountNo() {
		return Emp_AccountNo;
	}
	public void setEmp_AccountNo(String emp_AccountNo) {
		Emp_AccountNo = emp_AccountNo;
	}
	public int getEmp_BankID() {
		return Emp_BankID;
	}
	public void setEmp_BankID(int emp_BankID) {
		Emp_BankID = emp_BankID;
	}
	public String getEmp_Nationality() {
		return Emp_Nationality;
	}
	public void setEmp_Nationality(String emp_Nationality) {
		Emp_Nationality = emp_Nationality;
	}
	public String getEmp_Nationals() {
		return Emp_Nationals;
	}
	public void setEmp_Nationals(String emp_Nationals) {
		Emp_Nationals = emp_Nationals;
	}
	public String getEmp_ShiftType() {
		return Emp_ShiftType;
	}
	public void setEmp_ShiftType(String emp_ShiftType) {
		Emp_ShiftType = emp_ShiftType;
	}
	public String getEmp_ShiftID() {
		return Emp_ShiftID;
	}
	public void setEmp_ShiftID(String emp_ShiftID) {
		Emp_ShiftID = emp_ShiftID;
	}
	public int getEmp_AllowLogin() {
		return Emp_AllowLogin;
	}
	public void setEmp_AllowLogin(int emp_AllowLogin) {
		Emp_AllowLogin = emp_AllowLogin;
	}
	public int getEmp_NotificationEmail() {
		return Emp_NotificationEmail;
	}
	public void setEmp_NotificationEmail(int emp_NotificationEmail) {
		Emp_NotificationEmail = emp_NotificationEmail;
	}
	public Date getEmp_JoinDate() {
		return Emp_JoinDate;
	}
	public void setEmp_JoinDate(Date emp_JoinDate) {
		Emp_JoinDate = emp_JoinDate;
	}
	public String getEmp_HomeNo() {
		return Emp_HomeNo;
	}
	public void setEmp_HomeNo(String emp_HomeNo) {
		Emp_HomeNo = emp_HomeNo;
	}
	public String getEmp_Street() {
		return Emp_Street;
	}
	public void setEmp_Street(String emp_Street) {
		Emp_Street = emp_Street;
	}
	public String getEmp_Village() {
		return Emp_Village;
	}
	public void setEmp_Village(String emp_Village) {
		Emp_Village = emp_Village;
	}
	public String getEmp_District() {
		return Emp_District;
	}
	public void setEmp_District(String emp_District) {
		Emp_District = emp_District;
	}
	public String getEmp_Commune() {
		return Emp_Commune;
	}
	public void setEmp_Commune(String emp_Commune) {
		Emp_Commune = emp_Commune;
	}
	public String getEmp_City() {
		return Emp_City;
	}
	public void setEmp_City(String emp_City) {
		Emp_City = emp_City;
	}
	public String getEmp_State() {
		return Emp_State;
	}
	public void setEmp_State(String emp_State) {
		Emp_State = emp_State;
	}
	public String getEmp_Country() {
		return Emp_Country;
	}
	public void setEmp_Country(String emp_Country) {
		Emp_Country = emp_Country;
	}
	public String getEmp_PermanentAddress() {
		return Emp_PermanentAddress;
	}
	public void setEmp_PermanentAddress(String emp_PermanentAddress) {
		Emp_PermanentAddress = emp_PermanentAddress;
	}
	public String getEmp_PermanentHomeNo() {
		return Emp_PermanentHomeNo;
	}
	public void setEmp_PermanentHomeNo(String emp_PermanentHomeNo) {
		Emp_PermanentHomeNo = emp_PermanentHomeNo;
	}
	public String getEmp_PermanentStreet() {
		return Emp_PermanentStreet;
	}
	public void setEmp_PermanentStreet(String emp_PermanentStreet) {
		Emp_PermanentStreet = emp_PermanentStreet;
	}
	public String getEmp_PermanentVillage() {
		return Emp_PermanentVillage;
	}
	public void setEmp_PermanentVillage(String emp_PermanentVillage) {
		Emp_PermanentVillage = emp_PermanentVillage;
	}
	public String getEmp_PermanentDistrict() {
		return Emp_PermanentDistrict;
	}
	public void setEmp_PermanentDistrict(String emp_PermanentDistrict) {
		Emp_PermanentDistrict = emp_PermanentDistrict;
	}
	public String getEmp_PermanentCommune() {
		return Emp_PermanentCommune;
	}
	public void setEmp_PermanentCommune(String emp_PermanentCommune) {
		Emp_PermanentCommune = emp_PermanentCommune;
	}
	public String getEmp_PermanentCity() {
		return Emp_PermanentCity;
	}
	public void setEmp_PermanentCity(String emp_PermanentCity) {
		Emp_PermanentCity = emp_PermanentCity;
	}
	public String getEmp_PermanentState() {
		return Emp_PermanentState;
	}
	public void setEmp_PermanentState(String emp_PermanentState) {
		Emp_PermanentState = emp_PermanentState;
	}
	public String getEmp_PermanentCountry() {
		return Emp_PermanentCountry;
	}
	public void setEmp_PermanentCountry(String emp_PermanentCountry) {
		Emp_PermanentCountry = emp_PermanentCountry;
	}
	public String getEmp_Description() {
		return Emp_Description;
	}
	public void setEmp_Description(String emp_Description) {
		Emp_Description = emp_Description;
	}
	public String getEmp_AddressKh() {
		return Emp_AddressKh;
	}
	public void setEmp_AddressKh(String emp_AddressKh) {
		Emp_AddressKh = emp_AddressKh;
	}
	public String getEmp_CompanyEmail() {
		return Emp_CompanyEmail;
	}
	public void setEmp_CompanyEmail(String emp_CompanyEmail) {
		Emp_CompanyEmail = emp_CompanyEmail;
	}
	
	
	
	
}
