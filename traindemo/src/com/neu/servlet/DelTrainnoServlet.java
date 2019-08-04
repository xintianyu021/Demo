package com.neu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;
import com.neu.dao.TrainDao;
import com.neu.dao.TrainDaoImpl;

/**
 * Servlet implementation class DelTrainnoServlet
 */
@WebServlet("/DelTrainnoServlet")
public class DelTrainnoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TrainDao traindao = new TrainDaoImpl();
		String no=(String) request.getParameter("list");
		String[] trainno = no.split(",");
			try {
				for(int i =0;i<trainno.length;i++) {
					traindao.delete(trainno[i]);
				}
				response.sendRedirect(request.getContextPath()+"/delsuccess.jsp");
				
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
