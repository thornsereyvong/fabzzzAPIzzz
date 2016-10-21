package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.Currency;
import com.balancika.hrms.app.services.payroll.CurrencyServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("CurrencyServiceImplJDBC")
public class CurrencyServiceImpl implements CurrencyServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Currency currency) {
		try {
			if (currency != null) {
				if(currency.isCurrencyDefault()==true){
					currency.setCurrencyRate(1);
				}
				String cur = "";
				String cur_Name = tool.CheckStringNull(currency.getCurrencyName());
				cur += "(";
				cur += "'Temp_ID',";
				cur += "'" + tool.CheckStringNull(currency.getCurrencyName()) + "',";
				cur += "'" + tool.CheckStringNull(currency.getCurrencyPlacing()) + "',";
				cur += currency.getCurrencyRate() + ",";
				cur += "'" + tool.CheckStringNull(currency.getCurrencyDescription()) + "',";
				cur += (currency.isCurrencyDefault()==true) ? 1 : 0;
				cur += ")";
				String curH ="";
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				curH += "(";
				curH += "'Temp_ID',";
				curH += "'" + tool.CheckStringNull(currency.getCurrencyName()) + "',";
				curH += "'" + date + "',";
				curH += currency.getCurrencyRate();
				curH += ")";
				if (cur != "") {
					return tool.SPSelect(currency.meDataSource, "spHRMAddCurrency",
							currency.meDataSource.getUserid(), cur_Name.toLowerCase(), cur, curH, ""+((currency.isCurrencyDefault()==true) ? 1 : 0));
				}
				
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Currency currency) {
		try {
			if (currency != null) {
				String cur = "";
				String cur_Name = tool.CheckStringNull(currency.getCurrencyName());
				cur += "Currency_ID='" + tool.CheckStringNull(currency.getCurrencyID()) + "',";
				cur += "Currency_Name='" + tool.CheckStringNull(currency.getCurrencyName()) + "',";
				cur += "Currency_Placing='" + tool.CheckStringNull(currency.getCurrencyPlacing()) + "',";
				if(currency.isCurrencyDefault()==false){
					cur += "Currency_Rate=" + currency.getCurrencyRate() + ",";
				}
				cur += "Currency_Description='" + tool.CheckStringNull(currency.getCurrencyDescription()) + "',";
				cur += "Currency_Default="+ ((currency.isCurrencyDefault()==true) ? 1 : 0);
				String curH ="";
				java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				curH += "Currency_ID='" + tool.CheckStringNull(currency.getCurrencyID()) + "',";
				curH += "Currency_Name='" + tool.CheckStringNull(currency.getCurrencyName()) + "',";
				curH += "Currency_Date='" + date + "',";
				curH += "Currency_Rate=" + currency.getCurrencyRate();
				
				return tool.SPSelect(currency.meDataSource, "spHRMUpdateCurrency", currency.meDataSource.getUserid(),
						"" + currency.getCurrencyID(), cur_Name.toLowerCase(), cur, curH, ""+date, ""+((currency.isCurrencyDefault()==true) ? 1 : 0));
			}
		}catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteCurrency", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Currency get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetCurrency", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Currency cur = new Currency();
					cur.setCurrencyID(c.get("Currency_ID").toString());
					cur.setCurrencyName(c.get("Currency_Name").toString());
					cur.setCurrencyPlacing(c.get("Currency_Placing").toString());
					cur.setCurrencyRate((double)c.get("Currency_Rate"));
					cur.setCurrencyDescription(c.get("Currency_Description").toString());
					cur.setCurrencyDefault(Boolean.valueOf(c.get("Currency_Default").toString()));
					return cur;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Currency getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Currency> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchCurrency", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<Currency> currencies = new ArrayList<Currency>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					Currency cur = new Currency();
					cur.setCurrencyID(c.get("Currency_ID").toString());
					cur.setCurrencyName(c.get("Currency_Name").toString());
					cur.setCurrencyPlacing(c.get("Currency_Placing").toString());
					cur.setCurrencyRate((double)c.get("Currency_Rate"));
					cur.setCurrencyDescription(c.get("Currency_Description").toString());
					cur.setCurrencyDefault(Boolean.valueOf(c.get("Currency_Default").toString()));
					currencies.add(cur);
				}
			}
			return currencies;
		} catch (Exception e) {
			
		}
		return null;
	}

}
