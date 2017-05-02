package com.github.dsaouda.fiap.spring.secretfriends.middleware;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class CORSFilter implements Filter {
	
	@Autowired
	Environment env;
	
    public CORSFilter() {
    }
 
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
            throws IOException, ServletException {
    	
    	HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        response.setHeader("Access-Control-Allow-Origin", env.getProperty("cors.access_control_allow_origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true"); //permite armazenar cookie??
        //response.setHeader("Access-Control-Allow-Methods", "*");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");
        
        if (request.getMethod().equals("OPTIONS")) {
        	response.setStatus(HttpServletResponse.SC_OK);
        	return ;
        }
 
        chain.doFilter(request, response);
    }
 
    public void init(FilterConfig config) throws ServletException {
       
    }
 
}