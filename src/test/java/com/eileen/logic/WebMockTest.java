package com.eileen.logic;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.eileen.logic.movie.Movie;
import com.eileen.logic.movie.MovieService;
import com.eileen.presentation.rest.RestMovieController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(RestMovieController.class)
public class WebMockTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MovieService movieService;

    @Test
    public void allShouldReturnAllMoviesFromService() throws Exception{
        List<Movie> mockMovieList = movieService.getAllAvailableMovies();
        Movie mockMovie = new Movie();
        mockMovie.setTitle("Mock movie");
        mockMovieList.add(mockMovie);;

        when(movieService.getAllAvailableMovies()).thenReturn(mockMovieList);
        this.mockMvc.perform(get("/movies")).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString("Mock movie")));

    }
}
