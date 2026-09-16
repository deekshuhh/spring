package com.oracle.spring.dto;

import com.oracle.spring.model.Card;
import com.oracle.spring.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponse {
    String name;
    Card card;
    int age;

    public static EmployeeResponse from(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setAge(employee.getAge());
        employeeResponse.setName(employee.getName());
        employeeResponse.setCard(employee.getCard());
        return employeeResponse;
    }
}
