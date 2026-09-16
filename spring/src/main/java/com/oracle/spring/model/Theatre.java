package com.oracle.spring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String city;

    private String name;

    @ManyToMany
    @JoinTable(
            name="movie_theatre",
            joinColumns = @JoinColumn(name="theatre_id"),
            inverseJoinColumns= @JoinColumn(name="movie_id")
    )
    private List<Movie> movies;
}
