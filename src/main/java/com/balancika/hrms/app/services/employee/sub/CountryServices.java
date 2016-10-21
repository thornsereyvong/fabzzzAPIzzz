package com.balancika.hrms.app.services.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.employee.sub.Country;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface CountryServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Country country);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Country country);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource,String ID);
	public Country get(MeDataSource meDataSource, String ID);
	public Country getOffset(MeDataSource meDataSource, long offset);
	public List<Country> search(MeDataSource meDataSource, String ColumnName, String Value);
}
