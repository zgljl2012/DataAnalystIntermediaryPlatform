package com.zgljl2012.framework.simple.aop;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

import com.zgljl2012.framework.aop.AopDynamicProxy;
import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;

/**
 * @author 廖金龙
 * @version 2016年3月12日上午12:40:48
 * Aop框架实现类
 */
public class AopDynamicProxySimple implements AopDynamicProxy{
	
	// 前置条件
	DynamicProxyBeforeListener beforeListener;
	// 后置条件
	DynamicProxyAfterListener afterListener;
	
	private Map<String, Savebean> map = new HashMap<>();
	
	private class Default implements AopDynamicProxy{
		
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
			result = (Object)method.invoke(target, args);
			if(this.afterListener != null) {
				this.afterListener.execute(targetName, methodName, result, args);
			}
			return result;
		}

		@SuppressWarnings("unchecked")
		@Override
		public <T> T buildProxyInstance(Object target) {
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
		public AopDynamicProxy setBeforeListener(DynamicProxyBeforeListener beforeListener) {
			this.beforeListener = beforeListener;
			return this;
		}

		@Override
		public AopDynamicProxy setAfterListener(DynamicProxyAfterListener afterListener) {
			this.afterListener = afterListener;
			return this;
		}
		
		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			System.out.println("this object collection By GC");
			super.finalize();
			
		}
		
	}
	
	private class Savebean {
		Default m;
		// 前置条件
		DynamicProxyBeforeListener beforeListener;
		// 后置条件
		DynamicProxyAfterListener afterListener;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		return null;
	}

	@Override
	public <T> T buildProxyInstance(Object target) {
		Savebean bean = null;
		if(map.get(target.getClass().getName()) != null) {
			bean = map.get(target.getClass().getName());
		} else {
			bean = new Savebean();
			bean.m = new Default();
			bean.afterListener = this.afterListener;
			bean.beforeListener = this.beforeListener;
		}
		T t = bean.m.setAfterListener(bean.afterListener).
				setBeforeListener(bean.beforeListener).
				buildProxyInstance(target);
		map.put(target.getClass().getName(), bean);
		this.afterListener = null;
		this.beforeListener = null;
		return t;
	}

	@Override
	public AopDynamicProxy setBeforeListener(DynamicProxyBeforeListener beforeListener) {
		this.beforeListener = beforeListener;
		return this;
	}

	@Override
	public AopDynamicProxy setAfterListener(DynamicProxyAfterListener afterListener) {
		this.afterListener = afterListener;
		return this;
	}

}
