package com.project.name.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * ClassName: SecurityConfig <br/>
 * Description: TODO
 * Date 2020/11/1 7:05
 *
 * @author Lenovo
 **/
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 静态白名单
     */
    public static final String[] STATIC_PATH = new String[]{
            "/",
            "/*.html",
            "/favicon.ico",
            "/**/*.html",
            "/**/*.css",
            "/**/*.js",
            "/**/*.jpg",
            "/**/*.png",
            "/**/*.gif"
    };

    /**
     * 请求白名单
     */
    public static final String[] AUTH_WHILE = new String[]{
            "/api/auth/code",   //验证码
            "/api/auth/register",
            "/api/auth/login"
    };



    @Resource
    private CustomerAuthenticationEntryPoint customerAuthenticationEntryPoint;

    @Resource
    private CustomerAccessDeniedHandler customerAccessDeniedHandler;


    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JWTAuthorizationFilter jwtAuthorizationFilterBean() throws Exception {
        return new JWTAuthorizationFilter(authenticationManager());
    }


    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //允许跨域
                .cors().and().csrf().disable()
                //不使用SESSION
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                //添加自定义异常入口
                .exceptionHandling().authenticationEntryPoint(customerAuthenticationEntryPoint)
                .and()
                .exceptionHandling().accessDeniedHandler(customerAccessDeniedHandler)
                .and()
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers(HttpMethod.GET, STATIC_PATH).permitAll()
                .antMatchers(AUTH_WHILE).permitAll()
                //鉴权
                .anyRequest().authenticated();
    }
}
