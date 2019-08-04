package com.neu.dao;

import java.util.List;

import com.neu.entity.Train;

public interface TrainDao {
	List<Train> getAll() throws Exception;
	Train getById(String trainno) throws Exception;
	int delete(String trainno) throws Exception;
	
	List<Train> getPage(int pageSize,int pageNum) throws Exception;
	int count() throws Exception;
}
