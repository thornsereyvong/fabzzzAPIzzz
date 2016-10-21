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

import com.balancika.hrms.app.entities.payroll.Currency;
import com.balancika.hrms.app.services.payroll.CurrencyServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/payroll/currency")
public class CurrencyController {
	@Autowired
	@Qualifier("CurrencyServiceImplJDBC")
	CurrencyServices currencyServices;
	
	@RequestMapping(value = {"/get_by_id/{CurrencyID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("CurrencyID") String CurrencyID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Currency cur = currencyServices.get(meDataSource, CurrencyID);
			if(cur != null){
				m.put("message", "success");
				m.put("currency", cur);
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
			List<Currency> currencies = currencyServices.search(meDataSource, column, Value.toLowerCase());
			if(currencies != null){
				m.put("message", "success");
				m.put("currency", currencies);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody Currency currency){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : currencyServices.add(currency)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if(D.get("ID") != null){
						if (D.get("ID").toString().equals("exist")) {
							m.put("message", "exist");
						} else {
							m.put("currencyID", D.get("ID").toString());
							m.put("message", "success");
						}
					}
					if(D.get("alert") != null){
						m.put("alertmsg", D.get("alert").toString());
					}	
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/update"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> update(@RequestBody Currency currency){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : currencyServices.update(currency)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if(D.get("Exist") != null){
						m.put("message", D.get("Exist").toString());
					}
					if(D.get("alert") != null){
						m.put("alertmsg", D.get("alert").toString());
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{CurrencyID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("CurrencyID") String CurrencyID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : currencyServices.delete(meDataSource, CurrencyID)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if(D.get("Message") != null){
						m.put("message", D.get("Message").toString());
					}
					if(D.get("alert") != null){
						m.put("alertmsg", D.get("alert").toString());
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}	
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
}
