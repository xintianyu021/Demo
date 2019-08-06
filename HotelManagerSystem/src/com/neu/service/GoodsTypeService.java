package com.neu.service;

import java.util.List;


import com.neu.entity.GoodsType;

public interface GoodsTypeService {
	int add(GoodsType goodstype) throws Exception;
	int modify(GoodsType goodstype) throws Exception;
	int remove(String goodtype) throws Exception;
	List<GoodsType> getAll(int pageSize,int pageNum) throws Exception;
	GoodsType getById(String goodtype) throws Exception;
	int count() throws Exception;
	List<GoodsType> getList() throws Exception;
}
