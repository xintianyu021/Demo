package com.neu.dao;

import java.util.List;

import com.neu.entity.Order;

public interface OrderDao {
	public int insert(Order order) throws Exception; 
	public int updateState(String orderid) throws Exception; 
	public List<Order> getAllByPage(int pageNum , int pageSize) throws Exception;  
	public List<Order> getByNewstateByPage(String newstate , int pageNum , int pageSize ) throws Exception;
	public int getPageNumAll() throws Exception;  
	public int getPageNumByNewstate(String newstate ) throws Exception;
	public List<Order> getByPartsByPage(String idcard,String guest,String roomtype,String roomid,String orderstate,String newstate,int pageNum , int pageSize) throws Exception;
	public int countByParts(String idcard,String guest,String roomtype,String roomid,String orderstate,String newstate,int pageNum , int pageSize) throws Exception;
	public List<Order> getByPartsAndTimeByPage(String optype,String idcard,String guest,String roomtype,String roomid,String orderstate,String newstate, String starttime , String endtime ,int pageNum , int pageSize) throws Exception;
	public int countByPartsAndTime(String optype,String idcard,String guest,String roomtype,String roomid,String orderstate,String newstate, String starttime , String endtime ,int pageNum , int pageSize) throws Exception;
	
}

/*根据姓名身份证+订单状态+更新状态查询订单信息 表（订单日志）
	根据客房类型+订单状态+更新状态查询订单信息 表（订单日志）
	根据客房编号+订单状态+更新状态查询订单信息 表（订单日志）
	根据订单状态+更新状态查询订单信息（订单日志）
	查询订单（号）：根据身份证和更新状态查询条目（订单日志）*/
