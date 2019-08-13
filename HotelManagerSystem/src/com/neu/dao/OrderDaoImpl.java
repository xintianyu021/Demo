package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.entity.Order;
import com.neu.util.DBUtil;

public class OrderDaoImpl implements OrderDao {
	
	DBUtil u = new DBUtil();
	
	@Override
	public int insert(Order order) throws Exception {
		int id = order.getId(); 
		String orderid = order.getOrderid();
		String roomid = order.getRoomid();
		String roomtype = order.getRoomtype();
		String orderstate = order.getOrderstate();
		String optype = order.getOptype();
		String guest = order.getGuest();
		String idcard = order.getIdcard();
		String vipid = order.getVipid();
		String tel = order.getTel();
		Date time = order.getTime();
		String newstate = order.getNewstate();
		
		String sql = "insert into ordernote "
				+ "value (0,?,?,?,?,?,?,?,?,?,?,?)";
		
		int n = u.executeUpdate(sql,orderid,roomid,roomtype,orderstate,optype,guest,idcard,vipid,tel,time,newstate);
		
		return n;
	}

	@Override
	public int updateState(String orderid) throws Exception {
		String sql = "update ordernote "
				+ "set newstate = 'false' "
				+ "where orderid = ? ";
		int n = u.executeUpdate(sql, orderid);
		return n;
	}

	@Override
	public List<Order> getAllByPage(int pageNum, int pageSize) throws Exception {
		String sql = "select * from ordernote "
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , index , pageSize);
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Order> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id"); 
			String orderid = r.getString("orderid");
			String roomid = r.getString("roomid");
			String roomtype = r.getString("roomtype");
			String orderstate = r.getString("orderstate");
			String optype = r.getString("optype");
			String guest = r.getString("guest");
			String idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			String newstate = r.getString("newstate");
			
			Order order = new Order(id, orderid, roomid, roomtype, orderstate, optype, guest, idcard, vipid, tel, time, newstate);
			
			list.add(order);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public List<Order> getByNewstateByPage(String newstate, int pageNum, int pageSize) throws Exception {
		String sql = "select * from ordernote "
				+ "where newstate = ? "
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , newstate , index , pageSize);
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Order> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id"); 
			String orderid = r.getString("orderid");
			String roomid = r.getString("roomid");
			String roomtype = r.getString("roomtype");
			String orderstate = r.getString("orderstate");
			String optype = r.getString("optype");
			String guest = r.getString("guest");
			String idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			newstate = r.getString("newstate");
			
			Order order = new Order(id, orderid, roomid, roomtype, orderstate, optype, guest, idcard, vipid, tel, time, newstate);
			
			list.add(order);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public int getPageNumAll() throws Exception {
		String sql = "select count(*) num from ordernote ";
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c );
		
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

	@Override
	public int getPageNumByNewstate(String newstate) throws Exception {
		String sql = "select count(*) num from ordernote "
				+ "where newstate = ? ";
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , newstate);
		
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

	@Override
	public List<Order> getByPartsByPage(String idcard, String guest, String roomtype, String roomid, String orderstate,
			String newstate, int pageNum, int pageSize) throws Exception {
		String tail = "where ";
		int flag = 0;
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
			flag++;
		}
		if(guest!=null && !guest.equals("")) {
			tail += "guest='"+guest+"' and ";
			flag++;
		}
		if(roomtype!=null && !roomtype.equals("")) {
			tail += "roomtype='"+roomtype+"' and ";
			flag++;
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
			flag++;
		}
		if(orderstate!=null && !orderstate.equals("")) {
			tail += "orderstate='"+orderstate+"' and ";
			flag++;
		}
		if(newstate!=null && !newstate.equals("")) {
			tail += "newstate='"+newstate+"' and ";
			flag++;
		}
		tail += "true ";
		
		if(flag == 0) {
			tail = "";
		}
		
		//System.out.println(tail);
		
