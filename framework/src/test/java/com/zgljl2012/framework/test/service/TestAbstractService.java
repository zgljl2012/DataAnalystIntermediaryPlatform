package com.zgljl2012.framework.test.service;

import java.sql.Timestamp;

import org.junit.Test;

import com.zgljl2012.framework.service.AbstractService;

/**
 *@author 廖金龙
 *@version 2016年2月25日下午9:41:16
 */
public class TestAbstractService {
	
	@Test
	public void testGetNowTimestamp() {
		AbstractService as = new AbstractService(){
			
		};
		Timestamp ts = as.getNowTimestamp();
		System.out.println(ts);
	}
}
