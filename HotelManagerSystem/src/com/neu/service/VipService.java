package com.neu.service;

import java.util.List;

import com.neu.entity.Vip;

public interface VipService {
	int add(Vip vip) throws Exception;
	int modify(Vip vip) throws Exception;
	int remove(String vipid) throws Exception;
	
	List<Vip> getByGuest(String guest,int pageSize,int pageNum) throws Exception;
	int counts(String guest) throws Exception;
	Vip getByVipid(String vipid) throws Exception;
	Vip getByIdGuest(String vipid,String guest) throws Exception;
}
