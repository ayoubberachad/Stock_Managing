package com.stockmanaging.stockmanaging.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.stockmanaging.stockmanaging.models.Employee; 

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	@Query("SELECT emp FROM Employee emp WHERE emp.mail=:mail")
	Optional<Employee> findByMail(String mail);

	//Employee findByMail(String mail);

}
