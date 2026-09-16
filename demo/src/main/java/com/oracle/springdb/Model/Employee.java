package com.oracle.springdb.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name ="empl",nullable=false)
    private String name;

    private Integer age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Card card;

}
