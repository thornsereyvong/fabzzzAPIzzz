package com.balancika.hrms.app.services.payroll;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.payroll.Currency;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface CurrencyServices {
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Currency currency);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Currency currency);
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID);
	public Currency get(MeDataSource meDataSource, String ID);
	public Currency getOffset(MeDataSource meDataSource, long offset);
	public List<Currency> search(MeDataSource meDataSource, String ColumnName, String Value);
}
