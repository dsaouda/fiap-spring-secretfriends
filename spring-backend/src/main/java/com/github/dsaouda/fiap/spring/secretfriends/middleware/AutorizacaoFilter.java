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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.github.dsaouda.fiap.spring.secretfriends.session.UsuarioSession;

@Order(2)
@Component
public class AutorizacaoFilter implements Filter {
	
	@Autowired
	UsuarioSession usuarioSession;
	
	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest request = ((HttpServletRequest) req);
		HttpServletResponse response = ((HttpServletResponse) res);
		
		String requestURI = request.getServletPath();
		
		if (requestURI.indexOf("open/") != -1) {
			chain.doFilter(req, res);
			return ;
		}
		
		System.out.println(usuarioSession);
		
		if (usuarioSession.getId() == null) {
			response.setStatus(HttpStatus.FORBIDDEN.value());
			return ;
		}
		
		chain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
