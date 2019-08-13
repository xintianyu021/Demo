package com.neu.dao;

import java.util.List;

import com.neu.entity.RoomType;

public interface RoomTypeDao {
	public List<RoomType> getAll(int pageSize,int pageNum) throws Exception;
	public List<RoomType> getAll() throws Exception;
	public RoomType getById(String roomtype) throws Exception;
	public int insert(RoomType roomtype) throws Exception;
	public int update(RoomType roomtype) throws Exception;
	public int delete(String roomtype) throws Exception;
	public int count() throws Exception;
}
