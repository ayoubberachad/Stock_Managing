package com.stockmanaging.stockmanaging.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stockmanaging.stockmanaging.exception.ApiRequestException;
import com.stockmanaging.stockmanaging.exception.ResourceNotFoundException;
import com.stockmanaging.stockmanaging.models.Company;
import com.stockmanaging.stockmanaging.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Company>> getAllCompanies(){
		List<Company> companies = companyService.getAllCompanies(); 	
		return new ResponseEntity<>(companies, HttpStatus.OK );
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getCompanyById(@PathVariable("id") Long id) {
		Optional<Company> company = companyService.getCompanyById(id);
		return ResponseEntity.of(company);
	}
	
	@PutMapping("/add")
	public void addCompany(@RequestBody Company company ) {
		companyService.addCompany(company);
	}
	
	@PostMapping("/update/{id}")
	public void updateCompany(@PathVariable("id") Long id, @RequestBody Company company) {
		companyService.updateCompany(id, company);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteCompany(@PathVariable("id") Long id ) {
		companyService.deleteCompany(id);
	}
	
}
