package com.eileen.presentation.rest;

import com.eileen.logic.movie.MovieService;
import com.eileen.logic.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class RestTokenController {

    @Autowired
    private TokenService tokenService;
    @Autowired
    private MovieService movieService;

    @PostMapping("/api/login")
    public String getToken(@RequestBody LoginRequest loginRequest) {
        String token = tokenService.generateUserToken(loginRequest.getEmail(), loginRequest.getPassword());
        tokenService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
        return token;
    }


//    @PostMapping("/api/login")
//    public ResponseEntity<String> getToken(@RequestBody LoginRequest loginRequest) {
//        String token = tokenService.generateUserToken(loginRequest.getEmail(), loginRequest.getPassword());
//        try {
//            tokenService.validateUser(loginRequest.getEmail(), loginRequest.getPassword());
//        } catch (UserInvalidException e){
//            return new ResponseEntity<>("User credential invalid",HttpStatus.UNAUTHORIZED);
//        }
//        return new ResponseEntity<>(token, HttpStatus.OK);
//    }

}
