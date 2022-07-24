package com.timukin.education.crudoperationsrestpostgesql.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * The type Employee.
 *
 * @author Timofey Utkin
 * @version 1.0
 */
@Entity
@Table(schema = "main", name = "employees")
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;
}
