package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.Authorisation;
import com.balancika.hrms.app.entities.authorisation.AuthorisationDetail;
import com.balancika.hrms.app.services.authorisation.AuthorisationServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("AuthorisationServiceImplJDBC")
public class AuthorisationServiceImpl implements AuthorisationServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> add(Authorisation authorisation) {
		try {
			String AuthName = tool.CheckStringNull(authorisation.getAuthName());
			String Auth= "";
			Auth += "(";
			Auth += "'TempAuth_ID',";
			Auth += "'" + tool.CheckStringNull(authorisation.getAuthName()) + "',";
			Auth += "'" + tool.CheckStringNull(authorisation.getAuthType()) + "',";
			Auth += "'" + tool.CheckStringNull(authorisation.getAuthAndOr()) + "',";
			Auth += "'" + authorisation.getAuthAmount() + "'";
			Auth += ")";
				
			String AuthDetail = "";
			if(authorisation.authorisationDetail != null){
				for(AuthorisationDetail authorisationDetail : authorisation.authorisationDetail){
					AuthDetail += "(";
					AuthDetail += "'TempAuth_ID',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthEmpID()) + "',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthGroupID()) + "',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthGroupAndOr()) + "',";
					AuthDetail += "'" + authorisationDetail.getAuthGroupAmount() + "'";
					AuthDetail += "),";
				}
				if (AuthDetail != "") {
					AuthDetail = AuthDetail.substring(0, AuthDetail.length() - 1);
				}
			}
			return tool.SPSelect(authorisation.meDataSource, "spHRMAddAuthorisation", authorisation.meDataSource.getUserid(), AuthName.toLowerCase(), Auth, AuthDetail);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(Authorisation authorisation) {
		try {
			String AuthID = tool.CheckStringNull(authorisation.getAuthID());
			String AuthName = tool.CheckStringNull(authorisation.getAuthName());
			String Auth = "";
			Auth += "Auth_ID='" + tool.CheckStringNull(authorisation.getAuthID()) + "',";
			Auth += "Auth_Name='" + tool.CheckStringNull(authorisation.getAuthName()) + "',";
			Auth += "Auth_Type='" + tool.CheckStringNull(authorisation.getAuthType()) + "',";
			Auth += "Auth_AndOr='" + tool.CheckStringNull(authorisation.getAuthAndOr()) + "',";
			Auth += "Auth_Amount='" + authorisation.getAuthAmount() + "'";
			
			String AuthDetail = "";
			if(authorisation.authorisationDetail != null){
				for(AuthorisationDetail authorisationDetail : authorisation.authorisationDetail){
					AuthDetail += "(";
					AuthDetail += "'TempAuth_ID',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthEmpID()) + "',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthGroupID()) + "',";
					AuthDetail += "'" + tool.CheckStringNull(authorisationDetail.getAuthGroupAndOr()) + "',";
					AuthDetail += "'" + authorisationDetail.getAuthGroupAmount() + "'";
					AuthDetail += "),";
				}
				if (AuthDetail != "") {
					AuthDetail = AuthDetail.substring(0, AuthDetail.length() - 1);
				}
			}
			return tool.SPSelect(authorisation.meDataSource, "spHRMUpdateAuthorisation", authorisation.meDataSource.getUserid(), AuthID, AuthName.toLowerCase(), Auth, AuthDetail);
			
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> delete(MeDataSource meDataSource, String ID) {
		try {
			return tool.SPSelect(meDataSource, "spHRMDeleteAuthorisation", meDataSource.getUserid(), ID);
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public Authorisation get(MeDataSource meDataSource, String ID) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationID", ID);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				Authorisation authorisation = new Authorisation();
				authorisation.setAuthID(c.get("Auth_ID").toString());
				authorisation.setAuthName(c.get("Auth_Name").toString());
				authorisation.setAuthType(c.get("Auth_Type").toString());
				authorisation.setAuthAndOr(c.get("Auth_AndOr").toString());
				authorisation.setAuthAmount((c.get("Auth_Amount").toString().equals(""))? 0 : (int)c.get("Auth_Amount"));
				
				List<AuthorisationDetail> TempAuthDetail = new ArrayList<AuthorisationDetail>();
				Data = MainData.get(1);
				if(Data.size()>0){	
					for(ConcurrentHashMap<String, Object> d : Data){
						AuthorisationDetail authorisationDetail = new AuthorisationDetail();
						authorisationDetail.setAuthID(d.get("Auth_ID").toString());
						authorisationDetail.setAuthEmpID(d.get("Auth_EmpID").toString());
						authorisationDetail.setAuthGroupID(d.get("Auth_GroupID").toString());
						authorisationDetail.setAuthGroupAndOr(d.get("Auth_GroupAndOr").toString());
						authorisationDetail.setAuthGroupAmount((d.get("Auth_GroupAmount").toString().equals(""))? 0 : (int)d.get("Auth_GroupAmount"));
						TempAuthDetail.add(authorisationDetail);
					}
				}
				authorisation.authorisationDetail = TempAuthDetail;
				
				return authorisation;
			}
		}
		return null;
	}

	@Override
	public Authorisation getOffset(MeDataSource meDataSource, long offset) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationOffset", Long.toString(offset));
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				Authorisation authorisation = new Authorisation();
				authorisation.setAuthID(c.get("Auth_ID").toString());
				authorisation.setAuthName(c.get("Auth_Name").toString());
				authorisation.setAuthType(c.get("Auth_Type").toString());
				authorisation.setAuthAndOr(c.get("Auth_AndOr").toString());
				authorisation.setAuthAmount((c.get("Auth_Amount").toString().equals(""))? 0 : (int)c.get("Auth_Amount"));
				
				List<AuthorisationDetail> TempAuthDetail = new ArrayList<AuthorisationDetail>();
				Data = MainData.get(1);
				if(Data.size()>0){	
					for(ConcurrentHashMap<String, Object> d : Data){
						AuthorisationDetail authorisationDetail = new AuthorisationDetail();
						authorisationDetail.setAuthID(d.get("Auth_ID").toString());
						authorisationDetail.setAuthEmpID(d.get("Auth_EmpID").toString());
						authorisationDetail.setAuthGroupID(d.get("Auth_GroupID").toString());
						authorisationDetail.setAuthGroupAndOr(d.get("Auth_GroupAndOr").toString());
						authorisationDetail.setAuthGroupAmount((d.get("Auth_GroupAmount").toString().equals(""))? 0 : (int)d.get("Auth_GroupAmount"));
						TempAuthDetail.add(authorisationDetail);
					}
				}
				authorisation.authorisationDetail = TempAuthDetail;
				
				return authorisation;
			}
		}
		return null;
	}

	@Override
	public List<Authorisation> search(MeDataSource meDataSource, String ColumnName, String Value) {
		ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMSearchAuthorisation", ColumnName, Value);
		List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
		List<Authorisation> authorisations = new ArrayList<Authorisation>();
		if(Data.size()>0){	
			for(ConcurrentHashMap<String, Object> c : Data){
				Authorisation authorisation = new Authorisation();
				authorisation.setAuthID(c.get("Auth_ID").toString());
				authorisation.setAuthName(c.get("Auth_Name").toString());
				authorisation.setAuthType(c.get("Auth_Type").toString());
				authorisation.setAuthAndOr(c.get("Auth_AndOr").toString());
				authorisation.setAuthAmount((c.get("Auth_Amount").toString().equals(""))? 0 : (int)c.get("Auth_Amount"));
				
				authorisations.add(authorisation);
			}
		}
		return authorisations;
	}

}
