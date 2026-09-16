package com.oracle.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String location;
    private int blockNo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Name departmentName;

    public enum Name {
        HR,
        PAYROLL,
        DEVELOPERS,
        LEGAL
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id", orphanRemoval = true)
    private List<Employee> employeeList;
}
