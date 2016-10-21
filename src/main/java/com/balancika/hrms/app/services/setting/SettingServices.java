package com.balancika.hrms.app.services.setting;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.balancika.hrms.app.entities.setting.GeneralSetting;
import com.balancika.hrms.app.toolimpl.MeDataSource;

public interface SettingServices {
	public ArrayList<ArrayList<List<ConcurrentHashMap<String, Object>>>> update(GeneralSetting generalSetting);
	public GeneralSetting get(MeDataSource meDataSource);
}
