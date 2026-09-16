package com.oracle.springdb.Services;

import com.oracle.springdb.Dto.EmployeeRequest;
import com.oracle.springdb.Model.Card;
import com.oracle.springdb.Model.Employee;
import com.oracle.springdb.Repositories.CardRepo;
import com.oracle.springdb.Repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo repo;

    @Autowired
    CardRepo cardRepo;

    public Employee addEmployee(EmployeeRequest employee) {
        Card c1=new Card();
        c1.setMonth(employee.getMonth());
        c1.setActive(true);
        Employee e1=new Employee();
        e1.setCard(c1);
        e1.setAge(employee.getAge());
        e1.setName(employee.getName());
        c1.setEmployee(e1);
        Employee savedEmployee = repo.save(e1);

        return e1;
//        return "ADDED";
    }

    public List<Employee> getAll() {
        return repo.findAll();
    }

    public Optional<Employee> getEmployee(int id) {
        return repo.findById(id);
    }

    public Employee changeAge(Integer id,Integer age){
        Employee e=repo.findById(id).get();
        e.setAge(age);
        return repo.save(e);
    }

    public String DelEmp(Integer id){
      repo.deleteById(id);
      return "Deleted";
    }
}
