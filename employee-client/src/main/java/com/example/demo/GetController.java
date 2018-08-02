package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {

	@GetMapping("/getdata")
	public EmployeeDTO getData() {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmpID("1124");
		dto.setName("hvbdfd");
		System.err.println(dto);
		return dto;
	}
}
