package com.neu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.neu.entity.Bill;
import com.neu.entity.GoodsInfo;
import com.neu.entity.Order;
import com.neu.util.DBUtil;

public class BillDaoImpl implements BillDao {
	
	DBUtil u = new DBUtil();
	GoodsInfoDao goodInfoDao = new GoodsInfoDaoImpl();
	
	@Override
	public int insert(Bill bill) throws Exception {
		int id = bill.getId();
		String orderid = bill.getOrderid();
		String roomid = bill.getRoomid();
		String idcard = bill.getIdcard();
		String vipid = bill.getVipid();
		String goodtype = bill.getGoodtype();
		String num = bill.getNum();
		String total = bill.getTotal();
		String tel = bill.getTel();
		Date time = bill.getTime();
		
		String sql = "insert into bill "
				+ "value (0,?,?,?,?,?,?,?,?,?)";
		
		int n = u.executeUpdate(sql, orderid,roomid,idcard,vipid,goodtype,num,total,tel,time);
		
		return n;
	}

	@Override
	public int update(Bill bill) throws Exception {
		int id = bill.getId();
		String orderid = bill.getOrderid();
		String roomid = bill.getRoomid();
		String idcard = bill.getIdcard();
		String vipid = bill.getVipid();
		String goodtype = bill.getGoodtype();
		String num = bill.getNum();
		String total = bill.getTotal();
		String tel = bill.getTel();
		Date time = bill.getTime();
		
		String sql = "update bill "
				+ "set orderid = ? , "
				+ "roomid = ? , "
				+ "idcard = ? , "
				+ "vipid = ? , "
				+ "goodtype = ? , "
				+ "num = ? , "
				+ "total = ? , "
				+ "tel = ? , "
				+ "time = ? "
				+ "where id = ?";
		
		int n = u.executeUpdate(sql,orderid,roomid,idcard,vipid,goodtype,num,total,tel,time,id);
		
		return n;
	}

	@Override
	public int delete(int id) throws Exception {
		String sql = "delete from bill "
				+ "where id = ?";
		
		int n = u.executeUpdate(sql,id);
		
		return n;
	}

	@Override
	public List<Bill> getAllByPage(int pageNum, int pageSize) throws Exception {
		String sql = "select * from bill "
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , index , pageSize);
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Bill> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id");
			String orderid = r.getString("orderid");
			String roomid = r.getString("roomid");
			String idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String goodtype = r.getString("goodtype");
			String num = r.getString("num");
			String total = r.getString("total");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			
			Bill bill = new Bill(id, orderid, roomid, idcard, vipid, goodtype, num, total, tel, time);
			
			list.add(bill);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public List<Bill> getByOrderidByPage(String orderid, int pageNum, int pageSize) throws Exception {
		String sql = "select * from bill "
				+ "where orderid = ?  "
				+ "limit ?,?";
		
		int index = (pageNum-1)*pageSize;
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , orderid , index , pageSize);
		if(!r.next()) {
			u.closeConnection(c);
			return null;
		}
		
		List<Bill> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id");
			orderid = r.getString("orderid");
			String roomid = r.getString("roomid");
			String idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			String goodtype = r.getString("goodtype");
			String num = r.getString("num");
			String total = r.getString("total");
			String tel = r.getString("tel");
			Date time = r.getDate("time");
			
			Bill bill = new Bill(id, orderid, roomid, idcard, vipid, goodtype, num, total, tel, time);
			
			list.add(bill);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public int getPageNumAll() throws Exception {
		String sql = "select count(*) num from bill ";
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c );
		
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

	@Override
	public int getPageNumByOrderid(String orderid) throws Exception {
		String sql = "select count(*) num from bill "
				+ "where orderid = ?";
		
		Connection c = u.getConnection();
		
		ResultSet r = u.executeQuery(sql, c , orderid );
		
		r.next();
		int n = r.getInt("num");
		
		u.closeConnection(c);
		return n;
	}

	@Override
	public double getSum(String orderid) throws Exception {
		String sql = "select sum(total) from bill where orderid = ? group by orderid";
		Connection connection = u.getConnection();
		ResultSet rs = u.executeQuery(sql, connection, orderid);
		double sum = 0;
		if(rs.next()) {
			sum = rs.getDouble(1);
		}
		return sum;
	}

	@Override
	public List<Bill> getTable(String orderid, String roomid, String idcard, String goodtype, String tel,
			String starttime, String endtime, int pageNum, int pageSize) throws Exception {
		String tail = "where ";
		if(orderid!=null && !orderid.equals("")) {
			tail += "orderid='"+orderid+"' and ";
		}
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
		}
		if(goodtype!=null && !goodtype.equals("")) {
			tail += "goodtype='"+goodtype+"' and ";
		}
		if(tel!=null && !tel.equals("")) {
			tail += "roomid='"+roomid+"' and ";
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
		
		String sql = "select * from bill "
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
		
		List<Bill> list = new ArrayList<>();
		
		do {
			int id = r.getInt("id"); 
			orderid = r.getString("orderid");
			roomid = r.getString("roomid");
			String goodname = r.getString("goodtype");
			/*GoodsInfo goodinfo = goodInfoDao.getById(goodtype);
			String goodname = goodinfo.getGoodname();*/
			String num = r.getString("num");
			String total = r.getString("total");
			idcard = r.getString("idcard");
			String vipid = r.getString("vipid");
			tel = r.getString("tel");
			Date time = r.getDate("time");
			
			Bill bill = new Bill(id, orderid, roomid, idcard, vipid, goodname, num, total, tel, time);
			
			list.add(bill);
		}
		while(r.next());
		
		u.closeConnection(c);
		return list;
	}

	@Override
	public int countTable(String orderid, String roomid, String idcard, String goodtype, String tel, String starttime,
			String endtime, int pageNum, int pageSize) throws Exception {
		String tail = "where ";
		if(orderid!=null && !orderid.equals("")) {
			tail += "orderid='"+orderid+"' and ";
		}
		if(idcard!=null && !idcard.equals("")) {
			tail += "idcard='"+idcard+"' and ";
		}
		if(roomid!=null && !roomid.equals("")) {
			tail += "roomid='"+roomid+"' and ";
		}
		if(goodtype!=null && !goodtype.equals("")) {
			tail += "goodtype='"+goodtype+"' and ";
		}
		if(tel!=null && !tel.equals("")) {
			tail += "roomid='"+roomid+"' and ";
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
		
		String sql = "select count(*) num from bill "
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
		
		if(!r.next()) {
			u.closeConnection(c);
			return 0;
		}
		
		int tips = r.getInt("num");
		
		u.closeConnection(c);
		return tips;
	}

}
