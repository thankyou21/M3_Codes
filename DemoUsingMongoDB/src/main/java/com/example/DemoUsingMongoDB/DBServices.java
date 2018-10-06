package com.example.DemoUsingMongoDB;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface DBServices extends MongoRepository<Employee, Long>
{

	public Employee findByName(String name);
	
	public Employee findByNameAndAge(String name,int age);
	
	
	
}
