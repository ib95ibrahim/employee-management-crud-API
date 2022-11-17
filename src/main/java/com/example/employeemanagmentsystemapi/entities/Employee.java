package com.example.employeemanagmentsystemapi.entities;

import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator ="employee_generator" )
    @SequenceGenerator(name = "employee_generator",sequenceName = "employee_seq_name",allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String fullName ;

    @Column(nullable = false)
    private String email;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "employee")
    private List<Job> jobs;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Employee employee = (Employee) o;
        return id != null && Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
