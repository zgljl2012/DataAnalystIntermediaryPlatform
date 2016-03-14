package com.zgljl2012.framework.simple.system;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

import javax.servlet.ServletContextEvent;

import org.easymock.EasyMock;

import com.zgljl2012.framework.system.SystemInitialize;
import com.zgljl2012.framework.system.SystemShutdownListener;
import com.zgljl2012.framework.system.SystemStartupListener;
import com.zgljl2012.framework.util.ScannerUtil;

/**
 * @author 廖金龙
 * @version 2016年3月14日下午9:08:43
 * 
 */
public class SystemInitializeSimple implements SystemInitialize{

	@Override
	public Set<Class<?>> scanner(String pkgName) {
		return ScannerUtil.getClasses(pkgName);
	}

	@Override
	public void initStartup(String pkgName, ServletContextEvent context) {
		init(pkgName, SystemStartupListener.class, "startup", new Class<?>[]{ServletContextEvent.class}, new Object[]{context});
	}

	@Override
	public void initShutdown(String pkgName, ServletContextEvent context) {
		init(pkgName, SystemShutdownListener.class, "shutdown", new Class<?>[]{ServletContextEvent.class}, new Object[]{context});
	}
	
	public void init(String pkgName, Class<?> superCls, String methodName, Class<?>[] argClss, Object[] args) {
		Set<Class<?>> set = ScannerUtil.getClasses(pkgName);
		for(Class<?> cls : set) {
			if(!cls.getName().contains("$")) { // 不是代理类
				if(superCls.isAssignableFrom(cls)&&!cls.isInterface()) { // 继承自SystemStartupListener的类
					// 执行方法
					Method method;
					try {
						method = cls.getDeclaredMethod(methodName, argClss);
						if(method.isAccessible()) {
							method.setAccessible(true);
						}
						method.invoke(cls.newInstance(), args);
					} catch (NoSuchMethodException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		}
	}

}
