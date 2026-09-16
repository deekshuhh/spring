package com.oracle.spring.service;

import com.oracle.spring.dto.EmployeeResponse;
import com.oracle.spring.model.Card;
import com.oracle.spring.model.Department;
import com.oracle.spring.model.Employee;
import com.oracle.spring.repository.CardRepo;
import com.oracle.spring.repository.DepartmentRepo;
import com.oracle.spring.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService {

    @Autowired
    DepartmentRepo deptRepo;

    private final EmployeeRepo repo;

    public EmployeeService(EmployeeRepo repo) {
        this.repo = repo;
    }

    public EmployeeResponse addEmployee(int age, String name) {
        Employee employee = new Employee();
        Card card = new Card();
        card.setActive(true);
        card.setNumber(101);

        employee.setAge(age);
        employee.setName(name);
        employee.setCard(card);

        card.setEmployee(employee);

        Department d1=deptRepo.findById(employee.getId()).get();
        employee.setDepartment(d1);

        return EmployeeResponse.from(repo.save(employee));
    }

    public List<Employee> getAllEmployee(Integer age, String name) {
        if(age == null && (name == null || name.isBlank()))
            return repo.findAll();
        if(age != null && name == null || name.isBlank()) {
            assert age != null;
            return repo.findAllByAge(age);
        }
        if(age == null)
            return repo.findByNameLike(name);
        return repo.findByAgeAndNameLike(age, name);
    }

    public EmployeeResponse updateEmployee(UUID id, int age) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        if(optionalEmployee.isEmpty())
            return  null;
        Employee employee = optionalEmployee.get();
        employee.setAge(age);
        return EmployeeResponse.from(repo.save(employee));
    }

    public void delete(UUID id) {
        repo.deleteById(id);
    }
}
