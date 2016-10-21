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

import com.balancika.hrms.app.entities.authorisation.EmployeeAuthorisations;
import com.balancika.hrms.app.services.authorisation.EmployeeAuthorisationServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/employeeauthorisation")
public class EmployeeAuthorisationController {
	
	@Autowired
	@Qualifier("EmployeeAuthorisationServiceImplJDBC")
	EmployeeAuthorisationServices employeeAuthorisationServices;
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> add(@RequestBody EmployeeAuthorisations employeeAuthorisations){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeAuthorisationServices.add(employeeAuthorisations)) {

				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Message").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/get_id/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpID(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeAuthorisations employeeAuthorisations = employeeAuthorisationServices.get(meDataSource, EmpID);
			if(employeeAuthorisations != null){
				m.put("message", "success");
				m.put("employeeAuthorisations", employeeAuthorisations);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/search/{Col}/{V}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> search(@PathVariable("Col") String column,@PathVariable("V") String Value, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeAuthorisations employeeAuthorisations = employeeAuthorisationServices.search(meDataSource, column, Value.toLowerCase());
			if(employeeAuthorisations != null){
					m.put("message", "success");
					m.put("employeeAuthorisations", employeeAuthorisations);
			}
			else{
					m.put("message", "fail");
			}
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = {"/get_offset/{Offset}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpOffset(@PathVariable("Offset") long Offset, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeAuthorisations employeeAuthorisations = employeeAuthorisationServices.getOffset(meDataSource, Offset);
			if(employeeAuthorisations != null){
				m.put("message", "success");
				m.put("employeeAuthorisations", employeeAuthorisations);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeAuthorisationServices.delete(meDataSource, EmpID)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Message").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}	
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
}
