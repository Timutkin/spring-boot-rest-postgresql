package com.timukin.education.crudoperationsrestpostgesql.service;

import com.timukin.education.crudoperationsrestpostgesql.entity.Employee;
import com.timukin.education.crudoperationsrestpostgesql.exception_handling.NoSuchEmployeeException;
import com.timukin.education.crudoperationsrestpostgesql.repository.EmployeeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IEmployeeService implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public IEmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isEmpty()){
            throw new NoSuchEmployeeException("Employee with ID = "+id +" not found");
        }
        return employee.get();
    }
    @Override
    public void addNewEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        try {
            employeeRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new NoSuchEmployeeException("Employee with ID = "+id +" not found");
        }

    }

}
