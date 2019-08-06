package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.GoodsType;
import com.neu.service.GoodsTypeService;
import com.neu.service.GoodsTypeServiceImpl;

/**
 * Servlet implementation class GoodsTypeServlet
 */
@WebServlet("/GoodsTypeServlet")
public class GoodsTypeServlet extends HttpServlet {
	
	GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = "getPage";
		String m = request.getParameter("method");
		String m1 = (String) request.getAttribute("method");
		if(m != null) {
			method = m;
		}
		if(m1 != null) {
			method = m1;
		}
			
		switch(method) {
		case "insert":
			try {
				insert(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "delete":
			try {
				delete(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "update":
			try {
				update(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "getPage":
			try {
				getPage(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "getUnitInfo":
			try {
				getUnitInfo(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	/*
	private String goodtype;
	private String typename;
	private String notes;
	*/
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodtype = request.getParameter("goodtype");
		String typename = request.getParameter("typename");
		String notes = request.getParameter("notes");
		String pageNum = request.getParameter("pageNum");
		
		GoodsType goodstype = new GoodsType(0, goodtype, typename, notes);
		
		int n = goodsTypeService.add(goodstype);
		
		request.setAttribute("msg", n);
		
		response.sendRedirect(request.getContextPath()+"/GoodsTypeServlet?pageNum="+pageNum);
	}
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodtype = request.getParameter("goodtype");
		String pageNum = request.getParameter("pageNum");
		int n = goodsTypeService.remove(goodtype);
		
		response.sendRedirect(request.getContextPath()+"/GoodsTypeServlet?pageNum="+pageNum);
	}
	
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodtype = request.getParameter("goodtype");
		String typename = request.getParameter("typename");
		String notes = request.getParameter("notes");
		String pageNum = request.getParameter("pageNum");
		
		GoodsType goodstype = new GoodsType(0, goodtype, typename, notes);
		
		int n = goodsTypeService.modify(goodstype);
		
		//request.setAttribute("msg", n);
		//request.setAttribute("method", "getPage");
		
		response.sendRedirect(request.getContextPath()+"/GoodsTypeServlet?pageNum="+pageNum);
		
	}
	
	protected void getPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNum = 1;
		String pn = request.getParameter("pageNum");
		if(pn != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int pageSize = 5;
		//int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		List<GoodsType> infoInPage = goodsTypeService.getAll(pageSize, pageNum);
		request.setAttribute("infoInPage", infoInPage);
		
		int tips = goodsTypeService.count();
		int pages;
		if(tips%pageSize==0) {
			pages = tips/pageSize;
		}
		else {
			pages = tips/pageSize+1;
		}
		
		
		request.setAttribute("pages", pages);
		
		request.setAttribute("pageNum", pageNum);
		
		request.getRequestDispatcher("/goodstype.jsp").forward(request, response);
		
	}
	
	protected void getUnitInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodtype = request.getParameter("goodtype");
		GoodsType goodsType = goodsTypeService.getById(goodtype);
		request.setAttribute("goodsType", goodsType);
		
		request.getRequestDispatcher("/changeGoodType.jsp").forward(request, response);
		
	}
	

}
