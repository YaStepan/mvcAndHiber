package com.zaurtregulov.spring.mvc_hibernate_aop.services;


import com.zaurtregulov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployees();

    public void saveEmployee(Employee e);
    public Employee getEmployeeById(int id);
}
