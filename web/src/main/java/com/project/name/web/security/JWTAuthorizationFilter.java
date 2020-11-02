package com.project.name.web.security;

import com.project.name.web.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: JWTAuthorizationFilter <br/>
 * Description: TODO
 * Date 2020/10/30 9:20
 * 鉴权
 *
 * @author Lenovo
 **/
@Slf4j
public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
    private static final String PUB_COMMON_PRIME = "common";
    private static final String PRIMES = "primes";


    public JWTAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String tokenHeader = request.getHeader(JwtUtils.TOKEN_HEADER);
        tokenHeader = "BearereyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJjb25nIiwicm9sZSI6ImFkbWluIiwicHJpbWVzIjoicGxhY2U6Z29vZHM6dmlldyxwbGFjZTpnb29kczphZGQsYXV0aDphdXRoVXNlcjp2aWV3IiwiaWQiOjEsIm5hbWUiOiJXR0IiLCJpYXQiOjE2MDQyOTc2MjUsImV4cCI6MTYwNDkwMjQyNX0.7SRnLkbXHZJYCyPyAUQI1IQ1zOpYV4RrkX385DbRnI8";
        if (tokenHeader == null || !tokenHeader.startsWith(JwtUtils.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }
        UsernamePasswordAuthenticationToken authenticationToken = getAuthentication(tokenHeader);
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(String tokenHeader) {
        String token = tokenHeader.replace(JwtUtils.TOKEN_PREFIX, "");
        try {
            List<GrantedAuthority> authorities = new ArrayList<>();
            boolean expiration = JwtUtils.isExpiration(token);
            if (expiration) {
                log.info("【鉴权中心】 用户令牌校验失败，已过期！");
            }
            Claims claims = JwtUtils.checkJWT(token);
            String primes = (String) claims.get(PRIMES);
            for (String prime : primes.split(",")) {
                authorities.add(new SimpleGrantedAuthority(prime));
            }
            //公共接口
            authorities.add(new SimpleGrantedAuthority(PUB_COMMON_PRIME));
            //TODO: 需要重新签发TOKEN
            return new UsernamePasswordAuthenticationToken(token, null, authorities);
        } catch (Exception e) {
            log.info("【鉴权中心】 JWT的token校验失败，请检查，{}", e.getMessage());
            return null;
        }
    }
}
