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

import com.balancika.hrms.app.entities.employee.sub.InsuranceType;
import com.balancika.hrms.app.services.employee.sub.EmployeeInsuranceTypeServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@RestController
@RequestMapping("api/employee/insurancetype")
public class EmployeeInsuranceTypeController {
	
	@Autowired
	@Qualifier("EmployeeInsuranceTypeServiceImplJDBC")
	EmployeeInsuranceTypeServices employeeInsuranceTypeServices;
	
	@RequestMapping(value = {"/search/{Col}/{V}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> search(@PathVariable("Col") String column,@PathVariable("V") String Value, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<InsuranceType> IT = employeeInsuranceTypeServices.search(meDataSource, column, Value.toLowerCase());
			if(IT != null){
				m.put("message", "success");
				m.put("insuranceType", IT);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody InsuranceType IT){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : employeeInsuranceTypeServices.add(IT)) {

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
	
	@RequestMapping(value = {"/delete/{InsuranceTypeName}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("InsuranceTypeName") String InsuranceTypeName, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
				try {
					for(List<ConcurrentHashMap<String, Object>> Data : employeeInsuranceTypeServices.delete(meDataSource, InsuranceTypeName)){
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
