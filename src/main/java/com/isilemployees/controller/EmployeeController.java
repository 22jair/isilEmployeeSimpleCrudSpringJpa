package com.isilemployees.controller;

import com.isilemployees.form.EmployeeForm;
import com.isilemployees.model.Address;
import com.isilemployees.model.Employee;
import com.isilemployees.service.EmployeeService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
public class EmployeeController {

    final
    EmployeeService employeeService;



    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping(value = {"/","/index"})
    public String index(Model model) {

        model.addAttribute("employeeForm", new EmployeeForm());
        return "employee-add";
    }

    @GetMapping("/employee/list")
    public String employeeList(Model model) {


        model.addAttribute("employess", employeeService.findAll());
        return "employee-list";
    }


    @PostMapping("/employee/create")
    public String employeeCreate(Model model, EmployeeForm employeeForm) throws Exception {

        Employee currEmployee = new Employee();
        currEmployee = employeeForm.getEmployee();
        currEmployee.setAddress(employeeForm.getAddress());
        currEmployee.setState(1);
        employeeService.createEmployee(currEmployee);

        return "redirect:/employee/list";
    }

    @GetMapping("/employee/edit/{id}")
    public String employeeEdit(Model model, @PathVariable String id) throws Exception {

        Integer idEm = Integer.parseInt(id);
        Optional<Employee> employee = employeeService.findByEmployeeId(idEm);

        System.out.println(employee.get());

        model.addAttribute("employee", employee.get());
        return "employee-edit";
    }


    @PostMapping("/employee/update")
    public String employeeUpdate(Model model, Employee employee) throws Exception {

        employee.setState(1);
        employeeService.updateEmployee(employee);

        return "redirect:/employee/list";
    }

    @GetMapping("/employee/delete/{id}")
    public String employeeDelete(Model model, @PathVariable String id) throws Exception {

        Integer idEm = Integer.parseInt(id);
        employeeService.deleteEmployee(idEm);


        return "redirect:/employee/list";
    }



    @GetMapping("/employee/employee-api")
    public String employeeApi(Model model) {

        return "employee-api";
    }


}
