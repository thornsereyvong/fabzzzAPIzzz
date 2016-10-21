package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Branch {
	
	private String Branch_ID;
	private String Branch_Name;
	private String Branch_Tel;
	private String Branch_Description;
	private String Branch_Address;
	private String Branch_HomeNo;
	private String Branch_Street;
	private String Branch_Village;
	private String Branch_District;
	private String Branch_Commune;
	private String Branch_City;
	private String Branch_State;
	private String Branch_Country;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getBranch_ID() {
		return Branch_ID;
	}
	public void setBranch_ID(String branch_ID) {
		Branch_ID = branch_ID;
	}
	public String getBranch_Name() {
		return Branch_Name;
	}
	public void setBranch_Name(String branch_Name) {
		Branch_Name = branch_Name;
	}
	public String getBranch_Tel() {
		return Branch_Tel;
	}
	public void setBranch_Tel(String branch_Tel) {
		Branch_Tel = branch_Tel;
	}
	public String getBranch_Description() {
		return Branch_Description;
	}
	public void setBranch_Description(String branch_Description) {
		Branch_Description = branch_Description;
	}
	public String getBranch_Address() {
		return Branch_Address;
	}
	public void setBranch_Address(String branch_Address) {
		Branch_Address = branch_Address;
	}
	public String getBranch_HomeNo() {
		return Branch_HomeNo;
	}
	public void setBranch_HomeNo(String branch_HomeNo) {
		Branch_HomeNo = branch_HomeNo;
	}
	public String getBranch_Street() {
		return Branch_Street;
	}
	public void setBranch_Street(String branch_Street) {
		Branch_Street = branch_Street;
	}
	public String getBranch_Village() {
		return Branch_Village;
	}
	public void setBranch_Village(String branch_Village) {
		Branch_Village = branch_Village;
	}
	public String getBranch_District() {
		return Branch_District;
	}
	public void setBranch_District(String branch_District) {
		Branch_District = branch_District;
	}
	public String getBranch_Commune() {
		return Branch_Commune;
	}
	public void setBranch_Commune(String branch_Commune) {
		Branch_Commune = branch_Commune;
	}
	public String getBranch_City() {
		return Branch_City;
	}
	public void setBranch_City(String branch_City) {
		Branch_City = branch_City;
	}
	public String getBranch_Country() {
		return Branch_Country;
	}
	public void setBranch_Country(String branch_Country) {
		Branch_Country = branch_Country;
	}
	public String getBranch_State() {
		return Branch_State;
	}
	public void setBranch_State(String branch_State) {
		Branch_State = branch_State;
	}
	
	
}
