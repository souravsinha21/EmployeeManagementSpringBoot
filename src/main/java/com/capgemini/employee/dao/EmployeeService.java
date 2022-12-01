package com.capgemini.employee.dao;

import java.util.List;

import com.capgemini.employee.model.EmployeeModel;
import org.springframework.data.domain.Page;

public interface EmployeeService {


	List<EmployeeModel> getAllEmployee();
	
	EmployeeModel getSingleEmployee(int Id);
	
	EmployeeModel saveEmployee(EmployeeModel obj);
	
	EmployeeModel updateEmployee(EmployeeModel obj);
	
	void deleteEmployee(int id);
	Page<EmployeeModel> findPaginated(int pageNo,int pageSize);
}
