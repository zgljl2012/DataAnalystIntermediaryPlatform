package com.zgljl2012.framework.test.system;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.ServletContextEvent;

import org.easymock.EasyMock;
import org.junit.Test;

import com.zgljl2012.framework.system.SystemStartupListener;
import com.zgljl2012.framework.system.TestStartup;
import com.zgljl2012.framework.util.ScannerUtil;

public class TestClassScanner {
	
	@Test
	public void testSubClass() {
		Class<SystemStartupListener> a = SystemStartupListener.class;
		Class<TestStartup> b = TestStartup.class;
		System.out.println(b.isAssignableFrom(a));
	}
	
	@Test
	public void test() 
			throws NoSuchMethodException, SecurityException, 
			IllegalAccessException, IllegalArgumentException, 
			InvocationTargetException, InstantiationException{
		Set<Class<?>> set = ScannerUtil.getClasses("com.zgljl2012");
		for(Class<?> cls : set) {
			if(!cls.getName().contains("$")) { // 不是代理类
				if(SystemStartupListener.class.isAssignableFrom(cls)&&!cls.isInterface()) { // 继承自SystemStartupListener的类
					System.out.println(cls.getName());
					// 执行方法
					Method method = cls.getMethod("startup", ServletContextEvent.class);
					method.setAccessible(true);
					System.out.println(method.isAccessible());
					ServletContextEvent sce = EasyMock.createMock(ServletContextEvent.class);
					method.invoke(cls.newInstance(), sce);
				}
			}
		}
	}
	
	
}
