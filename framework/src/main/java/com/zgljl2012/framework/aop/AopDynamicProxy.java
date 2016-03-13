package com.zgljl2012.framework.aop;

import java.lang.reflect.InvocationHandler;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:22:05
 * 动态代理实现的AOP框架
 */
public interface AopDynamicProxy extends InvocationHandler{
	
	/**
	 * 获取代理对象，建造者模式，需要先将其他条件设置好
	 * @param object 委托对象
	 * @return
	 */
	public <T>T buildProxyInstance(Object target);
	
	/**
	 * 设置方法执行前前置监听器
	 * @param beforeListener
	 */
	public AopDynamicProxy setBeforeListener(DynamicProxyBeforeListener beforeListener);
	
	/**
	 * 设置方法执行后后置监听器
	 * @param afterListener
	 */
	public AopDynamicProxy setAfterListener(DynamicProxyAfterListener afterListener);
	
}
