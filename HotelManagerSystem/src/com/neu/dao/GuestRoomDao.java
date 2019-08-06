package com.neu.dao;

import java.util.List;

import com.neu.entity.GuestRoom;
import com.neu.entity.RoomType;
import com.neu.entity.Storey;

/*���ݷ��Ÿ��ķ���״̬���������
��ȡ�շ��б� �����ݷ������ͺͷ���״̬�鷿����������������ȫ������ʾ��*/
public interface GuestRoomDao {

	
	int insert(GuestRoom guest) throws Exception;
	int update(GuestRoom guest) throws Exception;
	int delete(GuestRoom guest) throws Exception;
	List<GuestRoom> getAll(int pageSize,int pageNum) throws Exception;
	List<GuestRoom> getRoom(String roomtype,String roomstate,int pageSize,int pageNum) throws Exception;
	
	List<GuestRoom> getEmptyRoom(String roomstate,int pageSize,int pageNum) throws Exception;
	
	//����
	GuestRoom  getById(int roomid,int pageSize,int pageNum) throws Exception;
	
	GuestRoom  getByRoomId(String roomid) throws Exception;
	//����
	List<GuestRoom>  getByType(RoomType roomtype ,int pageSize,int pageNum) throws Exception;
	//¥��
	List<GuestRoom>  getByStorey(Storey storey ,int pageSize,int pageNum) throws Exception;
	
	int count() throws Exception;
	
	int typeCount(String roomtype) throws Exception;
	
	int pageCount() throws Exception;
	
	//List<GuestRoom> getLikeName(String ename) throws Exception;
}
