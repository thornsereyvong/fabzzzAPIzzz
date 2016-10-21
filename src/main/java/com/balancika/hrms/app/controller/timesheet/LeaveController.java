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

import com.balancika.hrms.app.entities.timesheet.Leave;
import com.balancika.hrms.app.entities.timesheet.LeaveSummary;
import com.balancika.hrms.app.services.timesheet.LeaveServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/timesheet/leave")
public class LeaveController {
	
	@Autowired
	@Qualifier("LeaveServiceImplJDBC")
	LeaveServices leaveServices;
	
	@RequestMapping(value = {"/get_by_id/{LeaveID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("LeaveID") String LeaveID, @RequestBody MeDataSource meDataSource) {		
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Leave leave = leaveServices.get(meDataSource, LeaveID);
			if(leave != null){
				m.put("message", "success");
				m.put("leave", leave);
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
			List<Leave> leaves = leaveServices.search(meDataSource, column, Value.toLowerCase());
			if(leaves != null){
				m.put("message", "success");
				m.put("leave", leaves);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody Leave leave){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveServices.add(leave)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("ID").toString().equals("no authorisation")) {
						m.put("message", "no authorisation");
					}
					if(D.get("ID").toString().equals("not allow")){
						m.put("message", "not allow");
					}else {
						m.put("leaveID", D.get("ID").toString());
						m.put("message", "success");
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Leave leave){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveServices.update(leave)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Exist").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{LeaveID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("LeaveID") String LeaveID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveServices.delete(meDataSource, LeaveID)) {
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
			List<LeaveSummary> leaveSummaries = leaveServices.Sub(meDataSource, EmpID, Year);
			if(leaveSummaries != null){
				m.put("message", "success");
				m.put("leaveSummary", leaveSummaries);
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
