package com.neu.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.neu.dao.OrderNumberDao;
import com.neu.dao.OrderNumberDaoImpl;
import com.neu.entity.OrderNumber;

public class OrderNumberServiceImpl implements OrderNumberService {
	
	OrderNumberDao orderNumberDao = new OrderNumberDaoImpl();
	
	@Override
	public String getid() throws Exception {
		Date time = new Date();
		
		SimpleDateFormat s = new SimpleDateFormat("yyyyMMdd");
		String idhat = "3110";
		String idhead = s.format(time);
		String idtail = "";
		
		OrderNumber orderNumber = orderNumberDao.get();
		if(orderNumber.getDate().equals(idhead)) {
			idtail = Integer.toString(orderNumber.getNum()+1);
			while(idtail.length() < 5) {
				idtail = "0"+idtail;
			}
			
			orderNumber.setNum(orderNumber.getNum()+1);
			int n = orderNumberDao.update(orderNumber);
		}
		else {
			idtail = "00001";
			orderNumber.setDate(idhead);
			orderNumber.setNum(1);
			int n = orderNumberDao.update(orderNumber);
		}
		
		String result = idhat + idhead + idtail;
		
		return result;
	}

	@Override
	public int update(OrderNumber orderNumber) throws Exception {
		int n = orderNumberDao.update(orderNumber);
		return n;
	}

}
