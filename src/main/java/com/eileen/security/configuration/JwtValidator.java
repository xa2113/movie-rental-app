package com.eileen.security.configuration;

import com.eileen.security.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {
    private String secretKey = "thisisasecretkey";

    public JwtUser validate(String token) {

        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secretKey)
                    .parseClaimsJws(token)
                    .getBody();

            jwtUser = new JwtUser();
            jwtUser.setUsername(body.getSubject());
            jwtUser.setId(Long.parseLong((String) body.get("userId")));
            jwtUser.setRole((String) body.get("role"));
        } catch(Exception e){
            e.printStackTrace();
        }
        return jwtUser;
    }

}
