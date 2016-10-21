package com.balancika.hrms.app.servicesimpl.authorisation;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApprove;
import com.balancika.hrms.app.services.authorisation.AuthorisationApproveServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Service("AuthorisationApproveServiceImplJDBC")
public class AuthorisationApproveServiceImpl implements AuthorisationApproveServices {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;

	@Override
	public ArrayList<List<ConcurrentHashMap<String, Object>>> update(AuthorisationApprove authorisationApprove) {
		try {
			
			if(authorisationApprove != null && authorisationApprove.meDataSource != null && (authorisationApprove.getAuthStatus().toLowerCase().equals("requested") || authorisationApprove.getAuthStatus().toLowerCase().equals("approved") || authorisationApprove.getAuthStatus().toLowerCase().equals("rejected"))){
				String AuthStatus = tool.CheckStringNull(authorisationApprove.getAuthStatus()).toLowerCase();
				return tool.SPSelect(authorisationApprove.meDataSource, "spHRMUpdateAuthorisationApprove", authorisationApprove.meDataSource.getUserid(), tool.CheckStringNull(authorisationApprove.getAuthProcessID()), tool.CheckStringNull(authorisationApprove.getAuthProcessName()), tool.CheckStringNull(authorisationApprove.getAuthID()), tool.CheckStringNull(authorisationApprove.getAuthGroupID()), tool.CheckStringNull(authorisationApprove.getAuthEmpID()), AuthStatus);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<AuthorisationApprove> get(MeDataSource meDataSource, String ID) {
		try {
			List<AuthorisationApprove> authorisationApproves = new ArrayList<AuthorisationApprove>();
			ArrayList<List<ConcurrentHashMap<String, Object>>> MainData = tool.SPSelect(meDataSource, "spHRMGetAuthorisationApproveEmpID", ID);
			List<ConcurrentHashMap<String, Object>> Data = MainData.get(0);
			if(Data.size()>0){
				for(ConcurrentHashMap<String, Object> c : Data){
					AuthorisationApprove authorisationApprove = new AuthorisationApprove();
					authorisationApprove.setAuthProcessID(c.get("Auth_ProcessID").toString());
					authorisationApprove.setAuthProcessName(c.get("Auth_ProcessName").toString());
					authorisationApprove.setAuthID(c.get("Auth_ID").toString());
					authorisationApprove.setAuthGroupID(c.get("Auth_GroupID").toString());
					authorisationApprove.setAuthEmpID(c.get("Auth_EmpID").toString());
					authorisationApprove.setAuthStatus(c.get("Auth_Status").toString());
					authorisationApprove.setAuthEdit((boolean)c.get("Auth_Edit"));
					authorisationApproves.add(authorisationApprove);
				}
				return authorisationApproves;
			}
		} catch (Exception e) {
			
		}
		return null;
	}

}
