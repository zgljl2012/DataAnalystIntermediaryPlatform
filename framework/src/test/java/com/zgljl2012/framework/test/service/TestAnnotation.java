package com.zgljl2012.framework.test.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.service.annotation.Impl.Null;
import com.zgljl2012.framework.simple.service.ServiceManageSimple;

/**
 * @author 廖金龙
 * @version 2016年3月9日下午11:29:15
 * 依赖注入测试类 
 */
public class TestAnnotation {

	@Impl(implName="hello")
	Hello hello;
	
	Controller controller;
	ServiceManage serviceManage;
	
	@Before
	public void before() {
		// 给controller创建一个Mock对象
		controller = EasyMock.createMock(Controller.class);
		serviceManage = new ServiceManageSimple(controller);
		
	}
	
	@Test
	public void test() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 依赖注入
		di();
		System.out.println("测试完成.");
	}
	
	
	private void di() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// 获取所有属性
		Field[] fields = this.getClass().getDeclaredFields();
		boolean isInit = false;
		if(fields != null) {
			for(Field field : fields) {
				// 获取Impl注解
				Annotation anno = field.getAnnotation(Impl.class);
				if(anno != null) {
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
									System.out.println("1");
									isInit = true;
								}
							}
							// 直接指定实现类的名字
							else if("implName".equals(m.getName())
									&&!"".equals(m.getName().trim())) {
								System.out.println("2");
								isInit = true;
							}
						}
					}
					if(!isInit) {
						System.out.println(3);
					}
				}
			}
		}
	}
	
}
