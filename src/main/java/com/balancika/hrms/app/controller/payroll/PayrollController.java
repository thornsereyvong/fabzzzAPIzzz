package com.balancika.hrms.app.controller.payroll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.balancika.hrms.app.entities.employee.sub.Supervisor;
import com.balancika.hrms.app.entities.payroll.EmployeeAllowanceSub;
import com.balancika.hrms.app.entities.payroll.EmployeeOverTimeComponentSub;
import com.balancika.hrms.app.entities.payroll.Payroll;
import com.balancika.hrms.app.entities.payroll.SalarySub;
import com.balancika.hrms.app.services.payroll.BonusServices;
import com.balancika.hrms.app.services.payroll.DeductionServices;
import com.balancika.hrms.app.services.payroll.EmployeeAllowanceSubServices;
import com.balancika.hrms.app.services.payroll.EmployeeOverTimeComponentSubServices;
import com.balancika.hrms.app.services.payroll.OverTimeServices;
import com.balancika.hrms.app.services.payroll.PayrollServices;
import com.balancika.hrms.app.services.payroll.SalaryServices;
import com.balancika.hrms.app.toolimpl.MeDataSource;

@Controller
@RequestMapping("api/payroll")
public class PayrollController {
	@Autowired
	@Qualifier("SalaryServiceImplJDBC")
	SalaryServices salaryServices;
	
	@Autowired
	@Qualifier("EmployeeAllowanceSubServiceImplJDBC")
	EmployeeAllowanceSubServices employeeAllowanceSubServices;
	
	@Autowired
	@Qualifier("EmployeeOvertimeComponentSubServiceImplJDBC")
	EmployeeOverTimeComponentSubServices employeeOverTimeComponentSubServices;
	
	@Autowired
	@Qualifier("OverTimeServiceImplJDBC")
	OverTimeServices overTimeServices;
	
	@Autowired
	@Qualifier("BonusServiceImplJDBC")
	BonusServices bonusServices;
	
	@Autowired
	@Qualifier("DeductionServiceImplJDBC")
	DeductionServices deductionServices;
	
	@Autowired
	@Qualifier("PayrollServiceImplJDBC")
	PayrollServices payrollServices;
	
	@RequestMapping(value = {"/get_by_id/{PayrollID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getID(@PathVariable("PayrollID") String PayrollID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			Payroll p = payrollServices.get(meDataSource, PayrollID);
			if(p != null){
				m.put("message", "success");
				m.put("payroll", p);
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
			List<Payroll> p = payrollServices.search(meDataSource, column, Value.toLowerCase());
			if(p != null){
				m.put("message", "success");
				m.put("payroll", p);
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
	public ResponseEntity<Map<String, Object>> add(@RequestBody Payroll payroll){
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : payrollServices.add(payroll)) {
				for (ConcurrentHashMap<String, Object> D : Data) {
					if (D.get("ID").toString().equals("exist")) {
						m.put("message", "exist");
					} else {
						m.put("payrollID", D.get("ID").toString());
						m.put("message", "success");
					}
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/delete/{PayrollID}"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> delete(@PathVariable("PayrollID") String PayrollID, @RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			for (List<ConcurrentHashMap<String, Object>> Data : payrollServices.delete(meDataSource, PayrollID)) {

				for (ConcurrentHashMap<String, Object> D : Data) {
					m.put("message", D.get("Message").toString());
				}
			}
		} catch (Exception e) {
			m.put("message", "fail");
		}	
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/salary"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getSalary(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			SalarySub salarySub = salaryServices.Sub(meDataSource);
			if(salarySub != null){
				m.put("message", "success");
				m.put("salarySub", salarySub);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/employeeallowance"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmployeeAllowance(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeAllowanceSub employeeAllowanceSub = employeeAllowanceSubServices.get(meDataSource);
			if(employeeAllowanceSub != null){
				m.put("message", "success");
				m.put("employeeAllowanceSub", employeeAllowanceSub);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/employeeovertimecomponent"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getEmployeeOvertimeComponent(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			EmployeeOverTimeComponentSub employeeOverTimeComponentSub = employeeOverTimeComponentSubServices.get(meDataSource);
			if(employeeOverTimeComponentSub != null){
				m.put("message", "success");
				m.put("employeeOverTimeComponentSub", employeeOverTimeComponentSub);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/overtime"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getOvertime(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> supervisors = overTimeServices.sub(meDataSource);
			if(supervisors != null){
				m.put("message", "success");
				m.put("employee", supervisors);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/bonus"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getBonus(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> supervisors = bonusServices.sub(meDataSource);
			if(supervisors != null){
				m.put("message", "success");
				m.put("employee", supervisors);
				return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
			}
		} catch (Exception e) {
			m.put("message", "fail");
			return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
		}
		m.put("message", "fail");
		return new ResponseEntity<Map<String, Object>>(m, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = {"/deduction"}, method = RequestMethod.POST)
	public ResponseEntity<Map<String, Object>> getDeduction(@RequestBody MeDataSource meDataSource) {
		Map<String, Object> m = new HashMap<String, Object>();
		try {
			List<Supervisor> supervisors = deductionServices.sub(meDataSource);
			if(supervisors != null){
				m.put("message", "success");
				m.put("employee", supervisors);
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
