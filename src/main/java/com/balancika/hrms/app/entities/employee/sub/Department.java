package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Department {
	private String Department_ID;
	private String Department_Name;
	private String Department_Description;
	private String Department_Parent;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	public String getDepartment_ID() {
		return Department_ID;
	}
	public void setDepartment_ID(String department_ID) {
		Department_ID = department_ID;
	}
	public String getDepartment_Name() {
		return Department_Name;
	}
	public void setDepartment_Name(String department_Name) {
		Department_Name = department_Name;
	}
	public String getDepartment_Description() {
		return Department_Description;
	}
	public void setDepartment_Description(String department_Description) {
		Department_Description = department_Description;
	}
	public String getDepartment_Parent() {
		return Department_Parent;
	}
	public void setDepartment_Parent(String department_Parent) {
		Department_Parent = department_Parent;
	}

}
