package com.example.springbootjwt.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * @author CJW
 * @since 2023/9/19
 */
public class JwtUtils {
    /**
     * 签名密钥
     */
    private static String signKey = "chenjiawei";
    /**
     * 过期时间
     */
    private static Long expire = 1 * 60 * 1000L;

    /**
     * 获取一个jwt
     *
     * @param claim jwt需要携带的信息
     * @return jwt
     */
    public static String generateJwt(Map<String, Object> claims) {
        String jwt = Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, signKey)
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .compact();
        return jwt;
    }

    /**
     * 解析jwt令牌
     *
     * @param jwt jwt
     * @return jwt所携带的信息
     */
    public static Claims parseJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
