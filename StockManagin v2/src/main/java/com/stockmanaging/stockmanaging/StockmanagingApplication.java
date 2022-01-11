package com.stockmanaging.stockmanaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.stockmanaging.stockmanaging.models.Company;
import com.stockmanaging.stockmanaging.models.Employee;
import com.stockmanaging.stockmanaging.repository.CompanyJPA;
import com.stockmanaging.stockmanaging.repository.EmployeeRepository;
import com.stockmanaging.stockmanaging.service.CompanyService;
import com.stockmanaging.stockmanaging.service.EmployeeService;

@SpringBootApplication
public class StockmanagingApplication implements CommandLineRunner {

	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService  employeeService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(StockmanagingApplication.class, args);
	 
		
	}


	@Override
	public void run(String... args) throws Exception {
//		companyService.addCompany(new Company("test", "dell.com", "dell.jpeg", "0666666", "desc"));		
//		employeeService.addEmployee(new Employee("Berachad", "berachad@gmail.com", "05050505", "picture.peg"));
//		
	}

}
