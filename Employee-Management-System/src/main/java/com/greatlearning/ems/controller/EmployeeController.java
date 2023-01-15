package com.greatlearning.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.ems.entity.Employee;
import com.greatlearning.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@GetMapping("/employees")
	public String get(Model model) {
		List<Employee> employees = employeeService.getAllEmployees();
		model.addAttribute("Employee", employees);
		return "home-page";
	}
	@GetMapping("/employees/new")
	public String getEmployeeDetails(Model model) {
		Employee employee = new Employee();
		model.addAttribute("EmployeeDetails", employee);
		return "create-employee";
	}
	@PostMapping("/employees/save")
	public String saveEmployee(@ModelAttribute("EmployeeDetails") Employee employee) {
		employeeService.saveEmployee(employee);
		return "save-message";
	}
	@GetMapping("/employees/edit/{id}")
	public String updateEmployee(@PathVariable(value="id") long id, Model model) {
		Employee employee = employeeService.getEmployeeById(id);
		model.addAttribute("EmployeeDetails", employee);
		return "update-employee";
	}
	@GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeService.deleteEmployeeById(id);
        return "delete-message";
    }
	
}
