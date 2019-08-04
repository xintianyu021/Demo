package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.entity.Sysuser;
import com.neu.service.SysUserService;
import com.neu.service.SysUserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		SysUserService service = new SysUserServiceImpl();
		
		try {
			Sysuser sys = service.getByName(username);
			if(sys==null) {
				request.setAttribute("exist", 0);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}else {
				if(username.equals(sys.getUsername()) &&password.equals(sys.getPassword())) {
					HttpSession session = request.getSession();
					session.setAttribute("sysuser", sys);
					request.getRequestDispatcher("main.html").forward(request, response);
				}else {
					request.setAttribute("error", 0);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
