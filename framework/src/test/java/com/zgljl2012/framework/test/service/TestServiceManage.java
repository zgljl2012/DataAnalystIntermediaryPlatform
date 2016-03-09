package com.zgljl2012.framework.test.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;
import com.zgljl2012.framework.test.service.impl.HelloImpl;

public class TestServiceManage {
	String solder = "impl";
	String suffix = "Impl";
	ServiceManage serviceManage;
	@Before
	public void before() {
		Controller controller = EasyMock.createMock(Controller.class);
		serviceManage = new ServiceManageSimple(controller);
	}
	
	@Test
	public void test() {
		Hello h = serviceManage.getService(Hello.class);
		Assert.assertEquals(h.say(), "Hello");
	}
	
	@Test
	public void test1() {
		Hello h = serviceManage.getService(Hello.class, HelloImpl.class.getName());
		System.out.println(HelloImpl.class.getName());
		h.say();
	}
	
	@Test
	public void test2() {
		Hello h = serviceManage.getService(Hello.class, HelloImpl.class);
		h.say();
	}
	
	@Test
	public void test0() throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException{
		String name = "com.zgljl2012.framework.test.service.impl.HelloImpl";
		Class<?> cls = Class.forName(name);
		Constructor<?> c = cls.getConstructor(Controller.class);
		Hello hello = (Hello) c.newInstance(serviceManage.getController());
		hello.say();
	}
}
