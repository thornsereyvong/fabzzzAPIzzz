package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.Country;
import com.balancika.hrms.app.services.employee.sub.CountryServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("LocationCountryServiceImplJDBC")
public class CountryServiceImpl implements CountryServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Country country) {
		try {
			if (country != null) {
				String countryName = tool.CheckStringNull(country.getCountryName());
				String C = "";
				C += "(";
				C += "'" + tool.CheckStringNull(country.getCountryName()) + "'";
				C += ")";
				return tool.SPSelect(country.meDataSource, "spHRMAddEmployeeCountry", country.meDataSource.getUserid(), countryName.toLowerCase(), C, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Country country) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeCountry", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Country get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Country getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Country> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<Country> countries = new ArrayList<Country>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeCountry", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Country country = new Country();
					country.setCountryName(c.get("Country_Name").toString());
					countries.add(country);
				}
			}
			return countries;
		} catch (Exception e) {
			
		}
		return null;
	}

}
