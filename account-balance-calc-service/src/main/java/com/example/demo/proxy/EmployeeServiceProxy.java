package com.example.demo.proxy;

//import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.EmployeeBean;

//@FeignClient(name = "employee-service",url = "localhost:8989")
public interface EmployeeServiceProxy {
	@GetMapping("/emp/name/{empName}")
	public EmployeeBean findEmployeeByName(@PathVariable("empName") String empName);
}
