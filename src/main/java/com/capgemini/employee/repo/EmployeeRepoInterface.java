package com.capgemini.employee.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.employee.model.EmployeeModel;

public interface EmployeeRepoInterface extends JpaRepository<EmployeeModel, Integer>  {

}
