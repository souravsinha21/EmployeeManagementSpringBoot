package com.capgemini.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.capgemini.employee.dao.EmployeeService;
import com.capgemini.employee.model.EmployeeModel;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeObj;
	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/")
	public String index(Model model)
	{
		return findPaginated(1,model);
	}

	@PostMapping("/saveEmployee")
	public String saveEmployee1(@ModelAttribute("employee") EmployeeModel employee){
		saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping("/DeleteEmployee/{Id}")
	public String deleteEmployee(@PathVariable int Id)
	{
		employeeObj.deleteEmployee(Id);
		return "redirect:/";
	}

	@PostMapping("/updateEmployee/{Id}")
	public String updateEmployee(@ModelAttribute("updateEmployee") EmployeeModel obj, @PathVariable int Id)
	{
		obj.setEmployeeId(Id);
		employeeObj.updateEmployee(obj);
		return "redirect:/";
	}

	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable(value="pageNo")int pageNo,Model model){
		int pageSize=5;
		Page<EmployeeModel> page = employeeObj.findPaginated(pageNo,pageSize);
		List<EmployeeModel> listEmp = page.getContent();

		model.addAttribute("employeeList",listEmp);
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());

		EmployeeModel employee = new EmployeeModel();
		EmployeeModel UpdateEmployee = new EmployeeModel();
		model.addAttribute("employee",employee);
		model.addAttribute("updateEmployee",UpdateEmployee);

		return "index";
	}



	@GetMapping("/Employee")
	public List<EmployeeModel> getAllEmployee()
	{
		return employeeObj.getAllEmployee();
	}
	
	@GetMapping("/Employee/{Id}")
	public EmployeeModel getSingleEmployee(@PathVariable int Id)
	{
		return employeeObj.getSingleEmployee(Id);
	}
	
	@PostMapping("/Employee")
	public EmployeeModel saveEmployee(@RequestBody EmployeeModel obj)
	{
		return employeeObj.saveEmployee(obj);
	}


}
