package com.balancika.hrms.app.entities.authorisation;

import java.util.List;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AuthorisationGroup {
	private String authGroupID;
	private String authGroupName;
	private String authGroupDescription;
	
	public List<AuthorisationGroupDetail> authorisationGroupDetail;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getAuthGroupID() {
		return authGroupID;
	}

	public void setAuthGroupID(String authGroupID) {
		this.authGroupID = authGroupID;
	}

	public String getAuthGroupName() {
		return authGroupName;
	}

	public void setAuthGroupName(String authGroupName) {
		this.authGroupName = authGroupName;
	}

	public String getAuthGroupDescription() {
		return authGroupDescription;
	}

	public void setAuthGroupDescription(String authGroupDescription) {
		this.authGroupDescription = authGroupDescription;
	}
	
	
}
