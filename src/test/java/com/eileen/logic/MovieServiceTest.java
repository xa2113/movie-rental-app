package com.eileen.logic;


import com.eileen.logic.movie.Movie;
import com.eileen.logic.movie.MovieRepository;
import com.eileen.logic.movie.MovieService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ActiveProfiles("Test")
public class MovieServiceTest {

    private static final List<Movie> EXAMPLE_MOVIE_TITLE = new LinkedList<>();
    private MovieRepository movieRepositoryMock;
    private MovieService movieService;

    @Before
    public void setUp() throws Exception {
        movieRepositoryMock = mock(MovieRepository.class);
        movieService = new MovieService(movieRepositoryMock);
    }

    @Test
    public void whenGettingAllAvailableMovies_shouldReturnAListOfMovies() {

        List<Movie> exampleMovieList = movieService.getAllAvailableMovies();
        Movie titanic = new Movie();
        titanic.setTitle("Titanic");
        exampleMovieList.add(titanic);

        when(movieRepositoryMock.getAllAvailableMovies()).thenReturn(exampleMovieList);

        assertThat(movieService.getAllAvailableMovies()).contains(titanic);
    }

    @Test
    public void whenRentingAMovie_shouldRentAMoviesWithSameName() {
        String testCustomer = "TEST_CUSTOMER";
        String rentedMovieTitle = "TITANIC";
        doNothing().when(movieRepositoryMock).rentAMovie(testCustomer,rentedMovieTitle);

        movieService.rentAMovie(testCustomer,rentedMovieTitle);
    }

//
//    @Test
//    public void returnAMovie_shouldReturn() {
//        String returningCustomer = "TEST_RETURNING_CUSTOMER";
//        String returnedMovieTitle = "MOVIE_TO_RETURN";
//        int cost = 1;
//       //when(movieRepositoryMock.returnAMovie(returningCustomer,returnedMovieTitle,cost).;
//
//        movieService.returnAMovie(returningCustomer,returnedMovieTitle);
//
//    }

    @Test
    public void whenCalculateCost_shouldReturnCost() {

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate startDate = LocalDate.parse("03/11/2019", dateFormat);
        LocalDate endDate = LocalDate.parse("03/12/2019", dateFormat);

       // assertThat(movieService.calculateCost(startDate, endDate)).isEqualTo(2);
    }
}