package com.oracle.spring.controller;

import com.oracle.spring.model.Movie;
import com.oracle.spring.model.Theatre;
import com.oracle.spring.repository.MovieRepo;
import com.oracle.spring.repository.TheatreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

    @Autowired
    MovieRepo movierepo;

    @Autowired
    TheatreRepo threpo;

    @GetMapping("/{name}")
    public Movie getMovie(@PathVariable("name") String name){
        System.out.println(name);
        return movierepo.findByName(name);
    }


    @PostMapping("/movie")
    public String addMovie(@RequestBody Movie movie){
        movierepo.save(movie);
        return "Added";
    }

    @PostMapping("/theatre")
    public String addTheater(@RequestBody Theatre theatre) {
        threpo.save(theatre);
        return "Added";
    }

    @PostMapping("/link")
    public String linMovieTheatre(@RequestParam UUID theatreId,@RequestParam UUID movieId){
        Movie m1=movierepo.findById(movieId).get();
        Theatre t1= threpo.findById(theatreId).get();

        List<Movie> movies=t1.getMovies();
        movies.add(m1);
        t1.setMovies(movies);
        threpo.save(t1);

        return "Linked";

    }
}
