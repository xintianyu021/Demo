package com.neu.service;

import java.util.List;


import com.neu.dao.GoodsTypeDao;
import com.neu.dao.GoodsTypeDaoImpl;

import com.neu.entity.GoodsType;

public class GoodsTypeServiceImpl implements GoodsTypeService {
	private static GoodsTypeDao dao = new GoodsTypeDaoImpl();

	@Override
	public int add(GoodsType goodstype) throws Exception {
		int n = dao.insert(goodstype);
		return n;
	}

	@Override
	public int modify(GoodsType goodstype) throws Exception {
		int n = dao.update(goodstype);
		return n;
	}

	@Override
	public int remove(String goodtype) throws Exception {
		int n = dao.delete(goodtype);
		return n;
	}

	@Override
	public List<GoodsType> getAll(int pageSize, int pageNum) throws Exception {
		List<GoodsType> list = dao.getAll(pageSize, pageNum);
		return list;
	}

	@Override
	public GoodsType getById(String goodtype) throws Exception {
		GoodsType goodstype = dao.getById(goodtype);
		return goodstype;
	}

	@Override
	public int count() throws Exception {
		int pages = dao.count();
		return pages;
	}

	@Override
	public List<GoodsType> getList() throws Exception {
		List<GoodsType> list = dao.getList();
		return list;
	}

	
	
	

}
