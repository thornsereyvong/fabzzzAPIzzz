package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class MembershipType {
	
	private String MembershipType_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getMembershipType_Name() {
		return MembershipType_Name;
	}

	public void setMembershipType_Name(String membershipType_Name) {
		MembershipType_Name = membershipType_Name;
	}
}
