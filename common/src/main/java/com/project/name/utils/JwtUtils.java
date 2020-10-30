package com.project.name.utils;

import com.project.name.repository.goods.entity.auth.AuthUser;

/**
 * ClassName: JwtUtils <br/>
 * Description: TODO
 * Date 2020/10/30 9:25
 * JwtUtils 鉴权、验证等
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
     * 过期时间
     */
    public static final long EXPIRE_TIME = 1000 * 24 * 60 * 60 * 7;

    public static String generateJsonWebToken(AuthUser authUser ) {


    }

}
