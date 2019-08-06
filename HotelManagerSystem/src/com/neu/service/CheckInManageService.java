package com.neu.service;

import java.util.List;

import com.neu.entity.Bill;
import com.neu.entity.Order;


public interface CheckInManageService {
	public List<Order> getAllCheckOrder(int pageNum,int pageSize) throws Exception;
	public int countOfAll() throws Exception;
	public List<Order> getByIdcard(String idcard) throws Exception;
	public List<Order> getByRoomId(String roomid) throws Exception;
	public List<Order> getByIcAndRI(String idcard,String roomid) throws Exception;
	public int updateOldRoom(String roomid) throws Exception;
	public int updateNewRoom(String roomid) throws Exception;
	public int updateNewState(String idcard,String roomid) throws Exception;
	public List<Bill> getBill(String idcard,int pageNum,int pageSize) throws Exception;
	public int getPageNumByOrderid(String idcard ) throws Exception;
	public double getSum(String orderid) throws Exception;
}
