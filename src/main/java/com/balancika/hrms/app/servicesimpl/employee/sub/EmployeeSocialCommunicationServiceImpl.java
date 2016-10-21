package com.balancika.hrms.app.servicesimpl.employee.sub;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.employee.sub.SocialCommunication;
import com.balancika.hrms.app.services.employee.sub.EmployeeSocialCommunicationServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("SocialCommunicationServiceImplJDBC")
public class EmployeeSocialCommunicationServiceImpl implements EmployeeSocialCommunicationServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(SocialCommunication sc) {
		try {
			if(sc != null){
				String socialCommunicationName = tool.CheckStringNull(sc.getSocialCommunication_Name());
				String socialCommunication = "";
				socialCommunication += "(";
				socialCommunication += "'" + tool.CheckStringNull(sc.getSocialCommunication_Name()) + "'";
				socialCommunication += ")";
				return tool.SPSelect(sc.meDataSource, "spHRMAddEmployeeSocialCommunication", sc.meDataSource.getUserid(), socialCommunicationName.toLowerCase(), socialCommunication, "1");
			}
		} catch (Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(SocialCommunication socialCommunications) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource,	String Name) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteEmployeeSocialCommunication", meDataSource.getUserid(), Name);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public SocialCommunication get(MeDataSource meDataSource, String ID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SocialCommunication getOffset(MeDataSource meDataSource, long offset) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SocialCommunication> search(MeDataSource meDataSource, String ColumnName, String Value) {
		List<SocialCommunication> SC = new ArrayList<SocialCommunication>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchEmployeeSocialCommunication", ColumnName, Value);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					SocialCommunication sc = new SocialCommunication();
					sc.setSocialCommunication_Name(c.get("SocialCommunication_Name").toString());
					SC.add(sc);
				}
			}
			return SC;
		} catch (Exception e) {
			
		}
		return null;
	}
	
}
