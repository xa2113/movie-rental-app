package com.eileen.presentation.rest;

import com.eileen.logic.movie.Movie;
import com.eileen.logic.movie.MovieService;
import com.eileen.logic.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RestMovieController {

    @Autowired
    MovieService movieService;
    @Autowired
    private TokenService tokenService;

    @GetMapping("/movies")
    public List<Movie> getMovieInWeb(@RequestParam String token) {
        tokenService.validateToken(token);
        return movieService.getAllAvailableMovies();
    }

    @GetMapping("/actor")
    public String getActorWithMovie(@RequestParam String token, String movie) {
        tokenService.validateToken(token);
        return movieService.getActorWithMovie(movie);
    }

// Another way of handling exceptions without global exception handler
//    @GetMapping("/movies")
//    public ResponseEntity<List<Movie>> getMovieInWeb(@RequestParam String token) {
//        try {
//            tokenService.validateToken(token);
//        }catch(TokenInvalidException e){
//            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.FORBIDDEN);
//        }
//        return new ResponseEntity<>(movieService.getAllAvailableMovies(),HttpStatus.OK);
//    }
//
//    @GetMapping("/actor")
//    public ResponseEntity<String> getActorWithMovie(@RequestParam String token, String movie){
//        try {
//            tokenService.validateToken(token);
//        }catch(TokenInvalidException e){
//            return new ResponseEntity<>("invalid token", HttpStatus.FORBIDDEN);
//        }
//        return new ResponseEntity<>(movieService.getActorWithMovie(movie),HttpStatus.OK) ;
//    }

}