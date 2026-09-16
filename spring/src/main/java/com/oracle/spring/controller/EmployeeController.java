package com.oracle.spring.controller;

import com.oracle.spring.dto.EmployeeRequest;
import com.oracle.spring.dto.EmployeeResponse;
import com.oracle.spring.dto.EmployeeResponseNoCard;
import com.oracle.spring.model.Employee;
import com.oracle.spring.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping()
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest request) {
        EmployeeResponse returnEmployee = employeeService.addEmployee(request.getAge(), request.getName());
        return ResponseEntity.status(HttpStatus.CREATED).body(
                returnEmployee
        );
    }

    @GetMapping()
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(@RequestParam(required = false) Integer age, @RequestParam(required = false) String name, @RequestParam(required = true) boolean card)
    {
        List<Employee> employees =  employeeService.getAllEmployee(age, name);
        List<EmployeeResponse> responses = new ArrayList<>();
        if(card) {
            for(Employee emp : employees)
                responses.add(EmployeeResponse.from(emp));
        } else {
            for(Employee emp : employees)
                responses.add(EmployeeResponseNoCard.from(emp));
        }
        return  ResponseEntity.status(HttpStatus.OK).body(responses);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EmployeeResponse> updateEmployee(@PathVariable UUID id, @RequestParam int age) {
        return ResponseEntity.status(HttpStatus.OK).body(
                employeeService.updateEmployee(id, age)
        );
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> delete(@PathVariable UUID id) {
        employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted successfully");
    }
}
