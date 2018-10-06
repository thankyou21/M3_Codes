package com.example.DemoUsingMongoDB;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeService 
{
	@Autowired
	DBServices service;

	@PostMapping(value="/insert")
	public String insert(@RequestBody Employee e)
	{
		service.save(e);
		return "success";
	}
	
	
	@GetMapping(value="/findAll",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> retrieveAll()
	{
		
		return service.findAll();
	}
	
	
	@GetMapping(value="/findOne/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Optional<Employee> retrieveOne(@PathVariable("id")Long id)
	{
		
		return service.findById(id);
	}
	
	
	@GetMapping(value="/findByName/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee retrieveByName(@PathVariable("name")String name)
	{
		
		return service.findByName(name);
	}
	
	@GetMapping(value="/findByName/{name}/{age}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Employee retrieveByNameAndAge(@PathVariable("name")String name,@PathVariable("age")int age)
	{
		
		return service.findByNameAndAge(name, age);
	}
	
	
	@DeleteMapping(value="/deleteOne/{age}")
	public String retrieveAllByname(@PathVariable("age") long age)
	{
		service.deleteById(age);
		
		return "Delete successful";
		
		
		
	}
	
	
	@PostMapping(value="/update/{age}")
	public String updateEmp(@PathVariable("age") Long age,@RequestBody Employee emp)
	{
		if(service.existsById(age))
		{
			service.save(emp);
			return "Update Successfull";
		}
		
		return "Object Not Found For id"+age;
		
	}
	
}
