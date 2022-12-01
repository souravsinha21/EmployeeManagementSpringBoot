package com.capgemini.employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.capgemini.employee.model.EmployeeModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.capgemini.employee.repo.EmployeeRepoInterface;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private EmployeeRepoInterface employeeRepoObj;

	@Override
	public List<EmployeeModel> getAllEmployee() 
	{
		return employeeRepoObj.findAll();
	
	}

	@Override
	public EmployeeModel getSingleEmployee(int id) 
	{
		return employeeRepoObj.findById(id).get();
	}

	@Override
	public EmployeeModel saveEmployee(EmployeeModel obj)
	{
		return employeeRepoObj.save(obj);
	}

	@Override
	public EmployeeModel updateEmployee(EmployeeModel obj)
	{
		return employeeRepoObj.save(obj);
	}

	@Override
	public void deleteEmployee(int id) 
	{
		employeeRepoObj.deleteById(id);
	}

	@Override
	public Page<EmployeeModel> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1,pageSize);
		return this.employeeRepoObj.findAll(pageable);
	}
}
