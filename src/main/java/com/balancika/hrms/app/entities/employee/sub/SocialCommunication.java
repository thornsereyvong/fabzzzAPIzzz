package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class SocialCommunication {
	private String SocialCommunication_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getSocialCommunication_Name() {
		return SocialCommunication_Name;
	}

	public void setSocialCommunication_Name(String socialCommunication_Name) {
		SocialCommunication_Name = socialCommunication_Name;
	}
	
	
}
