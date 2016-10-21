package com.balancika.hrms.app.controller.timesheet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.services.timesheet.EmployeeLeaveTypeServices;
import com.balancika.hrms.app.services.timesheet.LeaveServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/timesheet")
public class TimeSheetController {
	
	@Autowired
	@Qualifier("EmployeeLeaveTypeServiceImplJDBC")
	EmployeeLeaveTypeServices employeeLeaveTypeServices;
	
	@Autowired
	@Qualifier("LeaveServiceImplJDBC")
	LeaveServices leaveServices;
	
	@RequestMapping(value = {"/employeeleavetype"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> employee = employeeLeaveTypeServices.Sub(meDataSource);
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
	
	@RequestMapping(value = {"/leave"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getLeaveSub(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> employee = leaveServices.Sub(meDataSource);
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
}
