package com.example.employeemanagmentsystemapi.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "job_sequence")
    @SequenceGenerator(name = "job_sequence",sequenceName = "job_sequence_name",allocationSize = 1)
    private Long id;

    @Column
    private String jobName;

    @ManyToOne
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Job job = (Job) o;
        return id != null && Objects.equals(id, job.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
