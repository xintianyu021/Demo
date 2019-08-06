package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.Bill;
import com.neu.entity.GuestRoom;
import com.neu.entity.Order;
import com.neu.entity.RoomType;
import com.neu.service.CheckInHotelService;
import com.neu.service.CheckInHotelServiceImpl;
import com.neu.service.CheckInManageService;
import com.neu.service.CheckInManageServiceImpl;

/**
 * Servlet implementation class CheckInManageServlet
 */
@WebServlet("/CheckInManageServlet")
public class CheckInManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CheckInManageService checkInManageService = new CheckInManageServiceImpl();
	CheckInHotelService checkInHotelService = new CheckInHotelServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method2 = request.getParameter("method");
		String method = "getAll";
		if(method!=null) {
			method = method2;
		}
		switch(method) {
		case "getAll":
			getAll(request, response);
			break;
		case "getParts":
			getParts(request, response);
			break;
		case "changeRoomFirst":
			changeRoomFirst(request, response);
			break;
		case "paymentFirst":
			paymentFirst(request, response);
			break;
		case "getEmptyRoom":
			getEmptyRoom(request, response);
			break;
		case "changeRoomDone":
			changeRoomDone(request, response);
			break;
		}	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	
	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String num = request.getParameter("pageNum");
		int pageSize = 5;
		int pageNum = 1;
		if(num!=null) {
			pageNum = Integer.parseInt(num);
		}
		
		try {
			List<Order> list = checkInManageService.getAllCheckOrder(pageNum, pageSize);
			request.setAttribute("list", list);
			int count = checkInManageService.countOfAll();
			int page = count%pageNum==0?count/pageNum:count/pageNum+1;
			request.setAttribute("page", page);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("n", 1);
			request.getRequestDispatcher("checkinmanager.jsp").forward(request, response);	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void getParts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idcard = request.getParameter("idcard");
		String roomid = request.getParameter("roomid");
		
		try {
			if((idcard==null||idcard=="") && roomid!=null) {
				List<Order> list = checkInManageService.getByRoomId(roomid);
				request.setAttribute("list", list);
			}else if(idcard!=null && (roomid==null||roomid=="")) {
				List<Order> list = checkInManageService.getByIdcard(idcard);
				request.setAttribute("list", list);
			}else {
				List<Order> list = checkInManageService.getByIcAndRI(idcard, roomid);
				request.setAttribute("list", list);
			}
			request.getRequestDispatcher("checkinmanager.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void changeRoomFirst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idcard = request.getParameter("idcard");
		String num = request.getParameter("pageNum");
		int pageNum = 1;
		int pageSize = 5;
		if(num!=null) {
			pageNum = Integer.parseInt(num);
		}
		try {
			int count = checkInHotelService.pageCount();
			int page = count % pageSize == 0?count/pageSize : count/pageSize + 1;
			request.setAttribute("page", page);
			List<Order> orderlist = checkInManageService.getByIdcard(idcard);
			Order order = orderlist.get(0);
			request.setAttribute("order", order);
			List<RoomType> roomtypelist = checkInHotelService.getRoomType();
			request.setAttribute("roomtypelist", roomtypelist);
			String roomstate = "ø’œ–÷–";
			List<GuestRoom> list = checkInHotelService.getEmptyRoom(roomstate, pageSize, pageNum);
			request.setAttribute("list", list);
			request.setAttribute("pageNum", pageNum);
			request.getRequestDispatcher("changeRoom.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void getEmptyRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roomtype = request.getParameter("roomtype");
		String idcard = request.getParameter("idcard");
		String num = request.getParameter("pageNum");
		int pageNum = 1;
		int pageSize = 5;
		if(num!=null) {
			pageNum = Integer.parseInt(num);
		}
		try {
			List<Order> orderlist = checkInManageService.getByIdcard(idcard);
			Order order = orderlist.get(0);
			request.setAttribute("order", order);
			
			int count = checkInHotelService.typeCount(roomtype);
			int page;
			if(count<5) {
				page = 1;
			}else {
				page = count % pageSize == 0?count/pageSize : count/pageSize + 1;
			}
			String roomstate = "ø’œ–÷–";
			List<GuestRoom> list = checkInHotelService.getEmptyRoomByRoomType(roomtype, roomstate, pageSize, pageNum);
			request.setAttribute("list", list);
			request.setAttribute("n", 1);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("page", page);
			request.setAttribute("type", roomtype);
			List<RoomType> roomtypelist = checkInHotelService.getRoomType();
			request.setAttribute("roomtypelist", roomtypelist);
			request.getRequestDispatcher("changeRoom.jsp").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private void changeRoomDone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idcard = request.getParameter("idcard");
		String roomid = request.getParameter("roomid");
		String newroomid = request.getParameter("newroomid");
		
		try {
			int n2 = checkInManageService.updateNewRoom(roomid);
			int n1 = checkInManageService.updateNewState(idcard, newroomid);
			
			request.setAttribute("n1", n1);
			request.setAttribute("n2", n2);
			request.getRequestDispatcher("changeRoomInfo.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void paymentFirst(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String idcard = request.getParameter("idcard");
		int pageNum =1;
		int pageSize = 1000;
		try {
			List<Bill> list = checkInManageService.getBill(idcard, pageNum, pageSize);
			request.setAttribute("list", list);
			List<Order> orderlist = checkInManageService.getByIdcard(idcard);
			Order order = orderlist.get(0);
			request.setAttribute("order", order);
			
			double sum = checkInManageService.getSum(order.getOrderid());
			request.setAttribute("sum", sum);
			request.getRequestDispatcher("payment.jsp").forward(request, response);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
}
