package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class Position {
	private int Position_ID;
	private String Position_Name;
	private String Position_NameKh;
	private int Position_Level;
	private String Position_Description;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;
	
	
	public int getPosition_ID() {
		return Position_ID;
	}
	public void setPosition_ID(int position_ID) {
		Position_ID = position_ID;
	}
	public String getPosition_Name() {
		return Position_Name;
	}
	public void setPosition_Name(String position_Name) {
		Position_Name = position_Name;
	}
	public String getPosition_NameKh() {
		return Position_NameKh;
	}
	public void setPosition_NameKh(String position_NameKh) {
		Position_NameKh = position_NameKh;
	}
	public int getPosition_Level() {
		return Position_Level;
	}
	public void setPosition_Level(int position_Level) {
		Position_Level = position_Level;
	}
	public String getPosition_Description() {
		return Position_Description;
	}
	public void setPosition_Description(String position_Description) {
		Position_Description = position_Description;
	}
}
