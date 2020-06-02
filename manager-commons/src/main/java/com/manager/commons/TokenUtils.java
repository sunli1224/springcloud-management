package com.manager.commons;

import io.jsonwebtoken.*;

import java.util.Calendar;
import java.util.Date;


/**
 * token生成和检验是否失效
 * JWT工具类
 * @author sunli
 * @date 2020/3/24 17:31
 */
public class TokenUtils {

    // private static long TIME = 1800000L;
    /**
     * 秘钥
     */
    private static String SECRET = "wjgxysunlixx";

    /**
     * 创建token
     * @param username 用户名
     * @return token
     */
    public static String createToken(String username) {
        Date iatDate = new Date();
        // expire time
        Calendar nowTime = Calendar.getInstance();
        //有10天有效期
        nowTime.add(Calendar.DATE, 10);
        Date expiresDate = nowTime.getTime();
        Claims claims = Jwts.claims();
        claims.put("username", username);
        claims.setAudience("LoginUser");
        claims.setIssuer("sunlixx");
        return Jwts.builder().setClaims(claims).setExpiration(expiresDate)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }


    /**
     * 解析token
     * @param token token值
     * @return 是否能解析 true，false
     */
    public static Boolean parseJwtToken(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    //秘钥
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
//        //构建JWT令牌对象
//        JwtBuilder builder = Jwts.builder();
//        //发行人
//        builder.setIssuer("sunlixx");
//        //主题
//        builder.setSubject("登录令牌");
//        //接受token用户
//        builder.setAudience("LoginUser");
//        //颁发时间
//        builder.setIssuedAt(new Date());
//        //设置过期时间
//        builder.setExpiration(new Date(System.currentTimeMillis() + TIME));
//        // 1、签名算法 2、秘钥
//        builder.signWith(SignatureAlgorithm.HS256,SECRET);
//        //获得令牌
//        return builder.compact();
}
