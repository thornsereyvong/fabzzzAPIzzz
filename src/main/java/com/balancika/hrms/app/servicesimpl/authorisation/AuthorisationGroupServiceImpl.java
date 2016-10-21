package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationGroup;
import com.balancika.hrms.app.entities.authorisation.AuthorisationGroupDetail;
import com.balancika.hrms.app.services.authorisation.AuthorisationGroupServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("AuthorisationGroupServiceImplJDBC")
public class AuthorisationGroupServiceImpl implements AuthorisationGroupServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(AuthorisationGroup authorisationGroup) {
		try {
			String AuthGroupName = tool.CheckStringNull(authorisationGroup.getAuthGroupName());
			String AuthGroup = "";
			AuthGroup += "(";
			AuthGroup += "'TempAuth_ID',";
			AuthGroup += "'" + tool.CheckStringNull(authorisationGroup.getAuthGroupName()) + "',";
			AuthGroup += "'" + tool.CheckStringNull(authorisationGroup.getAuthGroupDescription()) + "'";
			AuthGroup += ")";
			
			String AuthGroupDetail = "";
			if(authorisationGroup.authorisationGroupDetail != null){
				for(AuthorisationGroupDetail authorisationGroupDetail : authorisationGroup.authorisationGroupDetail){
					AuthGroupDetail += "(";
					AuthGroupDetail += "'TempAuth_ID',";
					AuthGroupDetail += "'" + tool.CheckStringNull(authorisationGroupDetail.getAuthGroupEmpID()) + "'";
					AuthGroupDetail += "),";
				}
				if (AuthGroupDetail != "") {
					AuthGroupDetail = AuthGroupDetail.substring(0, AuthGroupDetail.length() - 1);
				}
			}
			return tool.SPSelect(authorisationGroup.meDataSource, "spHRMAddAuthorisationGroup", authorisationGroup.meDataSource.getUserid(), AuthGroupName.toLowerCase(), AuthGroup, AuthGroupDetail);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(AuthorisationGroup authorisationGroup) {
		try {
			String AuthGroupID = tool.CheckStringNull(authorisationGroup.getAuthGroupID());
			String AuthGroupName = tool.CheckStringNull(authorisationGroup.getAuthGroupName());
			String AuthGroup = "";
			AuthGroup += "AuthGroup_ID='" + tool.CheckStringNull(authorisationGroup.getAuthGroupID()) + "',";
			AuthGroup += "AuthGroup_Name='" + tool.CheckStringNull(authorisationGroup.getAuthGroupName()) + "',";
			AuthGroup += "AuthGroup_Description='" + tool.CheckStringNull(authorisationGroup.getAuthGroupDescription()) + "'";
			
			String AuthGroupDetail = "";
			if(authorisationGroup.authorisationGroupDetail != null){
				for(AuthorisationGroupDetail authorisationGroupDetail : authorisationGroup.authorisationGroupDetail){
					AuthGroupDetail += "(";
					AuthGroupDetail += "'" + authorisationGroupDetail.getAuthGroupID() + "',";
					AuthGroupDetail += "'" + authorisationGroupDetail.getAuthGroupEmpID() + "'";
					AuthGroupDetail += "),";
				}
				if (AuthGroupDetail != "") {
					AuthGroupDetail = AuthGroupDetail.substring(0, AuthGroupDetail.length() - 1);
				}
			}
			return tool.SPSelect(authorisationGroup.meDataSource, "spHRMUpdateAuthorisationGroup", authorisationGroup.meDataSource.getUserid(), AuthGroupID, AuthGroupName.toLowerCase(), AuthGroup, AuthGroupDetail);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteAuthorisationGroup", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public AuthorisationGroup get(MeDataSource meDataSource, String ID) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationGroupID", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				AuthorisationGroup authorisationGroup = new AuthorisationGroup();
				authorisationGroup.setAuthGroupID(c.get("AuthGroup_ID").toString());
				authorisationGroup.setAuthGroupName(c.get("AuthGroup_Name").toString());
				authorisationGroup.setAuthGroupDescription(c.get("AuthGroup_Description").toString());
				
				List<AuthorisationGroupDetail> TempAuthGroupDetail = new ArrayList<AuthorisationGroupDetail>();
				Data = MainData.get(1);
				if(Data.size()>0){	
					for(ConcurrentHashMap<String, Object> d : Data){
						AuthorisationGroupDetail authorisationGroupDetail = new AuthorisationGroupDetail();
						authorisationGroupDetail.setAuthGroupID(d.get("AuthGroup_ID").toString());
						authorisationGroupDetail.setAuthGroupEmpID(d.get("AuthGroup_EmpID").toString());
						TempAuthGroupDetail.add(authorisationGroupDetail);
					}
				}
				authorisationGroup.authorisationGroupDetail = TempAuthGroupDetail;
				
				return authorisationGroup;
			}
		}
		return null;
	}

	@Override
	public AuthorisationGroup getOffset(MeDataSource meDataSource, long offset) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationGroupOffset", Long.toString(offset));
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				AuthorisationGroup authorisationGroup = new AuthorisationGroup();
				authorisationGroup.setAuthGroupID(c.get("AuthGroup_ID").toString());
				authorisationGroup.setAuthGroupName(c.get("AuthGroup_Name").toString());
				authorisationGroup.setAuthGroupDescription(c.get("AuthGroup_Description").toString());
				
				List<AuthorisationGroupDetail> TempAuthGroupDetail = new ArrayList<AuthorisationGroupDetail>();
				Data = MainData.get(1);
				if(Data.size()>0){	
					for(ConcurrentHashMap<String, Object> d : Data){
						AuthorisationGroupDetail authorisationGroupDetail = new AuthorisationGroupDetail();
						authorisationGroupDetail.setAuthGroupID(d.get("AuthGroup_ID").toString());
						authorisationGroupDetail.setAuthGroupEmpID(d.get("AuthGroup_EmpID").toString());
						TempAuthGroupDetail.add(authorisationGroupDetail);
					}
				}
				authorisationGroup.authorisationGroupDetail = TempAuthGroupDetail;
				
				return authorisationGroup;
			}
		}
		return null;
	}

	@Override
	public List<AuthorisationGroup> search(MeDataSource meDataSource, String ColumnName, String Value) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchAuthorisationGroup", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<AuthorisationGroup> authorisationGroups = new ArrayList<AuthorisationGroup>();
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				AuthorisationGroup authorisationGroup = new AuthorisationGroup();
				authorisationGroup.setAuthGroupID(c.get("AuthGroup_ID").toString());
				authorisationGroup.setAuthGroupName(c.get("AuthGroup_Name").toString());
				authorisationGroup.setAuthGroupDescription(c.get("AuthGroup_Description").toString());
				
				authorisationGroups.add(authorisationGroup);
			}
		}
		return authorisationGroups;
		
	}

}
