package com.balancika.hrms.app.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balancika.hrms.app.entities.employee.Employee;
import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.EmployeeServices;
import com.balancika.hrms.app.tool.MainTool;
import com.balancika.hrms.app.toolimpl.MeDataSource;


@RestController
@RequestMapping("api/employee")
public class EmployeeController {
	
	@Autowired
	@Qualifier("EmployeeServiceImplJDBC")
	EmployeeServices employeeservices;
	
	@Autowired
	@Qualifier("MainToolJDBC")
	MainTool tool;
	
	@RequestMapping(value = {"/add"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> add(HttpServletRequest servletRequest, @RequestBody Employee E){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeservices.add(E, servletRequest)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("emp_ID", D.get("EmpID").toString());
					m.put("message", "success");
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}		
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> update(HttpServletRequest servletRequest, @RequestBody Employee E){
		boolean b = employeeservices.update(E, servletRequest);
		Map<String, Object> m = new HashMap<String, Object>();
		if (b) {
			m.put("message", "success");
		} else {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	} 
	
	
	@RequestMapping(value = {"/get_emp_id/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpID(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Employee e = employeeservices.get(meDataSource, EmpID);
			if(e != null){
				m.put("message", "success");
				m.put("employee", e);
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
			List<Employee> emp = employeeservices.search(meDataSource, column, Value.toLowerCase());
			if(emp != null){
				if(emp.size()>0){
					m.put("message", "success");
					m.put("employee", emp);
				}
				else{
					m.put("message", "fail");
				}
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/get_emp_offset/{Offset}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmpOffset(@PathVariable("Offset") long Offset, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Employee e = employeeservices.getOffset(meDataSource, Offset);
			if(e != null){
				m.put("message", "success");
				m.put("main_employee", e);
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
	public ResponseEntity<Map<String, Object>> delete(HttpServletRequest servletRequest, @PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			ArrayList<List<ConcurrentHashMap<String, Object>>> Data = employeeservices.delete(meDataSource, EmpID);
			for (ConcurrentHashMap<String, Object> D : Data.get(2)) {
				m.put("message", D.get("Message").toString());
				if (D.get("Message").toString().equals("success")) {
					if (meDataSource.getIp().equals("localhost") || meDataSource.getIp().equals("192.168.0.2")) {
						for (ConcurrentHashMap<String, Object> delete : Data.get(0)) {
							tool.DeleteFile(meDataSource.getDb(), delete.get("EmpImg").toString(), servletRequest);
						}
					} else {
						String Temp = "";
						for (ConcurrentHashMap<String, Object> delete : Data.get(0)) {
							Temp += delete.get("EmpImg").toString() + "/";
						}
						tool.SPExecute(meDataSource, "spHRMDeleteFiles", Temp);
					}
					if (meDataSource.getIp().equals("localhost") || meDataSource.getIp().equals("192.168.0.2")) {
						for (ConcurrentHashMap<String, Object> delete : Data.get(1)) {
							tool.DeleteFile(meDataSource.getDb(), delete.get("Att_FilePath").toString(), servletRequest);
						}
					} else {
						String Temp = "";
						for (ConcurrentHashMap<String, Object> delete : Data.get(1)) {
							Temp += delete.get("Att_FilePath").toString() + "/";
						}
						tool.SPExecute(meDataSource, "spHRMDeleteFiles", Temp);
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> search(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> sup = employeeservices.list(meDataSource);
			if(sup != null){
				if(sup.size()>0){
					m.put("message", "success");
					m.put("employee", sup);
				}
				else{
					m.put("message", "fail");
				}
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
