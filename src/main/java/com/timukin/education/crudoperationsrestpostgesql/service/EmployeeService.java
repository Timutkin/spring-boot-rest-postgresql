package com.timukin.education.crudoperationsrestpostgesql.service;

import com.timukin.education.crudoperationsrestpostgesql.model.Employee;
import com.timukin.education.crudoperationsrestpostgesql.validation.EmailValidator;

import java.util.List;

/**
 * Service class for {@link Employee}
 *
 *  @author Timofey Utkin
 *  @version 1.0
 */
public interface EmployeeService {
    /**
     * Gets all employees.
     *
     * @return the all employees
     */
    List<Employee> getAllEmployees();

    /**
     * Gets employee.
     *
     * @param id the id
     * @return the employee
     */
    Employee getEmployee(long id);

    /**
     * Add new employee.
     *
     * @param employee the employee
     */
    void addNewEmployee(Employee employee);

    /**
     * Update employee.
     *
     * @param employee the employee
     */
    void updateEmployee(Employee employee);

    /**
     * Delete employee by id.
     *
     * @param id the id
     */
    void deleteEmployeeById(Long id);

    /**
     * Gets sorted list of employees.
     *
     * @return the sorted list of employees
     */
    List<Employee> getSortedListOfEmployees();

    /**
     * Email exists in DB boolean.
     *
     * @param email the email
     * @return the boolean
     */
    boolean emailExists(String email);

    /**
     * All email validation.
     *
     * @param emailValidator the email validator
     * @param employee       the employee
     */
    void allEmailValidation(EmailValidator emailValidator, Employee employee);
}
