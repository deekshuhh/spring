package com.oracle.spring.repository;

import com.oracle.spring.model.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TheatreRepo extends JpaRepository<Theatre, UUID> {

}
