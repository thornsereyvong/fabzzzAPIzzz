package com.balancika.hrms.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.balancika.hrms.app.entities.authorisation.AuthorisationSub;
import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisationSub;
import com.balancika.hrms.app.entities.employee.sub.EmployeeSub;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.authorisation.AuthorisationGroupSubServices;
import com.balancika.hrms.app.services.authorisation.AuthorisationSubServices;
import com.balancika.hrms.app.services.authorisation.EmployeeAuthorisationSubServices;
import com.balancika.hrms.app.services.employee.sub.EmployeeSubServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Controller
@RequestMapping("api")
public class MainController {
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@Autowired
	@Qualifier("EmployeeSubServiceImplJDBC")
	EmployeeSubServices employeeSub;
	
	@Autowired
	@Qualifier("AuthorisationGroupSubServiceImplJDBC")
	AuthorisationGroupSubServices authorisationGroupSubServices;
	
	@Autowired
	@Qualifier("AuthorisationSubServiceImplJDBC")
	AuthorisationSubServices authorisationSubServices;
	
	@Autowired
	@Qualifier("EmployeeAuthorisationSubServiceImplJDBC")
	EmployeeAuthorisationSubServices employeeAuthorisationSubServices;
	
	@RequestMapping(value = {"/employee"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpID(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeSub ES = employeeSub.get(meDataSource);
			if(ES != null){
				m.put("message", "success");
				m.put("employeeSub", ES);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/employee/update/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getSubUpdate(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeSub ES = employeeSub.get(meDataSource, EmpID);
			if(ES != null){
				m.put("message", "success");
				m.put("employeeSub", ES);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/authorisation"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getAuthorisation(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			AuthorisationSub AuthSub = authorisationSubServices.get(meDataSource);
			if(AuthSub != null){
				m.put("message", "success");
				m.put("authorisationSub", AuthSub);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/authorisationgroup"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getAuthorisationGroup(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> employee = authorisationGroupSubServices.get(meDataSource);
			if(employee != null){
				m.put("message", "success");
				m.put("employee", employee);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/employeeauthorisation"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmployeeAuthorisation(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeAuthorisationSub employeeAuthorisationSub = employeeAuthorisationSubServices.get(meDataSource);
			if(employeeAuthorisationSub != null){
				m.put("message", "success");
				m.put("employeeAuthorisationSub", employeeAuthorisationSub);
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
