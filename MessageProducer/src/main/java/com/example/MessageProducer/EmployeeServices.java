package com.example.MessageProducer;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/emp")
public class EmployeeServices 
{

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
		System.out.println(emp);
		
		return emp;
		
	}
	

}
