package com.orienteed.orienteed.management.system.Service;

import com.fasterxml.jackson.core.ErrorReportConfiguration;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


@Service
public class JWTService {
    private String secretKey = "";
    //constructor to generate keys
    public JWTService() {
        try{
            KeyGenerator keyGen = KeyGenerator.getInstance("hmacSHA256");
            SecretKey sk = keyGen.generateKey();
            secretKey = Base64.getEncoder().encodeToString(sk.getEncoded());

        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException(e);

        }

    }

    public  String generateTokent(String username) {

        Map<String, Object> claims = new HashMap<String, Object>();
        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date (System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() *1000 *60 * 30))
                .and()
                .signWith(getKey())
                .compact();

    }

    private  Key getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        //hmacShaKeyFor(keyBytes) take only bytes so we needed the decoding step
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
