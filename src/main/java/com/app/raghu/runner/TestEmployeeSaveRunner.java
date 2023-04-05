package com.app.raghu.runner;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.app.raghu.entity.Employee;
import com.app.raghu.repo.EmployeeRepository;

@Component
public class TestEmployeeSaveRunner implements CommandLineRunner
{

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception 
	{
		repo.saveAll(Arrays.asList(
				new Employee(101,"AA",221.0,"DEV"),
				new Employee(102,"BB",140.0,"DEV"),
				new Employee(103,"CC",456.0,"QA"),
				new Employee(104,"DD",625.0,"QA")
				));
		
		repo.getAllEmployee().forEach(System.out::println);
		
		repo.fetchAllEmployee().forEach(System.out::println);
		
		repo.fetchIdAndNames().stream().map(obj -> obj[0] + ":" + obj[1]).forEach(System.out::println);
		
		Optional<String> opt = repo.getEmpNameById(101);
		if(opt.isPresent())
		{
			System.out.println(opt.get());
		}
		else
		{
			System.out.println("NO DATA");
		}
		
		
		Optional<Employee> e = repo.fetchEmployeeById(104);
		
		System.out.println(e);
	}

}
