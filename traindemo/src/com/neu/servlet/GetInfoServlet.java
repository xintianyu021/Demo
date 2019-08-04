package com.neu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.TrainDao;
import com.neu.dao.TrainDaoImpl;
import com.neu.entity.Train;

/**
 * Servlet implementation class GetInfoServlet
 */
@WebServlet("/GetInfoServlet")
public class GetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		TrainDao t = new TrainDaoImpl();
		try {
			Train train = t.getById(no);
			
			request.setAttribute("train", train);
			request.getRequestDispatcher("/info.jsp").forward(request, response);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
