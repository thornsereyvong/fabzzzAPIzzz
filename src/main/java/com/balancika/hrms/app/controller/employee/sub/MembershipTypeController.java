package com.balancika.hrms.app.controller.employee.sub;

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

import com.balancika.hrms.app.entities.employee.sub.MembershipType;
import com.balancika.hrms.app.services.employee.sub.EmployeeMembershipTypeServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;


@RestController
@RequestMapping("api/employee/membershiptype")
public class MembershipTypeController {
	
	@Autowired
	@Qualifier("EmployeeMembershipTypeServiceImplJDBC")
	EmployeeMembershipTypeServices employeeMembershipTypeServices;
		
	@RequestMapping(value = {"/search/{Col}/{V}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> search(@PathVariable("Col") String column,@PathVariable("V") String Value, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<MembershipType> EMT = employeeMembershipTypeServices.search(meDataSource, column, Value.toLowerCase());
			if(EMT != null){
				m.put("message", "success");
				m.put("membershipType", EMT);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> add(@RequestBody MembershipType EMT){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeMembershipTypeServices.add(EMT)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("Message").toString().equals("exist")) {
						m.put("message", "exist");
					} else {
						m.put("message", "success");
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}		
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{MembershipTypeName}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("MembershipTypeName") String MembershipTypeName, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
				try {
					for(List<ConcurrentHashMap<String, Object>> Data : employeeMembershipTypeServices.delete(meDataSource, MembershipTypeName)){
						for(ConcurrentHashMap<String, Object> D : Data){
							m.put("message", D.get("Message").toString());
						}
					}
				} catch (Exception e) {
					m.put("message", "fail");
				}				
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
}
