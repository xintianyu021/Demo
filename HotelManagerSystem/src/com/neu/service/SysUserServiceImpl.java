package com.neu.service;

import com.neu.dao.SysuserDao;
import com.neu.dao.SysuserDaoImpl;
import com.neu.entity.Sysuser;

public class SysUserServiceImpl implements SysUserService {
	SysuserDao dao = new SysuserDaoImpl();
	@Override
	public int modify(Sysuser sys) throws Exception {
		int n = dao.update(sys);
		return n;
	}

	@Override
	public int add(Sysuser sys) throws Exception {
		int n = dao.insert(sys);
		return n;
	}

	@Override
	public int remove(String userid) throws Exception {
		Sysuser sys = dao.getByid(userid);
		int n = dao.delete(sys.getId());
		return n;
	}

	@Override
	public Sysuser getByIdName(String userid, String username) throws Exception {
		Sysuser sys = dao.getByidname(userid, username);
		return sys;
	}

	@Override
	public Sysuser getById(String userid) throws Exception {
		Sysuser sys = dao.getByid(userid);
		return sys;
	}

	@Override
	public Sysuser getByName(String username) throws Exception {
		Sysuser sys = dao.getByname(username);
		return sys;
	}

}
