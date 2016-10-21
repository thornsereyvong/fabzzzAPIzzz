package com.balancika.hrms.app.entities.employee.sub;

import com.balancika.hrms.app.toolimpl.MeDataSource;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;


public class Category {
	
	private String Category_Name;
	
	@JsonInclude(value=Include.NON_NULL)
	public MeDataSource meDataSource;

	public String getCategory_Name() {
		return Category_Name;
	}

	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
	}
	
}
