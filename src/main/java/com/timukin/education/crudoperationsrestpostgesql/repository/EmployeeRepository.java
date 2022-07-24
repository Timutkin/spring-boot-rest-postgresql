package com.timukin.education.crudoperationsrestpostgesql.repository;

import com.timukin.education.crudoperationsrestpostgesql.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
