package com.eileen.presentation;

import com.eileen.logic.Customer;
import com.eileen.logic.TokenInvalidException;
import com.eileen.logic.movie.Movie;
import com.eileen.logic.movie.MovieService;
import com.eileen.logic.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestMovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/movies")
    public ResponseEntity<List<Movie>> getMovieInWeb(@RequestParam String token) {
        try {
            tokenService.validateToken(token);
        }catch(TokenInvalidException e){
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(movieService.getAllAvailableMovies(),HttpStatus.OK);
    }

    @GetMapping("/actor")
    public ResponseEntity<String> getActorWithMovie(@RequestParam String token, String movie){
        try {
            tokenService.validateToken(token);
        }catch(TokenInvalidException e){
            return new ResponseEntity<>("invalid token", HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity<>(movieService.getActorWithMovie(movie),HttpStatus.OK) ;
    }

}
