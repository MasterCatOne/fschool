package com.example.fschool.utils;

import com.example.fschool.model.po.Parents;
import com.example.fschool.model.po.Students;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

@Slf4j
public class JWTUtil {
    /**
     * token 过期时间，正常是7天，方便测试我们改为70天
     */
    private static final long EXPIRE = 1000 * 60 * 60 * 24 * 7 * 10;

    /**
     * 加密的秘钥
     */
    private static final String SECRET = "example.fschool";

    /**
     * 令牌前缀
     */
    private static final String TOKEN_PREFIX = "example";

    /**
     * subject
     */
    private static final String SUBJECT = "fschool";

    /**
     * 根据学生信息，生成令牌
     *
     * @param students 用户信息
     * @return
     */
    public static String geneJsonWebToken(Students students) {

        if (students == null) {
            throw new NullPointerException("user对象为空");
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                //payload
                .claim("student_id", students.getStudentId())
                .claim("student_name", students.getStudentName())
                //设置发布时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置加密算法
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        //拼装
        token = TOKEN_PREFIX + token;
        return token;
    }
    /**
     * 根据家长信息，生成令牌
     *
     * @param parents 用户信息
     * @return
     */
    public static String geneJsonWebTokenParent(Parents parents) {

        if (parents == null) {
            throw new NullPointerException("user对象为空");
        }

        String token = Jwts.builder().setSubject(SUBJECT)
                //payload
                .claim("parent_id", parents.getParentId())
                .claim("parent_name", parents.getParentName())
                //设置发布时间
                .setIssuedAt(new Date())
                //设置过期时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                //设置加密算法
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        //拼装
        token = TOKEN_PREFIX + token;
        return token;
    }
    /**
     * 校验token的方法
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            //解密
            final Claims claims = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody();

            return claims;

        } catch (Exception e) {
            log.info("jwt token解密失败");
            return null;
        }
    }
}