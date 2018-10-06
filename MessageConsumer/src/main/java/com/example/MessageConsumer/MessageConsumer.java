package com.example.MessageConsumer;

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
public class MessageConsumer 
{

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/consume/{param}")
	public Object consume(@PathVariable("param") int param)
	{
		String url="http://localhost:8080/emp/select/"+param;
		
		return (restTemplate.getForEntity(url, Employee.class));
		
	
		
	}
	
	
	@PostMapping("/insertFromConsumer")
	public Employee post()
	{
		String url="http://localhost:8080/emp/insert";
		
		
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		Employee emp=new Employee();
		emp.setAge(26);
		emp.setName("Harayon");
		emp.setSalary(100);
		
		
		HttpEntity<Employee> emp2=new HttpEntity<Employee> (emp,headers);
		
		
		Employee eData=restTemplate.postForObject(url,emp2,Employee.class);
		
		return eData;
		
	}
}
