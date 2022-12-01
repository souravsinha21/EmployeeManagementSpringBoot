package com.capgemini.employee.controller;

import com.capgemini.employee.dao.EmployeeService;
import com.capgemini.employee.model.EmployeeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    @Autowired
    private EmployeeService employeeobj;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("/Emp/{Id}")
    public EmployeeModel getSingleEmployee(@PathVariable int Id)
    {
        return employeeobj.getSingleEmployee(Id);
    }

}
