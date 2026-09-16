package com.oracle.spring.dto;

import com.oracle.spring.model.Employee;

public class EmployeeResponseNoCard extends EmployeeResponse {

    public static EmployeeResponseNoCard from(Employee employee) {
        EmployeeResponseNoCard response = new EmployeeResponseNoCard();
        response.setAge(employee.getAge());
        response.setName(employee.getName());
        return response;
    }
}
