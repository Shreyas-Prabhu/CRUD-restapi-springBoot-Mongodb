package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
	
	@Autowired
	 private EmployeeService service;
	
	@GetMapping("/get/{empid}")
	public Optional<Employee> getEmployee(@PathVariable("empid") int eid)
	{
		return service.display(eid);
	}
	
	@GetMapping("/all")
	public List<Employee> getAll()
	{
		return service.getEmployees();
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee emp)
	{
		return service.saveEmp(emp);
		
	}
	
	@DeleteMapping("/delete/{empid}")
	public String deleteEmployee(@PathVariable("empid") int eid)
	{
		return service.deleteEmp(eid);
	}
	
	@PutMapping("/update")
	public String updateEmployee(@RequestBody Employee emp)
	{
		return service.updateEmp(emp);
		
	}
}
