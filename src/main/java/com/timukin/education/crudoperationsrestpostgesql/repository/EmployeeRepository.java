package com.timukin.education.crudoperationsrestpostgesql.repository;

import com.timukin.education.crudoperationsrestpostgesql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Employee repository.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /**
     * Find by email employee.
     *
     * @param email the email
     * @return the employee
     */
    Employee findByEmail(String email);
}