		String sql = "select * from ordernote "
				+ tail
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , index , pageSize);
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Order> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id"); 
			String orderid = r.getString("orderid");
			roomid = r.getString("roomid");
			roomtype = r.getString("roomtype");
			orderstate = r.getString("orderstate");
			String optype = r.getString("optype");
			guest = r.getString("guest");
			idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			newstate = r.getString("newstate");
			
			Order order = new Order(id, orderid, roomid, roomtype, orderstate, optype, guest, idcard, vipid, tel, time, newstate);
			
			list.add(order);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public int countByParts(String idcard, String guest, String roomtype, String roomid, String orderstate,
			String newstate, int pageNum, int pageSize) throws Exception {
		String tail = "where ";
		int flag = 0;
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
			flag++;
		}
		if(guest!=null && !guest.equals("")) {
			tail += "guest='"+guest+"' and ";
			flag++;
		}
		if(roomtype!=null && !roomtype.equals("")) {
			tail += "roomtype='"+roomtype+"' and ";
			flag++;
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
			flag++;
		}
		if(orderstate!=null && !orderstate.equals("")) {
			tail += "orderstate='"+orderstate+"' and ";
			flag++;
		}
		if(newstate!=null && !newstate.equals("")) {
			tail += "newstate='"+newstate+"' and ";
			flag++;
		}
		tail += "true ";
		
		if(flag == 0) {
			tail = "";
		}
		
		String sql = "select count(*) num from ordernote "
				+ tail;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c );
		
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

	@Override
	public List<Order> getByPartsAndTimeByPage(String optype,String idcard, String guest, String roomtype, String roomid,
			String orderstate, String newstate, String starttime, String endtime, int pageNum, int pageSize)
			throws Exception {
		String tail = "where ";
		if(optype!=null && !optype.equals("")) {
			tail += "optype='"+optype+"' and ";
		}
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
		}
		if(guest!=null && !guest.equals("")) {
			tail += "guest='"+guest+"' and ";
		}
		if(roomtype!=null && !roomtype.equals("")) {
			tail += "roomtype='"+roomtype+"' and ";
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
		}
		if(orderstate!=null && !orderstate.equals("")) {
			tail += "orderstate='"+orderstate+"' and ";
		}
		if(newstate!=null && !newstate.equals("")) {
			tail += "newstate='"+newstate+"' and ";
		}
		
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int flag = 0;
		Date ctime = new Date();
		Date start = new Date();
		Date end = new Date();
		if(starttime!=null && !starttime.equals("")) {
			starttime += " 00:00:00";
			start = s.parse(starttime);
			ctime = start;
			tail += "time >= ? and ";
			flag++;
		}
		
		if(endtime!=null && !endtime.equals("")){
			endtime += " 23:59:59";
			end = s.parse(endtime);
			ctime = end;
			tail += "time <= ? and ";
			flag++;
		}
		
		tail += "true ";
		
		//System.out.println(tail);
		
		String sql = "select * from ordernote "
				+ tail
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		ResultSet r;
		
		Connection c = u.getConnection();
		if(flag == 0) {
			r = u.executeQuery(sql, c , index , pageSize);
		}
		else if(flag == 1){
			r = u.executeQuery(sql, c , ctime , index , pageSize);
		}
		else {
			r = u.executeQuery(sql, c , start , end , index , pageSize);
		}
		
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Order> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id"); 
			String orderid = r.getString("orderid");
			roomid = r.getString("roomid");
			roomtype = r.getString("roomtype");
			orderstate = r.getString("orderstate");
			optype = r.getString("optype");
			guest = r.getString("guest");
			idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			newstate = r.getString("newstate");
			
			Order order = new Order(id, orderid, roomid, roomtype, orderstate, optype, guest, idcard, vipid, tel, time, newstate);
			
			list.add(order);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public int countByPartsAndTime(String optype,String idcard, String guest, String roomtype, String roomid, String orderstate,
			String newstate, String starttime, String endtime, int pageNum, int pageSize) throws Exception {
		String tail = "where ";
		if(optype!=null && !optype.equals("")) {
			tail += "optype='"+optype+"' and ";
		}
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
		}
		if(guest!=null && !guest.equals("")) {
			tail += "guest='"+guest+"' and ";
		}
		if(roomtype!=null && !roomtype.equals("")) {
			tail += "roomtype='"+roomtype+"' and ";
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
		}
		if(orderstate!=null && !orderstate.equals("")) {
			tail += "orderstate='"+orderstate+"' and ";
		}
		if(newstate!=null && !newstate.equals("")) {
			tail += "newstate='"+newstate+"' and ";
		}
		
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int flag = 0;
		Date ctime = new Date();
		Date start = new Date();
		Date end = new Date();
		if(starttime!=null && !starttime.equals("")) {
			starttime += " 00:00:00";
			start = s.parse(starttime);
			ctime = start;
			tail += "time >= ? and ";
			flag++;
		}
		
		if(endtime!=null && !endtime.equals("")){
			endtime += " 23:59:59";
			end = s.parse(endtime);
			ctime = end;
			tail += "time <= ? and ";
			flag++;
		}
		
		tail += "true ";
		
		String sql = "select count(*) num from ordernote "
				+ tail;
		
		ResultSet r;
		
		Connection c = u.getConnection();
		if(flag == 0) {
			r = u.executeQuery(sql, c );
		}
		else if(flag == 1){
			r = u.executeQuery(sql, c , ctime );
		}
		else {
			r = u.executeQuery(sql, c , start , end );
		}
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

}
