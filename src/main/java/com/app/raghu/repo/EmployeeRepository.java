package com.app.raghu.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.raghu.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{
	@Query("SELECT empName FROM Employee")
	List<String> getAllEmployee();
	
	@Query("SELECT e FROM Employee e")
	List<Employee> fetchAllEmployee();
	
	@Query("SELECT e.empId,e.empName FROM Employee e")
	List<Object[]> fetchIdAndNames();
	
	@Query("SELECT e.empName FROM Employee e WHERE e.empId =:id")
	Optional<String>getEmpNameById(Integer id);
	
	@Query("SELECT e FROM Employee e WHERE e.empId =:id")
	Optional<Employee> fetchEmployeeById(Integer id);
}
