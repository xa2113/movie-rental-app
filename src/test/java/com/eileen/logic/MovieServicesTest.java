package com.eileen.logic;

import com.eileen.Movie;
import com.eileen.MovieRepository;
import com.eileen.MovieServices;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;


public class MovieServicesTest {

    private static final List<Movie> EXAMPLE_MOVIE_TITLE = new LinkedList<>();
    private MovieRepository movieRepositoryMock;
    private MovieServices movieServices;

    @Before
    public void setUp() throws Exception {
        movieRepositoryMock = mock(MovieRepository.class);
        movieServices = new MovieServices(movieRepositoryMock);
    }

    @Test
    public void whenGettingAllAvailableMovies_shouldReturnAListOfMovies() {

        List<Movie> exampleMovieList = movieServices.getAllAvailableMovies();
        Movie titanic = new Movie();
        titanic.setTitle("Titanic");
        exampleMovieList.add(titanic);

        when(movieRepositoryMock.getAllAvailableMovies()).thenReturn(exampleMovieList);

        assertThat(movieServices.getAllAvailableMovies()).contains(titanic);
    }

    @Test
    public void whenRentingAMovie_shouldRentAMoviesWithSameName() {
        String testCustomer = "TEST_CUSTOMER";
        String rentedMovieTitle = "TITANIC";
        doNothing().when(movieRepositoryMock).rentAMovie(testCustomer,rentedMovieTitle);

        movieServices.rentAMovie(testCustomer,rentedMovieTitle);
    }


    @Test
    public void returnAMovie_shouldReturn() {
        String returningCustomer = "TEST_RETURNING_CUSTOMER";
        String returnedMovieTitle = "MOVIE_TO_RETURN";
        int cost = 1;
       when(movieRepositoryMock.returnAMovie(returningCustomer,returnedMovieTitle,cost).;

        movieServices.returnAMovie(returningCustomer,returnedMovieTitle);

    }

    @Test
    public void whenCalculateCost_shouldReturnCost() {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate startDate = LocalDate.parse("03/11/2019", dateFormat);
        LocalDate endDate = LocalDate.parse("03/12/2019", dateFormat);

        assertThat(movieServices.calculateCost(startDate, endDate)).isEqualTo(2);
    }
}