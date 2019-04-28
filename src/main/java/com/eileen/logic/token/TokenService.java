package com.eileen.logic.token;

import com.eileen.logic.user.UserInvalidException;
import com.eileen.logic.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("tokenService")
public class TokenService {

    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private TokenRepository tokenRepository;
    private UserRepository userRepository;

    @Autowired
    public TokenService(BCryptPasswordEncoder bCryptPasswordEncoder, TokenRepository tokenRepository, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
    }

    public String generateUserToken(String email, String password) {
        Token token = new Token();
        token.setToken(bCryptPasswordEncoder.encode(email));
        saveTokenAndEmail(token.getToken(), email);
        return token.getToken();
    }

    public boolean validateUser(String email, String password) {
        boolean validated = false;
        String encryptedPassword = tokenRepository.getPassword(email);
        if (!bCryptPasswordEncoder.matches(password, encryptedPassword)) {
            throw new UserInvalidException("user credential is wrong!");
        } else {
            validated = true;
        }
        return validated;
    }

    public void saveTokenAndEmail(String token, String email) {
        tokenRepository.saveTokenAndEmail(token, email);
    }

    public void validateToken(String token) {
        Integer isTokenValid = tokenRepository.validateToken(token);
        if(isTokenValid != 1){
            throw new TokenInvalidException("token credential is wrong!");
        }
    }
}
