package com.zgljl2012.framework.service;

import java.lang.reflect.InvocationTargetException;

import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;
import com.zgljl2012.framework.controller.Controller;

/**
 * 服务管理器接口，实现动态代理
 * @author Administrator
 */
public interface ServiceManage {
	
	/**
	 * 获取对应接口的实现类
	 * 其实是一种工厂方法
	 * @param service
	 * @return
	 */
	public <T extends Service>T getService(Class<T> service);
	
	/**
	 * 直接指定实现类的包名进行引用
	 * @param service
	 * @param implName
	 * @return
	 */
	public <T extends Service>T getService(Class<T> service, String implName);
	
	/**
	 * 直接指定实现类
	 * @param <Impl>
	 * @param service
	 * @param impl
	 * @return
	 */
	public <T extends Service, Impl extends AbstractService>
		T getService(Class<T> service, Class<?> impl);
	
	/**
	 * 获取Controller
	 * @return
	 */
	public Controller getController();
	
	/**
	 * 传入对象，将对对象里的有Impl注解的属性进行依赖注入实现类
	 * @param main
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 */
	public void DI(Object main) 
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;
	
	// 设置实现类的子文件夹名（限定只能使用子文件夹）
	public void setImplSolder(String solder);
	
	// 获取实现类的子文件夹名（限定只能使用子文件夹）
	public String getImplSolder();
	
	// 设置后缀
	public void setImplSuffix(String suffix);
	
	// 获取后缀
	public String getImplSuffix();
}
