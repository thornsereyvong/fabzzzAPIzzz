package com.balancika.hrms.app.controller.timesheet;

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

import com.balancika.hrms.app.entities.timesheet.EmployeeLeaveTypes;
import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.services.timesheet.EmployeeLeaveTypeServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/timesheet/employeeleavetype")
public class EmployeeLeaveTypeContoller {
	
	@Autowired
	@Qualifier("EmployeeLeaveTypeServiceImplJDBC")
	EmployeeLeaveTypeServices employeeLeaveTypeServices;
	
	@RequestMapping(value = {"/get_id/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeLeaveTypes empLeaveTypes = employeeLeaveTypeServices.get(meDataSource, EmpID);
			if(empLeaveTypes != null){
				m.put("message", "success");
				m.put("employeeLeaveType", empLeaveTypes);
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
			EmployeeLeaveTypes empLeaveTypes = employeeLeaveTypeServices.search(meDataSource, column, Value.toLowerCase());
			if(empLeaveTypes != null){
				m.put("message", "success");
				m.put("employeeLeaveType", empLeaveTypes);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody EmployeeLeaveTypes employeeLeaveTypes){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeLeaveTypeServices.add(employeeLeaveTypes)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("ID").toString().equals("exist")) {
						m.put("message", "exist");
					} else {
						m.put("EmpID", D.get("ID").toString());
						m.put("message", "success");
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{EmpID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("EmpID") String EmpID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeLeaveTypeServices.delete(meDataSource, EmpID)) {

				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Message").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}	
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/sub/{EmpID}/{Year}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getSubSearch(@PathVariable("EmpID") String EmpID, @PathVariable("Year") int Year, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<LeaveType> leaveTypes = employeeLeaveTypeServices.Sub(meDataSource, EmpID, Year);
			if(leaveTypes != null){
				m.put("message", "success");
				m.put("leaveType", leaveTypes);
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
