package com.zgljl2012.framework.aop;


/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:29:38
 * 动态代理监听器,可以在这里切入功能在方法执行后
 */
public interface DynamicProxyAfterListener {
	/**
	 * 后置条件
	 * @param proxyName 委托对象名称
	 * @param methodName 方法名
	 * @param result 方法执行结果
	 * @param args 方法参数
	 */
	public void execute(String targetName, String methodName, 
			Object result, Object[] args);
}
