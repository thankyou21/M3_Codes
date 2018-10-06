package com.example.DBServices;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
//@Table(name="NEWEMPLOYEE_157998")
public class Employee
{

	
//	@Column(name="emp_id")
	@Id
	private Long id;
	
//	@Column(name="emp_name")
	private String name;
	
//	@Column(name="emp_age")
	private int age;
	
//	@Column(name="emp_salary")
	private int salary;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age
				+ ", salary=" + salary + "]";
	}
	
	
	
	
	
	
	
	
}
