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
 * Servlet implementation class AddVipServlet
 */
@WebServlet("/AddVipServlet")
public class AddVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String vipid = request.getParameter("vipid");
		String guest = request.getParameter("guest");
		String idcard = request.getParameter("idcard");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String tel = request.getParameter("tel");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		double point = Double.parseDouble(request.getParameter("point"));
		String grade = request.getParameter("grade");
		String notes = request.getParameter("notes");

		try {
			Vip vip = new Vip(0, vipid, guest, idcard, gender, password, tel, address, email, point, grade, notes);
			VipService vipservice = new VipServiceImpl();
			
			int n = vipservice.add(vip);
			if(n==1) {
				request.setAttribute("vip", vip);
				request.getRequestDispatcher("vip.jsp").forward(request, response);
			}else {
				request.setAttribute("error", 1);
				request.getRequestDispatcher("vip.jsp").forward(request, response);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
