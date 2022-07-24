package com.timukin.education.crudoperationsrestpostgesql.service;

import com.timukin.education.crudoperationsrestpostgesql.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getEmployee(long id);
    void addNewEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployeeById(Long id);
}
