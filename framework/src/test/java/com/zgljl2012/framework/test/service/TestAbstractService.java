package com.zgljl2012.framework.test.service;

import java.sql.Timestamp;

import org.easymock.EasyMock;
import org.junit.Test;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;

/**
 *@author 廖金龙
 *@version 2016年2月25日下午9:41:16
 */
public class TestAbstractService {
	
	@Test
	public void testGetNowTimestamp() {
		Controller controller = EasyMock.createMock(Controller.class);
		AbstractService as = new AbstractService(controller){
			
		};
		Timestamp ts = as.getNowTimestamp();
		System.out.println(ts);
	}
}
