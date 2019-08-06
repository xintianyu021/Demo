package com.neu.service;

import java.util.List;

import com.neu.dao.GoodsInfoDao;
import com.neu.dao.GoodsInfoDaoImpl;
import com.neu.entity.GoodsInfo;

public class GoodsInfoServiceImpl implements GoodsInfoService {

private static GoodsInfoDao dao = new GoodsInfoDaoImpl();
	
	@Override
	public int add(GoodsInfo goodsinfo) throws Exception {
		int n = dao.insert(goodsinfo);
		return n;
	}

	@Override
	public int modify(GoodsInfo goodsinfo) throws Exception {
		int n = dao.update(goodsinfo);
		return n;
	}

	@Override
	public int remove(String goodid) throws Exception {
		int n = dao.delete(goodid);
		return n;
	}

	@Override
	public List<GoodsInfo> getByGoodType(String goodtype, int pageSize, int pageNum) throws Exception {
		List<GoodsInfo> list = dao.getByType(goodtype, pageSize, pageNum);
		return list;
	}

	@Override
	public List<GoodsInfo> getAll(int pageSize, int pageNum) throws Exception {
		List<GoodsInfo> page = dao.getAll(pageSize, pageNum);
		return page;
	}

	@Override
	public GoodsInfo getByGoodId(String goodid) throws Exception {
		GoodsInfo goodInfo = dao.getById(goodid);
		return goodInfo;
	}

	@Override
	public int count() throws Exception {
		int count = dao.count();
		return count;
	}

	@Override
	public int countByType(String goodtype) throws Exception {
		int countByType = dao.countByType(goodtype);
		return countByType;
	}

}
