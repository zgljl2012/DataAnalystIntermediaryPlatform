package com.zgljl2012.framework.test.aop;

import junit.framework.Assert;

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
		Hello h = adp.buildProxyInstance(new HelloImpl(controller));
		Assert.assertEquals(h.say(),"Hello");
		System.out.println("test finished.");
	}
	
	
	@Test
	public void testBeforeListener() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		adp.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				log.console(targetName+" "+methodName);
			}
		});

		Hello h = adp.buildProxyInstance(new HelloImpl(controller));
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	@Test
	public void testAfterListener() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		adp.setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				log.console("after...");
			}

			
		});

		Hello h = adp.buildProxyInstance(new HelloImpl(controller));
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	@Test
	public void testBoth() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp
				.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				log.console("before...");
			}
		}).setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				log.console("after...");
			}

			
		}).buildProxyInstance(new HelloImpl(controller));
		System.out.println(h.say());
		System.out.println("test finished.");
	}
	
	//@Test
	public void testTwoImpl() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		Hello h = adp.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				System.out.println("before...");
			}
		}).setAfterListener(new DynamicProxyAfterListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				System.out.println("after...");
			}
		}).buildProxyInstance(new HelloImpl(controller));
		Hello2 h2 = adp.buildProxyInstance(new Hello2Impl(controller));
		System.out.println(h2.say());
		System.out.println(h.say());
	}
	
	DynamicProxyBeforeListener beforeListener = new DynamicProxyBeforeListener() {

		@Override
		public void execute(String targetName, String methodName,
				Object[] args) {
			System.out.println("[PROXY-BEFORE]"+"["+targetName+"]"+methodName);
		}
	};
	
	DynamicProxyAfterListener afterListener = new DynamicProxyAfterListener() {

		@Override
		public void execute(String targetName, String methodName,
				Object result, Object[] args) {
			System.out.println("[PROXY-AFTER]"+"["+targetName+"]"+methodName);
		}
	};
	
	@Test 
	public void testMutilMethod() {
		AopDynamicProxySimple adp = new AopDynamicProxySimple();
		Controller controller = EasyMock.createMock(Controller.class);
		EasyMock.expect(controller.getDatabaseProvider()).andReturn(null);
		EasyMock.replay(controller);
		Hello2Impl impl = new Hello2Impl(controller);
		Hello2 h = adp.setAfterListener(afterListener)
					.setBeforeListener(beforeListener)
					.buildProxyInstance(impl);
		h.hello1();
		h.hello2();
		h.hello3();
		
		Hello2 h2 = adp.setAfterListener(afterListener)
				.setBeforeListener(beforeListener)
				.buildProxyInstance(impl);
		h2.hello1();
		h2.hello2();
		h2.hello3();
		
		Hello2 h3 = adp.setAfterListener(afterListener)
				.setBeforeListener(beforeListener)
				.buildProxyInstance(impl);
		h3.hello1();
		h3.hello2();
		h3.hello3();
	
	}
}
