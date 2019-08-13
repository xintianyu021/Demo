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

/*�����������֤+����״̬+����״̬��ѯ������Ϣ ��������־��
	���ݿͷ�����+����״̬+����״̬��ѯ������Ϣ ��������־��
	���ݿͷ����+����״̬+����״̬��ѯ������Ϣ ��������־��
	���ݶ���״̬+����״̬��ѯ������Ϣ��������־��
	��ѯ�������ţ����������֤�͸���״̬��ѯ��Ŀ��������־��*/
