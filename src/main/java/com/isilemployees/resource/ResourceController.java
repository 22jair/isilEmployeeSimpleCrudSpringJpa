package com.isilemployees.resource;

import com.isilemployees.model.Employee;
import com.isilemployees.repository.EmployeeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ResourceController {

    final
    EmployeeRepository employeeRepository;



    public ResourceController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping("/employee")
    public ResponseEntity employess(Model model) {


        List<Employee> employees = employeeRepository.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity(employees, HttpStatus.OK);

    }

    @GetMapping("/employee/{id}")
    public ResponseEntity employesById(Model model, @PathVariable Integer id) {


        Optional<Employee> currentEmployeeOptional = employeeRepository.findById(id);
        if (!currentEmployeeOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }


        return new ResponseEntity(currentEmployeeOptional, HttpStatus.OK);

    }

    @CrossOrigin
    @PostMapping("/employee")
    public ResponseEntity create(@RequestBody Employee employee) throws Exception {

        employeeRepository.save(employee);

        return new ResponseEntity(employee, HttpStatus.CREATED);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Employee employee) throws Exception {

        Optional<Employee> currentEmployeeOptional = employeeRepository.findById(id);
        if (!currentEmployeeOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        Employee currentEmployee = currentEmployeeOptional.get();
        currentEmployee.setName(employee.getName());
        currentEmployee.setSurnames(employee.getSurnames());
        currentEmployee.setAddress(employee.getAddress());
        currentEmployee.setDni(employee.getDni());
        currentEmployee.setState(employee.getState());
        currentEmployee.setCellphone(employee.getCellphone());

        employeeRepository.save(currentEmployee);

        return new ResponseEntity(currentEmployee, HttpStatus.CREATED);
    }

    //Delete
    @DeleteMapping("/employee/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Employee> currentEmployeeOptional = employeeRepository.findById(id);
        if (!currentEmployeeOptional.isPresent()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        Employee currentEmployee = currentEmployeeOptional.get();
        employeeRepository.delete(currentEmployee);
        return new ResponseEntity(HttpStatus.OK);
    }

}
