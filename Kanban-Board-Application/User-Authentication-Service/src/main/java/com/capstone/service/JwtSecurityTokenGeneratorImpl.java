package com.capstone.service;

import com.capstone.model.User;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtSecurityTokenGeneratorImpl implements SecurityTokenGenerator{

    @Override
    public Map<String, String> generateToken(User user) {
        //multiple claims for a taken - 3 types - registered,public and private
        String jsonWebToken ;
        JwtBuilder jwtBuilder = Jwts.builder();
        jsonWebToken = jwtBuilder.setSubject(user.getEmail()).setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256,"secret").compact();

        Map<String,String> tokenMap=new HashMap<>();
        tokenMap.put("token",jsonWebToken);
        tokenMap.put("message","User Successfully LoggedIn");
        return tokenMap;
    }
}
