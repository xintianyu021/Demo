package com.neu.dao;

import java.util.List;

import com.neu.entity.GuestRoom;

public interface GuestRoomDao {

	List<GuestRoom> getAll(int pageSize,int pageNum) throws Exception;
	int insert(GuestRoom guest) throws Exception;
	int update(GuestRoom guest) throws Exception;
	int delete(GuestRoom guest) throws Exception;
	//����
	GuestRoom  getById(String roomid,int pageSize,int pageNum) throws Exception;
	//����
	List<GuestRoom>  getByType(String roomtype ,int pageSize,int pageNum) throws Exception;
	//¥��
	List<GuestRoom>  getByStorey(String storey ,int pageSize,int pageNum) throws Exception;
	
	
	//List<GuestRoom> getLikeName(String ename) throws Exception;
}
