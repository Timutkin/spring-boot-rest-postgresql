package com.timukin.education.crudoperationsrestpostgesql.controller;

import com.timukin.education.crudoperationsrestpostgesql.model.Employee;
import com.timukin.education.crudoperationsrestpostgesql.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for {@link Employee}
 *
 * @author Timofey Utkin
 * @version 1.0
 */
@RestController
@RequestMapping("/api")
public class EmployeeController {

    private final EmployeeService employeeService;

    /**
     * Instantiates a new Employee controller.
     *
     * @param employeeService the employee service
     */
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    /**
     * Get all employees list.
     *
     * @return the list
     */
    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * Get sorted list of employees list.
     *
     * @return the list
     */
    @GetMapping("/employeesSort")
    public List<Employee> getSortedListOfEmployees(){
        return employeeService.getSortedListOfEmployees();
    }

    /**
     * Get employee employee.
     *
     * @param id the id
     * @return the employee
     */
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeService.getEmployee(id);
    }

    /**
     * Update employee employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return employee;
    }

    /**
     * Add employee employee.
     *
     * @param employee the employee
     * @return the employee
     */
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
        return employee;
    }

    /**
     * Delete employee by id.
     *
     * @param id the id
     */
    @DeleteMapping("/employees/{id}")
    public void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

}
