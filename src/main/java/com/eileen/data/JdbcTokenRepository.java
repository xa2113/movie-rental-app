package com.eileen.data;

import com.eileen.logic.token.TokenInvalidException;
import com.eileen.logic.user.UserInvalidException;
import com.eileen.logic.token.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcTokenRepository implements TokenRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String getPassword(String email) {
        String query = "select password from user where email=?";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{email}, String.class);
        } catch (DataAccessException e){
            throw new UserInvalidException("User credential invalid",e);
        }
    }

    @Override
    public void saveTokenAndEmail(String token, String email) {
        String query = "replace into token (t_email, t_token) values (?,?);";
        jdbcTemplate.update(query,new Object[]{email,token});
    }

    @Override
    public Integer validateToken(String token) {
        String query = "select exists(select * from token where t_token =?)";
        try {
            return jdbcTemplate.queryForObject(query, new Object[]{token}, Integer.class);
        } catch (DataAccessException e){
            throw new TokenInvalidException("invalid token",e);
        }
    }
}
