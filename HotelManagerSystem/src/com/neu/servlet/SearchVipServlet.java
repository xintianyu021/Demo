package com.neu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.neu.entity.Vip;
import com.neu.service.VipService;
import com.neu.service.VipServiceImpl;

/**
 * Servlet implementation class SearchVipServlet
 */
@WebServlet("/SearchVipServlet")
public class SearchVipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String vipid = request.getParameter("vipid");
		String guest = request.getParameter("guest");
		VipService vipservice = new VipServiceImpl();
			try {
				int pageNum = 1;
				int pageSize = 2;
				String num = request.getParameter("pageNum");
				if(num!=null) {
					pageNum = Integer.parseInt(num);
				}
		
				//vipid.length()!=0 && guest.length()==0
				//vipid.length()==0 && guest.length()!=0
				//vipid!=null && guest==null
				//vipid==null && guest!=null
				
				//BUG说明：由于查询需求有三种带参方式，因此分页也需带参，但使用前两种方式，下面流程控制前两种条件无法触发
				
				if(vipid != null && (guest==null||guest.equals(""))) {
					Vip vip = vipservice.getByVipid(vipid);
					request.setAttribute("vip", vip);
					request.getRequestDispatcher("vip.jsp").forward(request, response);
				}else if((vipid==null||vipid.equals("")) && guest!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("searchGuest", guest);
					int count = vipservice.counts(guest);
					int page;
					if(count==1) {
						page=1;
					}else {
						page = count % pageSize == 0?count/pageSize : count%pageSize + 1;
					}
					List<Vip> list = vipservice.getByGuest(guest, pageSize, pageNum);
					request.setAttribute("page", page);
					request.setAttribute("list", list);
					request.getRequestDispatcher("vip.jsp").forward(request, response);
				}else {
					Vip vip = vipservice.getByIdGuest(vipid, guest);
					request.setAttribute("vip", vip);
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
