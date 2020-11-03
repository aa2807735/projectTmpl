package com.project.name.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * ClassName: JwtUtils <br/>
 * Description: TODO
 * Date 2020/10/30 9:25
 * JwtUtils 鉴权、验证等
 *
 * @author Lenovo
 **/
public class JwtUtils {

    /**
     * TOKEN 头部
     */
    public static final String TOKEN_HEADER = "Authorization";
    /**
     * TOKEN 前醉
     */
    public static final String TOKEN_PREFIX = "Bearer";
    /**
     * 过期时间  两个小时
     */
    private static final long EXPIRE_TIME = 1000 * 60 * 60 * 2;

    /**
     * 密钥
     */
    private static final String APP_SECRET_KEY = "cong_secret";

    private static final String SUBJECT = "cong";

    /**
     * 生成JWT
     *
     * @param authUser 用户实体
     * @return JWT值
     */
    public static String generateJsonWebToken(AuthUserToken authUser) {
        if (authUser.getUserId() == null || authUser.getUserName() == null) {
            return null;
        }
        //TODO:: 获取角色、权限，需要拱写服务
        return TOKEN_PREFIX + Jwts
                .builder()
                .setSubject(SUBJECT)   //设置主题
                .claim("role", "admin")    //设置角色
                .claim("primes", "place:goods:view,place:goods:add,auth:authUser:view") //设置权限
                .claim("id", authUser.getUserId())  //公开信息
                .claim("name", authUser.getUserName()) //公开信息
                .setIssuedAt(new Date(System.currentTimeMillis())) //设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME)) //设置过期时间
                .signWith(SignatureAlgorithm.HS256, APP_SECRET_KEY) //加密算法，和密钥
                .compact();
    }

    /**
     * 检查token，返回claims
     *
     * @param token
     * @return
     */
    public static Claims checkJWT(String token) {
        try {
            final Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("name").toString();
    }

    /**
     * 获取用户角色
     *
     * @param token
     * @return
     */
    public static String getUserRole(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.get("role").toString();
    }

    /**
     * 是否过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        Claims claims = Jwts.parser().setSigningKey(APP_SECRET_KEY).parseClaimsJws(token).getBody();
        return claims.getExpiration().before(new Date());
    }

}
