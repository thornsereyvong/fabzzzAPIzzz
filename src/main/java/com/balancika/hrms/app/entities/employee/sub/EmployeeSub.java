package com.balancika.hrms.app.entities.employee.sub;

import java.util.List;

import com.balancika.hrms.app.entities.employee.Employee;
import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class EmployeeSub {
	public List<Bank> bank;
	public List<Branch> branch;
	public List<Category> category;
	public List<ContractType> contractType;
	public List<Position> position;
	public List<Status> status;
	public List<Type> type;
	public List<Department> department;
	public List<MembershipType> membershipType;
	public List<Language> language;
	public List<Level> level;
	public List<InsuranceType> insuranceType;
	public List<Insurance> insurance;
	public List<SocialCommunication> socialCommunication;
	public List<Nationality> nationality;
	public List<Nationals> nationals;
	public List<School> school;
	public List<Supervisor> supervisor;
	public List<WorkShift> workShift;
	public List<Country> country;
	
	@JsonInclude(value=Include.NON_NULL)
	public Employee employee;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
}
