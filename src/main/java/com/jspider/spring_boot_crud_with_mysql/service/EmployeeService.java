package com.jspider.spring_boot_crud_with_mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspider.spring_boot_crud_with_mysql.entity.Employee;
import com.jspider.spring_boot_crud_with_mysql.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployeeService(Employee employee) {
		return employeeRepository.saveAndFlush(employee);
	}
	
	public List<Employee> saveAllEmployeeService(List<Employee> employees) {
		return employeeRepository.saveAllAndFlush(employees);
	}
	
	public boolean deleteEmployeeByIdService(int id) {
		if (employeeRepository.existsById(id)) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
