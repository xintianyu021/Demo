package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.TrainDao;
import com.neu.dao.TrainDaoImpl;
import com.neu.entity.Train;

/**
 * Servlet implementation class SearchTrainServlet
 */
@WebServlet("/SearchTrainServlet")
public class SearchTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDao traindao = new TrainDaoImpl();
		try {
			
			int pageSize = 3;
			int pageNum = 1;
			
			String num = request.getParameter("pageNum");
			if(num!=null) {
				pageNum = Integer.parseInt(num);
			}
			
			List<Train> list = traindao.getPage(pageSize, pageNum);
			request.setAttribute("list", list);
			
			int count = traindao.count();
			int page = count%pageSize==0?count/pageSize:count/pageSize+1;
			
			request.setAttribute("page", page);
			
			request.getRequestDispatcher("/search.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
