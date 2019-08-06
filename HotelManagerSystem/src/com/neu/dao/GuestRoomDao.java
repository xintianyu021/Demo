package com.neu.dao;

import java.util.List;

import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;
import com.neu.entity.Storey;

/*根据房号更改房间状态：（房间表）
获取空房列表 ：根据房间类型和房间状态查房间表（房间表）（还得有全类型显示）*/
public interface GuestRoomDao {

	
	int insert(GuestRoom guest) throws Exception;
	int update(GuestRoom guest) throws Exception;
	int delete(GuestRoom guest) throws Exception;
	List<GuestRoom> getAll(int pageSize,int pageNum) throws Exception;
	List<GuestRoom> getRoom(String roomtype,String roomstate,int pageSize,int pageNum) throws Exception;
	
	List<GuestRoom> getEmptyRoom(String roomstate,int pageSize,int pageNum) throws Exception;
	
	//房号
	GuestRoom  getById(int roomid,int pageSize,int pageNum) throws Exception;
	
	GuestRoom  getByRoomId(String roomid) throws Exception;
	//类型
	List<GuestRoom>  getByType(RoomType roomtype ,int pageSize,int pageNum) throws Exception;
	//楼层
	List<GuestRoom>  getByStorey(Storey storey ,int pageSize,int pageNum) throws Exception;
	
	int count() throws Exception;
	
	int typeCount(String roomtype) throws Exception;
	
	int pageCount() throws Exception;
	
	//List<GuestRoom> getLikeName(String ename) throws Exception;
}
