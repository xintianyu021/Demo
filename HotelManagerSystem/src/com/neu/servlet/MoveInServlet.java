package com.neu.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.dao.GuestRoomDao;
import com.neu.dao.GuestRoomDaoImpl;
import com.neu.dao.OrderDao;
import com.neu.dao.OrderDaoImpl;
import com.neu.dao.OrderNumberDao;
import com.neu.dao.OrderNumberDaoImpl;
import com.neu.entity.GuestRoom;
import com.neu.entity.Order;
import com.neu.entity.OrderNumber;
import com.neu.service.OrderNumberService;
import com.neu.service.OrderNumberServiceImpl;

/**
 * Servlet implementation class MoveInServlet
 */
@WebServlet("/MoveInServlet")
public class MoveInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	OrderDao orderDao = new OrderDaoImpl();
	OrderNumberService orderNumberService = new OrderNumberServiceImpl();
	
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MoveInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		switch(method) {
		case "reserve":
			try {
				reserve(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		case "checkin":
			try {
				checkin(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	//等房间的service写好加校验房间入住情况功能
	protected void reserve(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String roomtype = request.getParameter("roomtype");
		String roomid = request.getParameter("roomid");
		String idcard = request.getParameter("idcard");
		String guest = request.getParameter("guest");
		String vipid = request.getParameter("vipid");
		String tel = request.getParameter("tel");
		
		Date time = new Date();
		
		List<Order> checkR = orderDao.getByPartsByPage(idcard, null, null, null, "预定", "true", 1, 1);
		List<Order> checkC = orderDao.getByPartsByPage(idcard, null, null, null, "入住", "true", 1, 1);
		
		//orderDao.getByPartsByPage(idcard, guest, roomtype, roomid, orderstate, newstate, pageNum, pageSize)
		
		if(checkR != null) {
			String msg = "reserved";
			response.sendRedirect(request.getContextPath()+"/reserveinfo.jsp?msg="+msg);
			return;
		}
		else if(checkC != null) {
			String msg = "checked";
			response.sendRedirect(request.getContextPath()+"/reserveinfo.jsp?msg="+msg);
			return;
		}
		
		String orderid = orderNumberService.getid();
		
		Order order = new Order(0, orderid, roomid, roomtype, "预定", "1" , guest, idcard, vipid, tel, time, "true");
		
		GuestRoomDao guestRoomDao = new GuestRoomDaoImpl();
		
		int roomid1 = Integer.parseInt(roomid);
		
		GuestRoom guestRoom = guestRoomDao.getById(roomid1, 1, 1);
		guestRoom.setRoomstate("已预订");
		
		//System.out.println(guestRoom);
		
		int m = guestRoomDao.update(guestRoom);
		
		
		String msg = "success";
		
		int n = orderDao.insert(order);
		
		
		
		response.sendRedirect(request.getContextPath()+"/reserveinfo.jsp?msg="+msg);
		
	}
	
	
	protected void checkin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String roomtype = request.getParameter("roomtype");
		String roomid = request.getParameter("roomid");
		String idcard = request.getParameter("idcard");
		String guest = request.getParameter("guest");
		String vipid = request.getParameter("vipid");
		String tel = request.getParameter("tel");
		
		Date time = new Date();
		
		List<Order> checkR = orderDao.getByPartsByPage(idcard, null, null, null, "预约", "true", 1, 1);
		List<Order> checkC = orderDao.getByPartsByPage(idcard, null, null, null, "入住", "true", 1, 1);
		
		if(checkR != null) {
			String msg = "reserved";
			response.sendRedirect(request.getContextPath()+"/reserveinfo.jsp?msg="+msg);
			return;
		}
		else if(checkC != null) {
			String msg = "checked";
			response.sendRedirect(request.getContextPath()+"/reserveinfo.jsp?msg="+msg);
			return;
		}
		
		String orderid = orderNumberService.getid();
		
		Order order = new Order(0, orderid, roomid, roomtype, "入住", "4" , guest, idcard, vipid, tel, time, "true");
		
		GuestRoomDao guestRoomDao = new GuestRoomDaoImpl();
		
		int roomid1 = Integer.parseInt(roomid);
		
		GuestRoom guestRoom = guestRoomDao.getById(roomid1, 0, 1);
		guestRoom.setRoomstate("已入住");
		
		int m = guestRoomDao.update(guestRoom);
		
		String msg = "success";
		
		int n = orderDao.insert(order);
		
		
		
		response.sendRedirect(request.getContextPath()+"/checkin.jsp?msg="+msg);
	}

}
