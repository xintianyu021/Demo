package com.neu.service;

import java.util.List;

import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;

public interface CheckInHotelService {
	List<RoomType> getRoomType() throws Exception;
	List<GuestRoom> getEmptyRoom(String roomstate, int pageSize, int pageNum) throws Exception;
	List<GuestRoom> getEmptyRoomByRoomType(String roomtype,String roomstate,int pageSize,int pageNum) throws Exception;
	int count() throws Exception;
	int typeCount(String roomtype) throws Exception;
	int pageCount() throws Exception;
}
