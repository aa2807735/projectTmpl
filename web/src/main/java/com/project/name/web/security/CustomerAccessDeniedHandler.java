package com.project.name.web.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CustomerAccessDeniedHandler <br/>
 * Description: TODO
 * Date 2020/11/1 7:45
 *
 * @author Lenovo
 **/
@Component
public class CustomerAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        if (CustomerAuthenticationEntryPoint.isAjaxRequest(request)) {
            //如果不是ajax请求
            response.sendError(HttpServletResponse.SC_FORBIDDEN);
        } else if (!response.isCommitted()) {
            //已经返回状态码
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "您没有该权限访问！");
        }
    }
}
