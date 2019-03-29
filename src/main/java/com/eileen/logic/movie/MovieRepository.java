package com.eileen.logic.movie;

import com.eileen.logic.Customer;

import java.time.LocalDate;
import java.util.List;

public interface MovieRepository {

    List<Movie> getAllAvailableMovies();

    void rentAMovie(String customer, String movie);

    void returnAMovie(String customer, String movie, int cost);

    LocalDate getRentalDateFromMovieTitle(String movieTitle);

    String getActorWithMovie(String movie);

    Customer createNewCustomer(Customer customer);

    List<Movie> showAllMoviesToReturn(String customerName);

    List<Movie> showResultFromMovieTitle(String title);
}
