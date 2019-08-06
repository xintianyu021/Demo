package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.GoodsInfo;
import com.neu.entity.GoodsType;
import com.neu.service.GoodsInfoService;
import com.neu.service.GoodsInfoServiceImpl;
import com.neu.service.GoodsTypeService;
import com.neu.service.GoodsTypeServiceImpl;

/**
 * Servlet implementation class GoodsInfoServlet
 */
@WebServlet("/GoodsInfoServlet")
public class GoodsInfoServlet extends HttpServlet {
	
	GoodsInfoService goodsInfoService = new GoodsInfoServiceImpl();
	
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
		case "getPageByType":
			try {
				getPageByType(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "getListInfo":
			try {
				getListInfo(request, response);
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
		
		String goodid = request.getParameter("goodid");
		String goodname = request.getParameter("goodname");
		String goodtype1 = request.getParameter("goodtype1");
		GoodsType goodsType = new GoodsType();
		goodsType.setGoodtype(goodtype1);
		String unit = request.getParameter("unit");
		double price = Double.parseDouble(request.getParameter("price"));
		String notes = request.getParameter("notes");
		int id = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		GoodsInfo goodsinfo = new GoodsInfo(id, goodid, goodname, goodsType, price, unit, notes);
		
		int n = goodsInfoService.add(goodsinfo);
		
		String goodtype = request.getParameter("goodtype");
		
		//request.setAttribute("msg", n);
		//request.setAttribute("method", "getPage");
		
		if(!(goodtype == null)) {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?method=getPageByType&pageNum="+pageNum+"&goodtype="+goodtype);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?pageNum="+pageNum);
		}
	}
	
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodid = request.getParameter("goodid");
		String pageNum = request.getParameter("pageNum");
		int n = goodsInfoService.remove(goodid);
		
		String goodtype = request.getParameter("goodtype");
		if(goodtype == null) {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?pageNum="+pageNum);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?pageNum="+pageNum+"&method=getPageByType&goodtype="+goodtype);
		}
		
		
	}
	
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodid = request.getParameter("goodid");
		String goodname = request.getParameter("goodname");
		String goodtype1 = request.getParameter("goodtype1");
		GoodsType goodsType = new GoodsType();
		goodsType.setGoodtype(goodtype1);
		String unit = request.getParameter("unit");
		double price = Double.parseDouble(request.getParameter("price"));
		String notes = request.getParameter("notes");
		int id = 0;
		
		String pageNum = request.getParameter("pageNum");
		
		GoodsInfo goodsinfo = new GoodsInfo(id, goodid, goodname, goodsType, price, unit, notes);
		
		int n = goodsInfoService.modify(goodsinfo);
		
		String goodtype = request.getParameter("goodtype");
		
		//request.setAttribute("msg", n);
		//request.setAttribute("method", "getPage");
		
		if(!(goodtype==null)) {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?method=getPageByType&pageNum="+pageNum+"&goodtype="+goodtype);
		}
		else {
			response.sendRedirect(request.getContextPath()+"/GoodsInfoServlet?pageNum="+pageNum);
		}
		
	}
	
	protected void getPage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int pageNum = 1;
		String pn = request.getParameter("pageNum");
		if(pn != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int pageSize = 5;
		//int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		List<GoodsInfo> infoInPage = goodsInfoService.getAll(pageSize, pageNum);
		request.setAttribute("infoInPage", infoInPage);
		
		int tips = goodsInfoService.count();
		int pages;
		if(tips%pageSize==0) {
			pages = tips/pageSize;
		}
		else {
			pages = tips/pageSize+1;
		}
		
		request.setAttribute("pages", pages);
		
		request.setAttribute("pageNum", pageNum);
		
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> typeList = goodsTypeService.getList();
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("/goodsinfo.jsp").forward(request, response);
		
	}
	
	protected void getUnitInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String goodid = request.getParameter("goodid");
		GoodsInfo goodsInfo = goodsInfoService.getByGoodId(goodid);
		request.setAttribute("goodsInfo", goodsInfo);
		
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> typeList = goodsTypeService.getList();
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("/changeGoodInfo.jsp").forward(request, response);
		
	}
	
	protected void getPageByType(HttpServletRequest request, HttpServletResponse response) throws Exception{
		int pageNum = 1;
		String pn = request.getParameter("pageNum");
		if(pn != null) {
			pageNum = Integer.parseInt(request.getParameter("pageNum"));
		}
		
		int pageSize = 5;
		//int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		String goodtype = request.getParameter("goodtype");
		
		if(goodtype.equals("-1")) {
			getPage(request, response);
			return;
		}
		
		List<GoodsInfo> infoInPage = goodsInfoService.getByGoodType(goodtype, pageSize, pageNum);
		request.setAttribute("infoInPage", infoInPage);
		
		int tips = goodsInfoService.countByType(goodtype);
		int pages;
		if(tips%pageSize==0) {
			pages = tips/pageSize;
		}
		else {
			pages = tips/pageSize+1;
		}
		
		request.setAttribute("goodtype", goodtype);
		
		request.setAttribute("pages", pages);
		
		request.setAttribute("pageNum", pageNum);
		
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> typeList = goodsTypeService.getList();
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("/goodsinfo.jsp").forward(request, response);
	}
	
	protected void getListInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
		List<GoodsType> typeList = goodsTypeService.getList();
		request.setAttribute("typeList", typeList);
		
		request.getRequestDispatcher("/addGoodInfo.jsp").forward(request, response);
		
	}
	

}
