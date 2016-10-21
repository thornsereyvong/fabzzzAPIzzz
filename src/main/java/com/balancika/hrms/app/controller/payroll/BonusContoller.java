package com.balancika.hrms.app.controller.payroll;

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

import com.balancika.hrms.app.entities.payroll.Bonus;
import com.balancika.hrms.app.services.payroll.BonusServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/payroll/bonus")
public class BonusContoller {
	@Autowired
	@Qualifier("BonusServiceImplJDBC")
	BonusServices bonusServices;
	
	@RequestMapping(value = {"/get_by_id/{BonusID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("BonusID") String BonusID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Bonus b = bonusServices.get(meDataSource, BonusID);
			if(b != null){
				m.put("message", "success");
				m.put("bonus", b);
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
			List<Bonus> bonus = bonusServices.search(meDataSource, column, Value.toLowerCase());
			if(bonus != null){
				m.put("message", "success");
				m.put("bonus", bonus);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody Bonus bonus){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : bonusServices.add(bonus)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("ID").toString().equals("no authorisation")) {
						m.put("message", "no authorisation");
					} else {
						m.put("bonusID", D.get("ID").toString());
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
	public ResponseEntity<Map<String, Object>> update(@RequestBody Bonus bonus){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : bonusServices.update(bonus)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Exist").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{BonusID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("BonusID") String BonusID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : bonusServices.delete(meDataSource, BonusID)) {
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
