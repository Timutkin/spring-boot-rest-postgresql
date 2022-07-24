package com.timukin.education.crudoperationsrestpostgesql.service;

import com.timukin.education.crudoperationsrestpostgesql.exception_handling.InvalidEmailException;
import com.timukin.education.crudoperationsrestpostgesql.exception_handling.UserAlreadyExistException;
import com.timukin.education.crudoperationsrestpostgesql.model.Employee;
import com.timukin.education.crudoperationsrestpostgesql.exception_handling.NoSuchEmployeeException;
import com.timukin.education.crudoperationsrestpostgesql.repository.EmployeeRepository;
import com.timukin.education.crudoperationsrestpostgesql.validation.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Implementation of {@link EmployeeService} interface.
 *
 *  @author Timofey Utkin
 *  @version 1.0
 */
@Service
public class IEmployeeService implements EmployeeService{

    private final EmailValidator emailValidator;
    private final EmployeeRepository employeeRepository;

    /**
     * Instantiates a new Employee service.
     *
     * @param employeeRepository the employee repository
     */
    public IEmployeeService(EmployeeRepository employeeRepository, EmailValidator emailValidator) {
        this.employeeRepository = employeeRepository;
        this.emailValidator = emailValidator;
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
        allEmailValidation(emailValidator, employee);
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        allEmailValidation(emailValidator, employee);
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

    @Override
    public List<Employee> getSortedListOfEmployees() {
        return employeeRepository
                .findAll()
                .stream()
                .sorted((o1, o2) -> (int) (o1.getId() - o2.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean emailExists(String email) {
        return employeeRepository.findByEmail(email) != null;
    }

    @Override
    public void allEmailValidation(EmailValidator emailValidator, Employee employee) {
        if(!emailValidator.validateEmail(employee.getEmail())){
            throw new InvalidEmailException("Email is not correct");
        }
        if(emailExists(employee.getEmail())){
            throw new UserAlreadyExistException("User with email " +employee.getEmail() + " already exist" );
        }
    }

}
