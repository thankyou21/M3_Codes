package com.example.DBServices;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/emp")
public class EmployeeServices 
{

	@Autowired
	EmployeeDao edao;
	
	Employee eRecord;
	

	
	@GetMapping(value="/select/{id}",produces=MediaType.APPLICATION_XML_VALUE)
//	@RequestMapping(path="/select",method=RequestMethod.GET,produces=MediaType.APPLICATION_XHTML_XML_VALUE) ----->Either the above annotation or this annotation will do the trick
	public Employee readEmployee(@PathVariable("id") int id)
	{
		Employee emp=new Employee();
		
		emp.setAge(12);
		emp.setName("Sayon");
		emp.setSalary(25000);
		System.out.println(id);
		
		return emp;
		
	}
	
	
	@PostMapping(value="/insert",consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee insertEmployee(@RequestBody Employee emp)
	{
		edao.save(emp);
		
		System.out.println(emp);
		
		return emp;
		
	}
	
	
	@GetMapping(value="/retrieveOne/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public Employee retrieveOneEmployee(@PathVariable("id") long id)
	{
		
		return edao.getOne(id);
		
	}
	
	
	
	@GetMapping(value="/retrieveAll")
	public List<Employee> retrieveAllEmployee()
	{
		
		List<Employee> empList=edao.findAll();
		
		return empList;
		
	}
	
	
	@DeleteMapping(value="/delete/{id}",produces=MediaType.APPLICATION_XML_VALUE)
	public Employee fetchEmployee(@PathVariable("id") long id)
	{
		
		eRecord=edao.getOne(id);
		edao.delete(eRecord);
		System.out.println("Record deleted successfully");
		return eRecord;
		
	}
	
	
	@PutMapping(value="/update/{id}",produces=MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Employee updateEmployee(@PathVariable("id") long id,@RequestBody Employee empDetails)
	{
		
		
		edao.save(empDetails);
		
		System.out.println(empDetails);
		
		return empDetails;
		
	}
	
	@GetMapping(value="/findByName/{name}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> retrieveByName(@PathVariable("name") String name)
	{
		List<Employee> eList=edao.findByName(name);
		
		return eList;
		
	}
	
	
}
