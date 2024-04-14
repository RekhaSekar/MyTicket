package com.ticket.myticket.config;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.ticket.myticket.Util.JWTUtil;

@Component
public class MyFilter extends GenericFilterBean {

	@Autowired
	JWTUtil jwtUtil;

//	private String userName = "user";
//	private String password = "123456789";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		if(((HttpServletRequest) request).getRequestURI().contains("/users")) {
			//System.out.println("inside users");
			chain.doFilter(request, response);
		}else {
			//System.out.println("inside 1st else");
			if(jwtUtil.isTokenExpired(((HttpServletRequest) request).getHeader("Authorization"))) {
				chain.doFilter(request, response);
			}else {
				//System.out.println("inside 2nd else");
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
				PrintWriter writer = httpResponse.getWriter();
				writer.print("You are unauthenticated!!!!");
				writer.flush();
				writer.close();
			}
		}
	}

}
