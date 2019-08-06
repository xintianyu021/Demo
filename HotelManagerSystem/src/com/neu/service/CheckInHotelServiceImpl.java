package com.neu.service;

import java.util.List;

import com.neu.dao.GuestRoomDao;
import com.neu.dao.GuestRoomDaoImpl;
import com.neu.dao.RoomTypeDao;
import com.neu.dao.RoomTypeDaoImpl;
import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;

public class CheckInHotelServiceImpl implements CheckInHotelService {
	GuestRoomDao gdao = new GuestRoomDaoImpl();
	RoomTypeDao rdao = new RoomTypeDaoImpl();
	
	@Override
	public List<RoomType> getRoomType() throws Exception {
		List<RoomType> list = rdao.getAll();
		return list;
	}

	@Override
	public List<GuestRoom> getEmptyRoom(String roomstate, int pageSize, int pageNum) throws Exception {
		List<GuestRoom> list = gdao.getEmptyRoom(roomstate, pageSize, pageNum);
		return list;
	}

	@Override
	public List<GuestRoom> getEmptyRoomByRoomType(String roomtype, String roomstate, int pageSize, int pageNum)
			throws Exception {
		List<GuestRoom> list = gdao.getRoom(roomtype, roomstate, pageSize, pageNum);
		return list;
	}

	@Override
	public int count() throws Exception {
		int count = gdao.count();
		return count;
	}

	@Override
	public int typeCount(String roomtype) throws Exception {
		int counts = gdao.typeCount(roomtype);
		return counts;
	}

	@Override
	public int pageCount() throws Exception {
		int counts = gdao.pageCount();
		return counts;
	}

}
