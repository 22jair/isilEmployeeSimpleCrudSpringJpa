package com.isilemployees.service;

import com.isilemployees.model.Employee;
import com.isilemployees.repository.EmployeeRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    final
    EmployeeRepository employeeRepository;


    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;

    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee createEmployee(Employee employee) throws Exception {

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> findByEmployeeId(Integer id) throws Exception {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) throws Exception {

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {

        employeeRepository.deleteById(id);

    }


}
