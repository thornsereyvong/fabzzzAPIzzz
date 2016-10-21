package com.balancika.hrms.app.controller.authorisation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balancika.hrms.app.entities.authorisation.AuthorisationApprove;
import com.balancika.hrms.app.services.authorisation.AuthorisationApproveServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/authorisationapprove")
public class AuthorisationApproveController {
	
	@Autowired
	@Qualifier("AuthorisationApproveServiceImplJDBC")
	AuthorisationApproveServices authorisationApproveServices;
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> update(@RequestBody AuthorisationApprove authorisationApprove){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : authorisationApproveServices.update(authorisationApprove)) {

				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Message").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpID(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<AuthorisationApprove> authorisationApproves = authorisationApproveServices.get(meDataSource, EmpID);
			if(authorisationApproves != null){
				m.put("message", "success");
				m.put("authorisationApprove", authorisationApproves);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
}
