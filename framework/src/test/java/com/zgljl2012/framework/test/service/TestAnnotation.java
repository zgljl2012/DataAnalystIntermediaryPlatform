package com.zgljl2012.framework.test.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.service.annotation.Impl.Null;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;
import com.zgljl2012.framework.test.service.impl.HelloImpl;

/**
 * @author 廖金龙
 * @version 2016年3月9日下午11:29:15
 * 依赖注入测试类 
 */
public class TestAnnotation {

	@Impl
	Hello hello;
	
	@Impl(implName="com.zgljl2012.framework.test.service.impl.HelloImpl")
	Hello helloWithName;
	
	@Impl(implClass=HelloImpl.class) 
	Hello helloWithClass;
	
	Controller controller;
	ServiceManage serviceManage;
	
	@Before
	public void before() {
		// 给controller创建一个Mock对象
		controller = EasyMock.createMock(Controller.class);
		serviceManage = new ServiceManageSimple(controller);
	}
	
	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 依赖注入
		di(this);
		System.out.println("不带属性："+hello.say());
		System.out.println("带上implName属性："+helloWithName.say());
		System.out.println("带上implClass属性："+helloWithClass.say());
		System.out.println("测试完成.");
	}
	
	@Test
	public void testDI() 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		serviceManage.DI(this);
		System.out.println("不带属性："+hello.say());
		System.out.println("带上implName属性："+helloWithName.say());
		System.out.println("带上implClass属性："+helloWithClass.say());
		System.out.println("测试完成.");
	}
	
	
	@SuppressWarnings("unchecked")
	private void di(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		// 获取所有属性
		Field[] fields = obj.getClass().getDeclaredFields();
		boolean isInit = false;
		if(fields != null) {
			for(Field field : fields) {
				// 获取Impl注解
				Annotation anno = field.getAnnotation(Impl.class);
				if(anno != null) {
					field.setAccessible(true);
					// 获取接口的类类型
					Class<? extends Service> itfClass = (Class<? extends Service>) field.getType();
					isInit = false;
					// 获取注解的值
					Method[] methods = anno.getClass().getDeclaredMethods();
					String implName = "";
					if(methods != null) {
						for(Method m : methods) {
							// 如果是直接指定实现类
							if("implClass".equals(m.getName())) {
								Class<?> cls = (Class<?>)(m.invoke(anno, null));
								if(!Null.class.equals(cls)) {
									isInit = true;
									// 给属性赋值
									field.set(obj, serviceManage.getService(itfClass, cls));
								}
							}
							// 直接指定实现类的名字
							else if("implName".equals(m.getName())) {
								String s = (String) m.invoke(anno, null);
								if(!"".equals(s.trim())) {
									isInit = true;
									field.set(obj,serviceManage.getService(itfClass, s));
								}
							}
						}
					}
					if(!isInit) {
						field.set(obj, serviceManage.getService(itfClass));
					}
				}
			}
		}
	}
	
}
