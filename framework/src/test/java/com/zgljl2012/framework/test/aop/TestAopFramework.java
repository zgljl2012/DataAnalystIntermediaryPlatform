package com.zgljl2012.framework.test.aop;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Test;

import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.log.AbstractLog;
import com.zgljl2012.framework.simple.aop.AopDynamicProxySimple;
import com.zgljl2012.framework.simple.log.LogSimple;
import com.zgljl2012.framework.test.service.Hello;
import com.zgljl2012.framework.test.service.impl.HelloImpl;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:51:23
 * 
 */
public class TestAopFramework {
	
	AbstractLog log = new LogSimple();
	
	@Test
	public void testWithoutListener(){
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.getProxyInstance(new HelloImpl(controller));
		Assert.assertEquals(h.say(),"Hello");
		System.out.println("test finished.");
	}
	
	
	@Test
	public void testBeforeListener() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.getProxyInstance(new HelloImpl(controller));
		adp.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				log.console(targetName+" "+methodName);
			}
		});
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	@Test
	public void testAfterListener() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.getProxyInstance(new HelloImpl(controller));
		adp.setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				log.console("after...");
			}

			
		});
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	@Test
	public void testBoth() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.getProxyInstance(new HelloImpl(controller));
		adp.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				log.console("before...");
			}
		});
		adp.setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				log.console("after...");
			}

			
		});
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	@Test
	public void testTwoImpl() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.getProxyInstance(new HelloImpl(controller));
		adp.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				System.out.println("before...");
			}
		});
		adp.setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				System.out.println("after...");
			}
		});
		//log.console(h.say());
		adp = null;
		adp = new AopDynamicProxySimple();
		Hello2 h2 = adp.getProxyInstance(new Hello2Impl());
		System.out.println(h2.say());
		System.out.println(h.say());
	}
}
