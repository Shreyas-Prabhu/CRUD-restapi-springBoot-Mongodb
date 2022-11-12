package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo repo;
	
	//CRUD
	public String saveEmp(Employee emp)
	{
		if(repo.existsById(emp.getEmpid())) {
		
			return "Employee with id : "+emp.getEmpid()+" already present";
		}
		else {
			repo.save(emp);
			return "Employee Saved";
			
		}
	}
	
	public Optional<Employee> display(int id)
	{
		return repo.findById(id);
	}
	
	public List<Employee> getEmployees()
	{
		return repo.findAll();
	}
	
	public String deleteEmp(int id)
	{
		if(repo.existsById(id) ){
			
			repo.deleteById(id);
			return "Deleted";
		}
		else {
			return "Employee with id : "+id+" not present";
		}
		
	}
	
	public String updateEmp(Employee emp)
	{
		if(repo.existsById(emp.getEmpid())) {
		
			repo.save(emp);
			return "Employee Updated";
		}
		else {
			return "Employee with id : "+emp.getEmpid()+" not present";
			
		}
	}
}
