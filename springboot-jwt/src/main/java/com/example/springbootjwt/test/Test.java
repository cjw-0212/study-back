package com.example.springbootjwt.test;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CJW
 * @since 2023/9/19
 */
public class Test {
    public static void main(String[] args) {
        //getJwt();
        verifyJwt("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoi6ZmI5L2z54KcIiwiZXhwIjoxNjk1MTM4MDE0LCJpZCI6MX0.a-BT8lhrmzRGDvgP_h54ViGpbxfLfm0YALaP3vW7hsk");
    }

    /**
     * 获取一个jwt
     */
    public static void getJwt() {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("id", 1);
        claims.put("name", "陈佳炜");
        String jwt = Jwts.builder()
                //附带信息
                .setClaims(claims)
                //签名算法和密钥
                .signWith(SignatureAlgorithm.HS256, "chenjiawei")
                //过期时间为24小时
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000))
                .compact();
        System.out.println(jwt);
    }

    /**
     * 验证jwt
     */
    public static void verifyJwt(String jwt) {
        Claims claims = Jwts.parser()
                .setSigningKey("chenjiawei")
                .parseClaimsJws(jwt)
                .getBody();
        System.out.println(claims);
    }
}
