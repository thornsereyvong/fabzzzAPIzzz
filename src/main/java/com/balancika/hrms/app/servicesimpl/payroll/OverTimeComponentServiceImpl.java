package com.balancika.hrms.app.servicesimpl.payroll;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.payroll.OverTimeComponent;
import com.balancika.hrms.app.services.payroll.OverTimeComponentServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("OverTimeComponentServiceImplJDBC")
public class OverTimeComponentServiceImpl implements OverTimeComponentServices{
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;


	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(OverTimeComponent overTimeComponent) {
		try {
			if (overTimeComponent != null) {
				String OTComName = tool.CheckStringNull(overTimeComponent.getoTComName());
				String OTCom = "";
				OTCom += "(";
				OTCom += "'Temp_ID',";
				OTCom += "'" + tool.CheckStringNull(overTimeComponent.getoTComName()) + "',";
				OTCom += "'" + tool.CheckStringNull(overTimeComponent.getOtComPayType()) + "',";
				OTCom += ""+ overTimeComponent.getOtComPayAmount();
				OTCom += ")";
				
				java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				String OTCom2 = "";
				OTCom2 += "(";
				OTCom2 += "'Temp_ID',";
				OTCom2 += "'" + now + "',";
				OTCom2 += "'" + tool.CheckStringNull(overTimeComponent.getOtComPayType()) + "',";
				OTCom2 += ""+ overTimeComponent.getOtComPayAmount();
				OTCom2 += ")";
				return tool.SPSelect(overTimeComponent.meDataSource, "spHRMAddOverTimeComponent", overTimeComponent.meDataSource.getUserid(), OTComName.toLowerCase(), OTCom, OTCom2);
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(OverTimeComponent overTimeComponent) {
		try {
			if (overTimeComponent != null) {
				String OTComName = tool.CheckStringNull(overTimeComponent.getoTComName());
				String OTCom = "";
				OTCom += "OTCom_ID='" + tool.CheckStringNull(overTimeComponent.getoTComID()) + "',";
				OTCom += "OTCom_Name='" + tool.CheckStringNull(overTimeComponent.getoTComName()) + "',";
				OTCom += "OTCom_PayType='" + tool.CheckStringNull(overTimeComponent.getOtComPayType()) + "',";
				OTCom += "OTCom_PayAmount=" + overTimeComponent.getOtComPayAmount();
				
				java.sql.Date now = new java.sql.Date(Calendar.getInstance().getTime().getTime());
				String OTCom2 = "";
				OTCom2 += "(";
				OTCom2 += "'" + tool.CheckStringNull(overTimeComponent.getoTComID()) + "',";
				OTCom2 += "'" + now + "',";
				OTCom2 += "'" + tool.CheckStringNull(overTimeComponent.getOtComPayType()) + "',";
				OTCom2 += ""+ overTimeComponent.getOtComPayAmount();
				OTCom2 += ")";
				
				return tool.SPSelect(overTimeComponent.meDataSource, "spHRMUpdateOverTimeComponent",
						overTimeComponent.meDataSource.getUserid(), "" + overTimeComponent.getoTComID(),
						OTComName.toLowerCase(), OTCom, OTCom2);
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteOverTimeComponent", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public OverTimeComponent get(MeDataSource meDataSource, String ID) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetOverTimeComponentID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					OverTimeComponent otc = new OverTimeComponent();
					otc.setoTComID(c.get("OTCom_ID").toString());
					otc.setoTComName(c.get("OTCom_Name").toString());
					otc.setOtComPayType(c.get("OTCom_PayType").toString());
					otc.setOtComPayAmount(Double.parseDouble(c.get("OTCom_PayAmount").toString()));
					return otc;
				}
			}
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public OverTimeComponent getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OverTimeComponent> search(MeDataSource meDataSource, String ColumnName, String Value) {
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchOverTimeComponent", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			List<OverTimeComponent> OTC = new ArrayList<OverTimeComponent>();
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					OverTimeComponent otc = new OverTimeComponent();
					otc.setoTComID(c.get("OTCom_ID").toString());
					otc.setoTComName(c.get("OTCom_Name").toString());
					otc.setOtComPayType(c.get("OTCom_PayType").toString());
					otc.setOtComPayAmount(Double.parseDouble(c.get("OTCom_PayAmount").toString()));
					OTC.add(otc);
				}
			}
			return OTC;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
