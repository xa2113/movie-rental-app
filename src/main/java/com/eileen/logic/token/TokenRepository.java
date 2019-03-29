package com.eileen.logic.token;

public interface TokenRepository {

    String getPassword(String username);

    void saveTokenAndEmail(String token, String email);

    Integer validateToken(String token);
}
