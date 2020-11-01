package com.project.name.web.security;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: ProjectAuthenticationEntryPoint <br/>
 * Description: TODO
 * Date 2020/11/1 7:28
 * 认证入口点
 *
 * @author Lenovo
 **/
@Component
public class CustomerAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        if (isAjaxRequest(request)) {
            //如果不是ajax请求
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        }else if (!response.isCommitted()){
            //已经返回状态码
            response.sendError(HttpServletResponse.SC_FORBIDDEN, authException.getMessage());
        }
    }

    public static boolean isAjaxRequest(HttpServletRequest request) {
        String ajaxFlag = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(ajaxFlag);
    }
}
