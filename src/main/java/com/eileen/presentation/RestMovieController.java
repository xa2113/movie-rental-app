package com.eileen.presentation;

import com.eileen.logic.Customer;
import com.eileen.logic.Movie;
import com.eileen.logic.MovieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestMovieController {

    @Autowired
    MovieServices movieServices;

    @RequestMapping("/movies")
    public List<Movie> getMovieInWeb(){
        return movieServices.getAllAvailableMovies();
    }

    @RequestMapping("/actor")
    public String getActorWithMovie(@RequestBody String movie){
        return movieServices.getActorWithMovie(movie);
    }

    @PostMapping("/createCustomer")
    public Customer createNewCustomer(@RequestBody Customer customer){
        return movieServices.createNewCustomer(customer);
    }

}
