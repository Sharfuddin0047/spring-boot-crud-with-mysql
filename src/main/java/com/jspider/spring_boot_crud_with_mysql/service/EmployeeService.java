package com.jspider.spring_boot_crud_with_mysql.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
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

	public Employee getEmployeeByIdService(Integer id) {

		if (employeeRepository.existsById(id)) {
			return employeeRepository.findById(id).get();
		} else {
			throw new RuntimeException("Employee not found");
		}

	}
	
	
	public Page<Employee> getEmployeePageNumberService(int pageNumber) {
		return employeeRepository.findAll(PageRequest.of(pageNumber, 3));
	}
	
	public List<Employee> sortEmployeeAsc(String attributeName) {
		return employeeRepository.findAll(Sort.by(Direction.ASC, attributeName));
	}
	
	public List<Employee> sortEmployeeDesc(String attributeName) {
		return employeeRepository.findAll(Sort.by(Direction.DESC, attributeName));
	}
}
