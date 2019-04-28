package com.eileen.security;

import com.eileen.logic.token.TokenService;
import com.eileen.logic.user.User;
import com.eileen.logic.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class WebAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenService tokenService;


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        User user = userService.findUserByEmail(authentication.getName());

        if(user == null){
            throw new RuntimeException("User not found.");
        }

        //todo note here: name vs. email
        if(tokenService.validateUser(user.getEmail(),user.getPassword())){

        }

        return null;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return false;
    }
}
