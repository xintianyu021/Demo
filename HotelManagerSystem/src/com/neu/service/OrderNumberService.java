package com.neu.service;

import com.neu.entity.OrderNumber;

public interface OrderNumberService {
	public String getid() throws Exception;
	public int update(OrderNumber orderNumber) throws Exception; 
}
