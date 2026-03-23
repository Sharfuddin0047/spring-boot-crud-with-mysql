package com.jspider.spring_boot_crud_with_mysql.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jspider.spring_boot_crud_with_mysql.dto.EmployeeDto;
import com.jspider.spring_boot_crud_with_mysql.entity.Employee;
import com.jspider.spring_boot_crud_with_mysql.request_response.EmployeeRequestResponse;
import com.jspider.spring_boot_crud_with_mysql.service.EmployeeService;

@RestController
@RequestMapping(value= "/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@GetMapping(value = "/getTodaysDate")
	public String getTodaysDate() {
		System.out.println("Today date is coming from Employee controller" + LocalDate.now());
		return "Today date is " + LocalDate.now();
	}
	
	
	@PostMapping(value = "/saveEmployee")
	public EmployeeDto saveEmployeeController(@RequestBody EmployeeDto employeeDto) {
		
		Employee emp = employeeService.saveEmployeeService(EmployeeRequestResponse.convertToEmployee(employeeDto));
		
		return EmployeeRequestResponse.convertToEmployeeDto(emp);
	}
	
	@PostMapping(value = "/saveAllEmployee")
	public List<EmployeeDto> saveAllEmployeeController(@RequestBody List<EmployeeDto> employeeDto) {
		
		List<Employee> employees = new ArrayList<>();
		
		for (EmployeeDto empDto : employeeDto) {
			employees.add(EmployeeRequestResponse.convertToEmployee(empDto));
		}
		
		List<Employee> employee2 =  employeeService.saveAllEmployeeService(employees);
		List<EmployeeDto> employeeDto2 = new ArrayList<>();
		
		for (Employee employee : employee2) {
			employeeDto2.add(EmployeeRequestResponse.convertToEmployeeDto(employee));
		}
		
		return employeeDto2;
		
	}
	
	@GetMapping(value = "/getEmpById/{id}")
	public ResponseEntity<?> getEmployeeByIdController(@PathVariable Integer id) {
		
		return null;
	}
	
	@DeleteMapping(value = "/deleteEmpById/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable Integer id) {
		
		boolean deleted = employeeService.deleteEmployeeByIdService(id);
	    if (deleted) {
	        return ResponseEntity.ok("Employee deleted with id " + id);
	    } else {
	        return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                             .body("Employee not found with id " + id);
	    }

	}
}
