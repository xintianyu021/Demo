package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.entity.Sysuser;

/**
 * Servlet implementation class SysuserGradeServlet
 */
@WebServlet("/SysuserGradeServlet")
public class SysuserGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Sysuser sys = (Sysuser) session.getAttribute("sysuser");
		String usertype = sys.getUsertype();
		
		if(usertype.equals("π‹¿Ì‘±")) {
			request.getRequestDispatcher("administrator.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("other.jsp").forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
