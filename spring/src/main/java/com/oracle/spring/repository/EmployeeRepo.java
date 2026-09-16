package com.oracle.spring.repository;

import com.oracle.spring.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, UUID> {

    List<Employee> findAllByAge(int age);

    List<Employee> findByNameLike(String name);

    List<Employee> findByAgeAndNameLike(Integer age, String name);
}
