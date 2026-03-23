package com.jspider.spring_boot_crud_with_mysql.request_response;

import com.jspider.spring_boot_crud_with_mysql.dto.EmployeeDto;
import com.jspider.spring_boot_crud_with_mysql.entity.Employee;

public class EmployeeRequestResponse {
	public static Employee convertToEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		employee.setId(employeeDto.getId());
		employee.setName(employeeDto.getName());
		employee.setEmail(employeeDto.getEmail());
		employee.setPassword(employeeDto.getPassword());
		employee.setDepartment(employeeDto.getDepartment());
		employee.setSalary(employeeDto.getSalary());
		
		return employee;
	}
	
	public static EmployeeDto convertToEmployeeDto(Employee emp) {
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(emp.getId());
		empDto.setName(emp.getName());
		empDto.setEmail(emp.getEmail());
		empDto.setDepartment(emp.getDepartment());
		empDto.setSalary(emp.getSalary());
	
		return empDto;
	}
}
