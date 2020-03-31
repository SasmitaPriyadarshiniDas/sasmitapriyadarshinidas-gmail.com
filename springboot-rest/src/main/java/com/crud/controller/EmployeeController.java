package com.crud.controller;

import java.util.List;
import java.util.Optional;

import javax.net.ssl.SSLEngineResult.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.crud.pojo.Employee;
import com.crud.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/find/{id}")
	public Optional<Employee> findById(@PathVariable String id) {
		Optional<Employee> emp;
		if (id == null) {
			System.out.println("Enter the value correct");
		} else {
			if (id != null) {
				return emp = employeeRepository.findById(id);

			} else {
				System.out.println("not able to find id");
			}
		}
		return null;

	}

	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findall() {
		List<Employee> emps = employeeRepository.findAll();
		return new ResponseEntity<List<Employee>>(emps, HttpStatus.OK);
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		if (employee == null) {
			employeeRepository.save(employee);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Employee> deleteById(@PathVariable String id) {
		if (id == null) {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteall")
	public ResponseEntity<Employee> deleteAll() {
		employeeRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> update(@RequestBody Employee employee) {
		if (employee == null) {
			employeeRepository.save(employee);
			return new ResponseEntity<Employee>(HttpStatus.OK);
		} else {
			return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
		}
	}
}
