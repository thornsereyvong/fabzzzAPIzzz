package com.balancika.hrms.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balancika.hrms.app.entities.setting.GeneralSetting;
import com.balancika.hrms.app.services.setting.SettingServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/setting")
public class SettingController {
	
	@Autowired
	@Qualifier("GeneralSettingImplJDBC")
	SettingServices settingServices;

	@RequestMapping(value = {"/get"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpID(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			GeneralSetting generalSetting = settingServices.get(meDataSource);
			if(generalSetting != null){
				m.put("message", "success");
				m.put("generalSetting", generalSetting);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public ResponseEntity<List<Map<String, Object>>> update(@RequestBody GeneralSetting generalSettings){
		List<Map<String, Object>> lm = new ArrayList<Map<String,Object>>();
		for(ArrayList<List<ConcurrentHashMap<String, Object>>> MainData : settingServices.update(generalSettings)){
			if(MainData != null){
				try {
					for(List<ConcurrentHashMap<String, Object>> Data : MainData){
						Map<String, Object> m = new HashMap<String, Object>();
						for(ConcurrentHashMap<String, Object> D : Data){
							m.put("message", D.get("Exist").toString());
						}
						lm.add(m);
					}
				} catch (Exception e) {
					Map<String, Object> m = new HashMap<String, Object>();
					m.put("message", "fail");
					lm.add(m);
				}				
			}
			else{
				Map<String, Object> m = new HashMap<String, Object>();
				m.put("message", "fail");
				lm.add(m);
			}
		}			
		if(lm.size()<=0){
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("message", "fail");
			lm.add(m);
		}
		return new ResponseEntity<List<Map<String, Object>>>(lm, HttpStatus.CREATED);
	} 
}
