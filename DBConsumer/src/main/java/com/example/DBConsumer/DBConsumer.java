package com.example.DBConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class DBConsumer 
{

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping(value="/findOne/{id}")
	public Object findFromConsumer(@PathVariable("id") Long id)
	{
		
		String url="http://localhost:8080/emp/retrieveOne/"+id;
		
		return restTemplate.getForEntity(url, Employee.class);
		
	}
	
	
	@PostMapping(value="/insertViaConsumer")
	public Employee insertViaConsumer()
	{
		
		String url="http://localhost:8080/emp/insert";
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Employee emp=new Employee();
		emp.setAge(29);
		emp.setId(50L);
		emp.setName("Arnav");
		emp.setSalary(45000);
		
		HttpEntity<Employee> emp2=new HttpEntity<Employee>(emp,headers);
		
		Employee eData=restTemplate.postForObject(url, emp2, Employee.class);
		
		return eData;
		
	}
	
	
}
