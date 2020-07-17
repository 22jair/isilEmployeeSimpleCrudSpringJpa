package com.isilemployees.service;

import com.isilemployees.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public List<Employee> findAll();

    public Employee createEmployee(Employee employee) throws Exception;

    public Optional<Employee> findByEmployeeId(Integer id) throws Exception;

    public Employee updateEmployee(Employee employee) throws Exception;

    public void deleteEmployee(Integer id);

}
