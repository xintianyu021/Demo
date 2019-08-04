package com.neu.service;

import java.util.List;

import com.neu.dao.VipDao;
import com.neu.dao.VipDaoImpl;
import com.neu.entity.Vip;

public class VipServiceImpl implements VipService {
	private static VipDao dao = new VipDaoImpl();
	@Override
	public int add(Vip vip) throws Exception {
		int n = dao.insert(vip);
		return n;
	}

	@Override
	public int modify(Vip vip) throws Exception {
		int n = dao.update(vip);
		return n;
	}

	@Override
	public int remove(String vipid) throws Exception {
		int n = dao.delete(vipid);
		return n;
	}

	@Override
	public List<Vip> getByGuest(String guest,int pageSize,int pageNum) throws Exception {
		List<Vip> list = dao.getByName(guest, pageSize, pageNum);
		return list;
	}

	@Override
	public Vip getByVipid(String vipid) throws Exception {
		Vip vip = dao.getById(vipid);
		return vip;
	}

	@Override
	public int counts(String guest) throws Exception {
		int counts = dao.count(guest);
		return counts;
	}

	@Override
	public Vip getByIdGuest(String vipid, String guest) throws Exception {
		Vip vip = dao.getByIdName(vipid, guest);
		return vip;
	}

}
