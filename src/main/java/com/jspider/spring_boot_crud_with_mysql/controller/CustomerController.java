package com.jspider.spring_boot_crud_with_mysql.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value= "/customer")
public class CustomerController {
	
	@GetMapping(value= "/getTodaysDate")
	public String getTodaysDate() {
		System.out.println("Today date is coming from Customer controller "+LocalDate.now());
		return "Today date is "+LocalDate.now();
	}
}
