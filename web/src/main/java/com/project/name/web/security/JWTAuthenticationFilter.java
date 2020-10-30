package com.project.name.web.security;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * ClassName: JWTAuthenticationFilter <br/>
 * Description: TODO
 * Date 2020/10/30 9:18
 *
 * *验证用户名密码正确后，生成一个token，并将token返回给客户端
 * *该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法,
 * *attemptAuthentication：接收并解析用户凭证。
 * *successfulAuthentication：用户成功登录后，这个方法会被调用，我们在这个方法里生成token并返回。
 * @author Lenovo
 **/
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
}
