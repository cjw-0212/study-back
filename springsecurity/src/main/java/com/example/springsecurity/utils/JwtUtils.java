package com.example.springsecurity.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author CJW
 * @since 2023/10/23
 */
public class JwtUtils {
    /**
     * jwt的有效时间，单位为毫秒
     */
    private static final Long JWT_TTL = 60 * 60 * 1000L;
    /**
     * jwt加密密钥
     */
    private static final String JWT_KEY = "chenjiaweichenjiawei";
    /**
     * 签发者
     */
    private static final String JWT_ISSUER = "CJW";

    /**
     * 生成指定的过期时间和携带数据的JWT
     *
     * @param subject   携带的数据，可以是json字符串
     * @param ttlMillis 过期时间,不填会使用默认时间
     * @return 携带指定数据的jwt
     */
    public static String createJwt(String subject, Long ttlMillis, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        SecretKey secretKey = generalKey();
        long nowMillis = System.currentTimeMillis();
        if (ttlMillis == null) {
            ttlMillis = JwtUtils.JWT_TTL;
        }
        long expireMillis = nowMillis + ttlMillis;
        Date expireDate = new Date(expireMillis);
        return Jwts.builder()
                .setId(getUUID())
                .setSubject(subject)
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(new Date())
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expireDate)
                .setClaims(claims)
                .compact();
    }

    /**
     * 生成默认配置参数并携带主题的JWT
     *
     * @param subject 携带的数据可以是json字符串
     * @return JWT字符串
     */
    public static String createJwt(String subject) {
        return createJwt(subject, null, null);
    }

    /**
     * 生成默认配置参数并携带map数据的JWT
     *
     * @param claims 携带的map类型数据
     * @return JWT字符串
     */

    public static String createJwt(Map<String, Object> claims) {
        return createJwt(null, null, claims);
    }


    /**
     * @return 解析jwt出来的数据
     */
    public static Claims parseJwt(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    /**
     * @return 加密后的秘钥 secretKey
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtils.JWT_KEY);
        return new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
    }

    /**
     * @return 全局唯一uuid
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}
