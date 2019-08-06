package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;
import com.neu.service.CheckInHotelService;
import com.neu.service.CheckInHotelServiceImpl;

/**
 * Servlet implementation class CheckInHoyelServlet
 */
@WebServlet("/CheckInHotelServlet")
public class CheckInHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	CheckInHotelService service = new CheckInHotelServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String method2 = request.getParameter("method");
		String method = "getPage";
		
		if(method2!=null) {
			method = method2;
		}
		
		if(method.equals("getPage")) {
			getPage(request, response);
		}else if(method.equals("getEmptyRoom")) {
			getEmptyRoom(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	private void getPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String num = request.getParameter("pageNum");
		int pageNum = 1;
		int pageSize = 5;
		if(num!=null) {
			pageNum = Integer.parseInt(num);
		}
		
		try {
			int count = service.pageCount();
			
			
			int page = count % pageSize == 0?count/pageSize : count/pageSize + 1;
			request.setAttribute("page", page);
			String roomstate = "ø’œ–÷–";
			List<GuestRoom> list = service.getEmptyRoom(roomstate, pageSize, pageNum);
			request.setAttribute("list", list);
			request.setAttribute("pageNum", pageNum);
			List<RoomType> roomtypelist = service.getRoomType();
			request.setAttribute("roomtypelist", roomtypelist);
			request.getRequestDispatcher("/checkinhotel.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	private void getEmptyRoom(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String roomtype = request.getParameter("roomtype");
		String num = request.getParameter("pageNum");
		int pageNum = 1;
		int pageSize = 5;
		if(num!=null) {
			pageNum = Integer.parseInt(num);
		}
		try {
			int count = service.typeCount(roomtype);
			int page;
			if(count<5) {
				page = 1;
			}else {
				page = count % pageSize == 0?count/pageSize : count/pageSize + 1;
			}
			String roomstate = "ø’œ–÷–";
			List<GuestRoom> list = service.getEmptyRoomByRoomType(roomtype, roomstate, pageSize, pageNum);
			request.setAttribute("list", list);
			request.setAttribute("n", 1);
			request.setAttribute("pageNum", pageNum);
			request.setAttribute("page", page);
			request.setAttribute("type", roomtype);
			List<RoomType> roomtypelist = service.getRoomType();
			request.setAttribute("roomtypelist", roomtypelist);
			request.getRequestDispatcher("/checkinhotel.jsp").forward(request, response);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

	
