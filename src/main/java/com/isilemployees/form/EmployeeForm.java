package com.isilemployees.form;

import com.isilemployees.model.Address;
import com.isilemployees.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmployeeForm {

    private Employee employee;
    private Address address;



}
