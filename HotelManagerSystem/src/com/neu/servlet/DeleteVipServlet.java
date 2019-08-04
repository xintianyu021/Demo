package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.service.VipService;
import com.neu.service.VipServiceImpl;

/**
 * Servlet implementation class DeleteVipServlet
 */
@WebServlet("/DeleteVipServlet")
public class DeleteVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vipid = request.getParameter("vipid");
		VipService vipservice = new VipServiceImpl();
		try {
			int del = vipservice.remove(vipid);
			request.setAttribute("del", del);
			request.getRequestDispatcher("vip.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
