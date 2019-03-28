package com.eileen.logic;

import com.eileen.logic.movie.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private MovieRepository movieRepository;

    @Autowired
    public TokenService(BCryptPasswordEncoder bCryptPasswordEncoder, MovieRepository movieRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.movieRepository = movieRepository;
    }

    public String generateUserToken(String username) {
        Token token = new Token();
        token.setToken(bCryptPasswordEncoder.encode(username));
        return token.getToken();
    }

    public void saveToken(String token) {

    }
}
