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

import com.balancika.hrms.app.entities.timesheet.LeaveType;
import com.balancika.hrms.app.services.timesheet.LeaveTypeServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/timesheet/leavetype")
public class LeaveTypeController {
	@Autowired
	@Qualifier("LeaveTypeServiceImplJDBC")
	LeaveTypeServices leaveTypeServices;
	
	@RequestMapping(value = {"/get_id/{LeaveTypeID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("LeaveTypeID") String LeaveTypeID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			LeaveType lt = leaveTypeServices.get(meDataSource, LeaveTypeID);
			if(lt != null){
				m.put("message", "success");
				m.put("leaveType", lt);
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
			List<LeaveType> ltLeaveTypes = leaveTypeServices.search(meDataSource, column, Value.toLowerCase());
			if(ltLeaveTypes != null){
				m.put("message", "success");
				m.put("leaveType", ltLeaveTypes);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody LeaveType lt){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveTypeServices.add(lt)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("ID").toString().equals("exist")) {
						m.put("message", "exist");
					} else {
						m.put("leaveType", D.get("ID").toString());
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
	public ResponseEntity<Map<String, Object>> update(@RequestBody LeaveType lt){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveTypeServices.update(lt)) {

				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Exist").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{LeaveTypeID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("LeaveTypeID") String LeaveTypeID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : leaveTypeServices.delete(meDataSource, LeaveTypeID)) {

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
