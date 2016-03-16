package com.zgljl2012.framework.simple.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.zgljl2012.framework.aop.AopDynamicProxy;
import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.service.annotation.Impl.Null;
import com.zgljl2012.framework.simple.aop.AopDynamicProxySimple;

public class ServiceManageSimple implements ServiceManage{
	
	private static String implSolder = "impl";
	private static String implSuffix = "Impl";
	
	private Controller controller;
	
	// 动态代理
	private AopDynamicProxy adp = new AopDynamicProxySimple();
	
	// 存储实现类对象
	private static Map<String, Object> implMap = new HashMap<>();
	
	// 动态代理前置监听器
	private	static DynamicProxyBeforeListener beforeListener = new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName, Object[] args) {
				System.out.println("[PROXY-BEFORE]"+"["+targetName+"]"+methodName);
			}
			
		};
			
	private static DynamicProxyAfterListener afterListener  = new DynamicProxyAfterListener() {
		
				@Override
				public void execute(String targetName, String methodName,
						Object result, Object[] args) {
					System.out.println("[PROXY-AFTER]"+"["+targetName+"]"+methodName);
				}
				
		};
	
	public ServiceManageSimple(Controller controller) {
		this.controller = controller;
	}
	
	public <T extends Service>T getService(Class<T> service) {
		// TODO Auto-generated method stub
		String name = service.getName();
		int pos = name.lastIndexOf(".");
		String pkName = name.substring(0, pos)+"."+implSolder;
		String clsName= name.substring(pos)+implSuffix;
		name = pkName + clsName;
		return getService(service, name);
	}

	public void setImplSolder(String solder) {
		// TODO Auto-generated method stub
		implSolder = solder;
	}

	public String getImplSolder() {
		// TODO Auto-generated method stub
		return implSolder;
	}

	public void setImplSuffix(String suffix) {
		// TODO Auto-generated method stub
		implSuffix = suffix;
	}

	public String getImplSuffix() {
		// TODO Auto-generated method stub
		return implSuffix;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Service> T getService(Class<T> service, String implName) {
		try {
			if(implMap.containsKey(implName)) {
				return (T) implMap.get(implName);
			}
			Class<?> cls = Class.forName(implName);
			// 获取需要传入Controller参数的构造函数
			Constructor<?> con = cls.getConstructor(Controller.class);
			// 生成动态代理对象
			T t = (T)con.newInstance(controller);
			t = adp.setBeforeListener(beforeListener)
					.setAfterListener(afterListener)
					.buildProxyInstance(t);
			implMap.put(implName, t);
			return t;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T extends Service, Impl extends AbstractService>T 
		getService(Class<T> service, Class<?> impl) {
		// TODO Auto-generated method stub
		return getService(service, impl.getName());
	}

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return controller;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void DI(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
					if(methods != null) {
						for(Method m : methods) {
							// 如果是直接指定实现类
							if("implClass".equals(m.getName())) {
								Class<?> cls = (Class<?>)(m.invoke(anno, null));
								if(!Null.class.equals(cls)) {
									isInit = true;
									// 给属性赋值
									field.set(obj, this.getService(itfClass, cls));
								}
							}
							// 直接指定实现类的名字
							else if("implName".equals(m.getName())) {
								String s = (String) m.invoke(anno, null);
								if(!"".equals(s.trim())) {
									isInit = true;
									field.set(obj,this.getService(itfClass, s));
								}
							}
						}
					}
					if(!isInit) {
						field.set(obj, this.getService(itfClass));
					}
				}
			}
		}
		
	}

	@Override
	public void setBeforeListener(DynamicProxyBeforeListener beforeListener) {
		ServiceManageSimple.beforeListener = beforeListener;
	}

	@Override
	public void setAfterListener(DynamicProxyAfterListener afterListener) {
		// TODO Auto-generated method stub
		ServiceManageSimple.afterListener = afterListener;
	}
}
