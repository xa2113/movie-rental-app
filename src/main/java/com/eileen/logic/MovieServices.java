package com.eileen.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Service
public class MovieServices {

    public static final int COST_PER_DAY = 1;
    private MovieRepository movieRepository;

    @Autowired
    public MovieServices(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> getAllAvailableMovies() {
        return movieRepository.getAllAvailableMovies();
    }

    public void rentAMovie(String customerName, String movieTitle){
        movieRepository.rentAMovie(customerName,movieTitle);
    }

    public void returnAMovie(String customerName, String movieTitle){
        LocalDate startDate = movieRepository.getRentalDateFromMovieTitle(movieTitle);
        LocalDate endDate = LocalDate.now();
        int cost = calculateCost(startDate, endDate);
        movieRepository.returnAMovie(customerName,movieTitle,cost);
    }

    private int calculateCost(LocalDate startDate, LocalDate endDate) {
        return (int)DAYS.between(startDate,endDate) * COST_PER_DAY + 1;
    }

    public String getActorWithMovie(String movie) {
        return movieRepository.getActorWithMovie(movie);
    }

    public Customer createNewCustomer(Customer customer) {
        return movieRepository.createNewCustomer(customer);
    }

    public List<Movie> showAllMoviesToReturn(String customerName){
        return movieRepository.showAllMoviesToReturn(customerName);
    }
}
