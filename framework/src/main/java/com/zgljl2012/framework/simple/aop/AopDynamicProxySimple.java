package com.zgljl2012.framework.simple.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.zgljl2012.framework.aop.AopDynamicProxy;
import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:40:48
 * Aop框架实现类
 */
public class AopDynamicProxySimple implements AopDynamicProxy{
	
	// 委托对象
	Object target = null;
	// 前置条件
	DynamicProxyBeforeListener beforeListener;
	// 后置条件
	DynamicProxyAfterListener afterListener;
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		String targetName = target.getClass().getName();
		String methodName = method.getName();
		if(this.beforeListener != null) {
			this.beforeListener.execute(targetName, methodName, args);
		}
		Object result = null;
		try {
			result = (Object)method.invoke(target, args);
			if(this.afterListener != null) {
				this.afterListener.execute(targetName, methodName, result, args);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T getProxyInstance(Object target) {
		this.target = target;
		ClassLoader cl = target.getClass().getClassLoader();
		Class<?>[] cs = target.getClass().getInterfaces();
		try {
			T t = (T)Proxy.newProxyInstance(cl, cs, this);
			return t;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void setBeforeListener(DynamicProxyBeforeListener beforeListener) {
		this.beforeListener = beforeListener;
	}

	@Override
	public void setAfterListener(DynamicProxyAfterListener afterListener) {
		this.afterListener = afterListener;
	}

}
