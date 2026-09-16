package com.oracle.spring.controller;

import com.oracle.spring.dto.DptEmpDto;
import com.oracle.spring.model.Department;
import com.oracle.spring.repository.DepartmentRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/depart")
public class DptController {
    private DepartmentRepo repo;

    public DptController(DepartmentRepo repo) {
        this.repo = repo;
    }

    @PostMapping
    public ResponseEntity<Department> createDepart(@RequestBody DptEmpDto req){
        Department dpt =new Department();
        dpt.setBlockNo(req.getBlock());
        dpt.setDepartmentName(req.getDptName());
        dpt.setLocation(req.getLocation());

        return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(dpt));
    }
}
