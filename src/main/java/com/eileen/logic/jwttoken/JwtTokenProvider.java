package com.eileen.logic.jwttoken;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Base64;
import java.util.List;
//
//@Component
//public class JwtTokenProvider {
//    @Value("${{security.jwt.token.secret-key:secret}")
//    private String secretKey = "secret";
//
//    @Value("${security.jwt.token.expire-length:3600000}")
//    private long validityInMilliseconds = 3600000;
//
//    @Autowired
//    private UserDetailsService userDetailsService;

//    @PostConstruct
//    protected void init(){
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public String createToken(String username, List<String> roles) {
//        Claims claims =
//    }

//}
