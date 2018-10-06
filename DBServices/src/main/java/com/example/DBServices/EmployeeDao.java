package com.example.DBServices;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee, Long>
{

	public List<Employee> findByName(String name);
}
