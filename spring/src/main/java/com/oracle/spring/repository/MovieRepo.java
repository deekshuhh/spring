package com.oracle.spring.repository;

import com.oracle.spring.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface MovieRepo extends JpaRepository<Movie, UUID> {
    @Query("Select m from Movie m where m.name= :name")
    Movie findByName(@Param("name") String name);
}
