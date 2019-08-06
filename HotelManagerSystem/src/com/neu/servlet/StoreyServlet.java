package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.Storey;
import com.neu.service.StoreyService;
import com.neu.service.StoreyServiceImpl;

/**
 * Servlet implementation class StoreServlet
 */
@WebServlet("/StoreyServlet")
public class StoreyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		
		if("getAll".equals(method)) {
			try {
				doGetAll(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}	
			
		}
		else if("getModify".equals(method)) {
			try {
				doGetModify(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("getAdd".equals(method)) {
			doGetAdd(request,response);
		}
		else if("getDel".equals(method)) {
			try {
				doGetDel(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if("getUpdate".equals(method)) {
			try {
				doGetUpdate(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	private void doGetUpdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String storey = request.getParameter("sid");
		String storeyname = request.getParameter("sname");
		
		Storey sto = new Storey(storey, storeyname);
		
		StoreyService stoService = new StoreyServiceImpl();
		int n = stoService.modify(sto);
		String msg;
		if(n == 0) {
			msg = "”–“Ï≥£";
			request.setAttribute("msg", msg);
		}
		
		if(n == 1) {
			response.sendRedirect("StoreyServlet?method=getAll");
		}
		
		
	}
	private void doGetDel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String storey = request.getParameter("storey");
		
		StoreyService stoService = new StoreyServiceImpl();
		
		int n = stoService.remove(storey);
		if( n == 1) {
			request.getRequestDispatcher("/StoreyServlet?method=getAll").forward(request, response);
		}
		
	}

	private void doGetAdd(HttpServletRequest request, HttpServletResponse response) {
		StoreyService stoService = new StoreyServiceImpl();
		
		String storey = request.getParameter("sid");
		String storeyname = request.getParameter("sname");
		
		Storey sto = new Storey(storey, storeyname);
		
		try {
			int n = stoService.add(sto);
			if(n == 1) {
				request.getRequestDispatcher("/StoreyServlet?method=getAll").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private void doGetModify(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String storey = request.getParameter("storey");
		StoreyService stoService = new StoreyServiceImpl();
		
		Storey sto = stoService.getId(storey);
		
	
		request.setAttribute("sto",sto);
		request.getRequestDispatcher("/modifyStorey.jsp").forward(request, response);
		
		
	}
	
	private void doGetAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
			StoreyService stoService = new StoreyServiceImpl();
			int pageNum = 1;
			int pageSize = 3;
			String num = request.getParameter("pageNum");
			
			List<Storey> list = stoService.getStorey(pageSize, pageNum);
			request.setAttribute("sto", list);
			
			if(num != null) {
				pageNum = Integer.parseInt(num);
			}
			
			int count = stoService.number();
			int page = count % pageSize == 0?count / pageSize:count / pageSize+1;
			
			request.setAttribute("page", page);
			request.setAttribute("pageNum", pageNum);
			
			request.getRequestDispatcher("/storeyinfo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
