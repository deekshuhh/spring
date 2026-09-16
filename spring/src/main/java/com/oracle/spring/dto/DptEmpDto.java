package com.oracle.spring.dto;

import com.oracle.spring.model.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DptEmpDto {
    String location;
    int block;
    Department.Name DptName;
    Integer id;

}
