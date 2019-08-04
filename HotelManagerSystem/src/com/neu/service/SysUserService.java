package com.neu.service;

import com.neu.entity.Sysuser;

public interface SysUserService {
	int modify(Sysuser sys) throws Exception;
	int add(Sysuser sys) throws Exception;
	int remove(String id) throws Exception;
	Sysuser getByIdName(String userid,String username) throws Exception;
	Sysuser getById(String userid) throws Exception;
	Sysuser getByName(String username) throws Exception;
}
