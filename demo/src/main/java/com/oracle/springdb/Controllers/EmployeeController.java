package com.oracle.springdb.Controllers;

import com.oracle.springdb.Dto.EmployeeRequest;
import com.oracle.springdb.Model.Employee;
import com.oracle.springdb.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @PostMapping("/employee")
    public ResponseEntity<String> addEmployee(@RequestBody EmployeeRequest employee){
        Employee employee1 =  service.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.OK).body(employee1.toString());
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployee(){
        return service.getAll();
    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Integer id){
        System.out.println("the id is :" + id);
        return service.getEmployee(id);
    }

    @PatchMapping("/employee/{id}")
    public Employee changeAge(@PathVariable("id") Integer id, @RequestParam Integer age){
        return service.changeAge(id,age);
    }

    @DeleteMapping("employee/{id}")
    public String deleteEmp(@PathVariable Integer id) {
        return service.DelEmp(id);
    }
}
