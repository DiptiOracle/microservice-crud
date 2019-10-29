package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.AccountBean;
import com.example.demo.model.EmployeeBean;
import com.example.demo.proxy.EmployeeServiceProxy;

@RestController
public class BalanceCalculatorController {

	// @Autowired
	// private EmployeeServiceProxy employeeServiceProxy;

	@GetMapping("/emp/totalbalance/{empName}")
	public String getTotalBalanceOfTheEmployee(@PathVariable String empName) {
		
		  String URL="http://localhost:8989/emp/name/{empName}";
		  Map<String,String> uriVariableMap = new HashMap<>();
		  uriVariableMap.put("empName", empName); 
		  EmployeeBean emp = new  RestTemplate().getForObject(URL, EmployeeBean.class, uriVariableMap);
		  BigDecimal totalbalance = new BigDecimal(0.0); 
		  for(AccountBean account : emp.getAccounts())
		  {
			  totalbalance = totalbalance.add(account.getBalance());
			  
		  }
		  return "Total Balance of "+emp.getFirstName()+"="+totalbalance;
		  
		  
		  }

}
