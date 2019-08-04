package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.Vip;
import com.neu.service.VipService;
import com.neu.service.VipServiceImpl;

/**
 * Servlet implementation class UpdateVipServlet
 */
@WebServlet("/UpdateVipServlet")
public class UpdateVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String vipid = request.getParameter("vipid");
		VipService vipservice = new VipServiceImpl();
		try {
			Vip Vip = vipservice.getByVipid(vipid);
			request.setAttribute("vip", Vip);
			request.getRequestDispatcher("updateVip.jsp").forward(request, response);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
