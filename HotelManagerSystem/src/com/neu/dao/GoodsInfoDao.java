package com.neu.dao;

import java.util.List;

import com.neu.entity.GoodsInfo;
import com.neu.entity.GoodsType;

public interface GoodsInfoDao {
	int insert(GoodsInfo goodsinfo) throws Exception;
	int update(GoodsInfo goodsinfo) throws Exception;
	int delete(String goodid) throws Exception;
	List<GoodsInfo> getByType(String goodtype,int pageSize,int pageNum) throws Exception;
	List<GoodsInfo> getAll(int pageSize,int pageNum) throws Exception;
	GoodsInfo getById(String goodid) throws Exception;
	int count() throws Exception;
	int countByType(String goodtype) throws Exception;
}
