package com.project.name.web.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;


/**
 * 添加编码过滤
 */
@Component
public class MmsSecurityWebInitializer extends AbstractSecurityWebApplicationInitializer
{
    /**
     * 配置编码
     */
    @Override
    protected void beforeSpringSecurityFilterChain(ServletContext servletContext)
    {
        FilterRegistration.Dynamic characterEncodingFilter = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
        characterEncodingFilter.setInitParameter("encoding", "UTF-8");
        characterEncodingFilter.setInitParameter("forceEncoding", "true");
        characterEncodingFilter.addMappingForUrlPatterns(null, false, "/*");
    }
}
