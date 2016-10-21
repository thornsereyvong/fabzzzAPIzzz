package com.balancika.hrms.app.servicesimpl.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.setting.GeneralSetting;
import com.balancika.hrms.app.entities.setting.Setting;
import com.balancika.hrms.app.services.setting.SettingServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("GeneralSettingImplJDBC")
public class SettingServiceImpl implements SettingServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<ArrayList<List<ConcurrentHashMap<String, Object>>>> update(GeneralSetting generalSetting) {
		ArrayList<ArrayList<List<ConcurrentHashMap<String, Object>>>> Temp = new ArrayList<ArrayList<List<ConcurrentHashMap<String, Object>>>>();
		try {
			String Setting = "";
			String condition = "";
			for(Setting set: generalSetting.Setting){
				if(tool.CheckStringNull(set.getSettingValue()) != ""){
					String Value = tool.CheckStringNull(set.getSettingValue());
					if(Value.toLowerCase() == "true"){
						Value = "1";
					}
					else if(Value.toLowerCase() == "false"){
						Value = "0";
					}
					Setting += "WHEN (Setting_Type='" + tool.CheckStringNull(set.getSettingType()) + "' AND Setting_Name ='" + tool.CheckStringNull(set.getSettingName()) + "') THEN '" + Value + "' ";
					condition += "(Setting_Type='" + tool.CheckStringNull(set.getSettingType()) + "' AND Setting_Name ='" + tool.CheckStringNull(set.getSettingName()) + "') OR";
				}	
			}
			if (condition != "") {
				condition = condition.substring(0, condition.length() - 3);
			}
			Temp.add(tool.SPSelect(generalSetting.meDataSource, "spHRMUpdateSetting", generalSetting.meDataSource.getUserid(), Setting, condition));
		} catch (Exception e) {
			return Temp;
		}
		return Temp;
	}

	@Override
	public GeneralSetting get(MeDataSource meDataSource) {
		GeneralSetting generalSetting = new GeneralSetting();
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetSetting");
		List<Setting> settings = new ArrayList<Setting>();
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				Setting set = new Setting();
				set.setSettingType(c.get("Setting_Type").toString());
				set.setSettingName(c.get("Setting_Name").toString());
				set.setSettingValue(c.get("Setting_Value").toString());
				settings.add(set);
			}
			generalSetting.Setting = settings;
			
		}
		return generalSetting;
	}

}
