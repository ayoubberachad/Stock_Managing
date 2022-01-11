package com.stockmanaging.stockmanaging.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stockmanaging.stockmanaging.exception.ResourceNotFoundException;
import com.stockmanaging.stockmanaging.models.Employee;
import com.stockmanaging.stockmanaging.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployees() {
		List<Employee> employees = employeeRepository.findAll();
		if (employees.isEmpty()) {
			throw new ResourceNotFoundException("cant find any employee");
		}
		return employees;
	}

	public Optional<Employee> getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new ResourceNotFoundException("no employee found with that id");
		}
		return employee;
	}

	public void addEmployee(Employee employee) {
		Optional<Employee> employeeByMail = employeeRepository.findByMail(employee.getMail());
		if (employeeByMail.isPresent()) {
			throw new ResourceNotFoundException("This mail Already exist !!!");
		}
		employeeRepository.save(employee);
	}

	public void updateEmployee(Long id, Employee employeeFromView) {

		Employee employeeFoundInDB = employeeRepository.findById(id).get();
		Optional<Employee> employeeByMail = employeeRepository.findByMail(employeeFromView.getMail());
		if (employeeByMail.isPresent()) {
			throw new ResourceNotFoundException("Cannot update this employee, This mail Already exist !!!");
		}
		employeeFoundInDB.setMail(employeeFromView.getMail());
		employeeFoundInDB.setName(employeeFromView.getName());
		employeeFoundInDB.setPhone(employeeFromView.getPhone());
		employeeFoundInDB.setPicture(employeeFromView.getPicture());

		employeeRepository.save(employeeFoundInDB);
	}

	public void delateEmployee(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new ResourceNotFoundException("Cannot delete, no employee found with that id");
		}
		employeeRepository.deleteById(id);
	}

}
