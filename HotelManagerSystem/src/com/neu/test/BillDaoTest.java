package com.neu.test;



import org.junit.Test;

import com.neu.dao.BillDao;
import com.neu.dao.BillDaoImpl;

public class BillDaoTest {
	
	@Test
	public void test1() {
		BillDao billDao = new BillDaoImpl();
		try {
			System.out.println(billDao.getPageNumAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
	
}
