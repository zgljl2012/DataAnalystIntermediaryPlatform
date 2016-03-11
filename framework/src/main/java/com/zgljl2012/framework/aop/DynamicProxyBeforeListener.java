package com.zgljl2012.framework.aop;


/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:25:31
 * 动态代理监听器,可以在这里切入功能在方法执行前
 */
public interface DynamicProxyBeforeListener {
	
	/**
	 * 前置条件
	 * @param proxyName 委托对象的名称
	 * @param methodName 方法名称
	 * @param args 方法参数
	 */
	public void execute(String targetName, String methodName, Object[] args);
	
}
