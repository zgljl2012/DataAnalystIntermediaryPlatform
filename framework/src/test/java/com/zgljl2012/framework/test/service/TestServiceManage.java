package com.zgljl2012.framework.test.service;

import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;

public class TestServiceManage {
	String solder = "impl";
	String suffix = "Impl";
	ServiceManage serviceManage;
	
	@Before
	public void before() {
		serviceManage = new ServiceManageSimple();
	}
	
	@Test
	public void test() {
		Hello h = serviceManage.getService(Hello.class);
		h.say();
	}
	
	@Test
	public void test2() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		String name = "com.zgljl2012.framework.test.impl.HelloImpl";
		Hello hello = (Hello) Class.forName(name).newInstance();
		hello.say();
	}
}
