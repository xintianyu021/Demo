package com.neu.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.entity.Sysuser;

/**
 * Servlet Filter implementation class LoginCheckFilter
 */
@WebFilter("/LoginCheckFilter")
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
        // TODO Auto-generated constructor stub
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request2 = (HttpServletRequest) request;
		
		String uri = request2.getRequestURI();
		if(uri.equals(request2.getContextPath()+"/login.jsp") || uri.equals(request2.getContextPath()+"/LoginServlet")) {
			chain.doFilter(request, response);
			return;
		}
		
		HttpSession session = request2.getSession();
		Sysuser sys = (Sysuser) session.getAttribute("sysuser");
		
		if(sys==null) {
			((HttpServletResponse)response).sendRedirect(request2.getContextPath()+"/login.jsp");
			return;
		}
		
		chain.doFilter(request, response);
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
