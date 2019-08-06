package com.neu.service;

import java.util.List;

import com.neu.dao.BillDao;
import com.neu.dao.BillDaoImpl;
import com.neu.dao.GuestRoomDao;
import com.neu.dao.GuestRoomDaoImpl;
import com.neu.dao.OrderDao;
import com.neu.dao.OrderDaoImpl;
import com.neu.entity.Bill;
import com.neu.entity.GuestRoom;
import com.neu.entity.Order;

public class CheckInManageServiceImpl implements CheckInManageService {
	OrderDao dao = new OrderDaoImpl();
	GuestRoomDao gdao = new GuestRoomDaoImpl();
	BillDao bdao = new BillDaoImpl();
	@Override
	public List<Order> getAllCheckOrder(int pageNum, int pageSize) throws Exception {
		String orderstate = "入住";
		String newstate = "true";
		List<Order> list = dao.getByPartsByPage(null, null, null, null, orderstate, newstate, pageNum, pageSize);
		return list;
	}

	@Override
	public int countOfAll() throws Exception {
		String orderstate = "入住";
		String newstate = "true";
		int count = dao.countByParts(null, null, null, null, orderstate, newstate, 1, 5);
		return count;
	}

	@Override
	public List<Order> getByIdcard(String idcard) throws Exception {
		String orderstate = "入住";
		String newstate = "true";
		List<Order> list = dao.getByPartsByPage(idcard, null, null, null, orderstate, newstate, 1, 5);
		return list;
	}

	@Override
	public List<Order> getByRoomId(String roomid) throws Exception {
		String orderstate = "入住";
		String newstate = "true";
		List<Order> list = dao.getByPartsByPage(null, null, null, roomid, orderstate, newstate, 1, 5);
		return list;
	}

	@Override
	public List<Order> getByIcAndRI(String idcard, String roomid) throws Exception {
		String orderstate = "入住";
		String newstate = "true";
		List<Order> list = dao.getByPartsByPage(idcard, null, null, roomid, orderstate, newstate, 1, 5);
		return list;
	}

	@Override
	public int updateOldRoom(String roomid) throws Exception {
		GuestRoom guestRoom = gdao.getByRoomId(roomid);
		guestRoom.setRoomstate("空闲中");
		int n = gdao.update(guestRoom);
		return n;
	}

	@Override
	public int updateNewRoom(String roomid) throws Exception {
		GuestRoom guestRoom = gdao.getByRoomId(roomid);
		guestRoom.setRoomstate("已入住");
		int n = gdao.update(guestRoom);
		return n;
	}

	/*@Override
	public int insertNewState(String idcard,String roomid) throws Exception {
		GuestRoom guestroom = gdao.getByRoomId(roomid);
		
		Order order = new Order(0, orderid, roomid, guestroom.getRoomtype().getTypename(), "入住", optype, guest, idcard, vipid, tel, time, newstate)
		int n = dao.insert(order);
		return 0;
	}*/

	@Override
	public int updateNewState(String idcard,String roomid) throws Exception {
		String newstate = "true";
		List<Order> list = dao.getByPartsByPage(idcard, null, null, null, null, newstate, 1, 10);
		Order order = list.get(0);
		String orderid = order.getOrderid();
		dao.updateState(orderid);
		GuestRoom guestroom = gdao.getByRoomId(roomid);
		
		Order order2 = new Order(0, order.getOrderid(), roomid, guestroom.getRoomtype().getRoomtype(), "入住", "换房", order.getGuest(), idcard, order.getGuest(), order.getGuest(), order.getTime(), "true");
		
		int n = dao.insert(order2);
		
		return n;
	}

	@Override
	public List<Bill> getBill(String idcard, int pageNum, int pageSize) throws Exception {
		List<Order> orderlist = getByIdcard(idcard);
		String orderid = orderlist.get(0).getOrderid();
		List<Bill> billlist = bdao.getByOrderidByPage(orderid, pageNum, pageSize);
		return billlist;
	}

	@Override
	public int getPageNumByOrderid(String idcard) throws Exception {
		List<Order> orderlist = getByIdcard(idcard);
		String orderid = orderlist.get(0).getOrderid();
		int count = bdao.getPageNumByOrderid(orderid);
		return count;
	}

	@Override
	public double getSum(String orderid) throws Exception {
		double sum = bdao.getSum(orderid);
		return sum;
	}

}
