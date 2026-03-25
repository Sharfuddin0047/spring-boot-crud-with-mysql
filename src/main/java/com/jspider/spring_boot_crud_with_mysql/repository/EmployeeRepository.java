package com.jspider.spring_boot_crud_with_mysql.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jspider.spring_boot_crud_with_mysql.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	// select e from Employee e where e.email = :email
	Optional<Employee> findByEmail(String email);
	
	
	List<Employee> findBySalary(double salary);
	
	@Transactional
	@Modifying
	@Query(value = "DELETE FROM Employee e WHERE e.email = ?1 ")
	void deletByEmail(String email);
	
}
