package com.neu.service;

import java.util.List;

import com.neu.entity.GoodsInfo;

public interface GoodsInfoService {
	int add(GoodsInfo goodsinfo) throws Exception;
	int modify(GoodsInfo goodsinfo) throws Exception;
	int remove(String goodid) throws Exception;
	List<GoodsInfo> getByGoodType(String goodtype,int pageSize,int pageNum) throws Exception;
	List<GoodsInfo> getAll(int pageSize,int pageNum) throws Exception;
	GoodsInfo getByGoodId(String goodid) throws Exception;
	int count() throws Exception;
	int countByType(String goodtype) throws Exception;
}
