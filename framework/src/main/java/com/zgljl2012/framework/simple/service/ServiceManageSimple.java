package com.zgljl2012.framework.simple.service;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.service.annotation.Impl;
import com.zgljl2012.framework.service.annotation.Impl.Null;

public class ServiceManageSimple implements ServiceManage{
	
	private static String implSolder = "impl";
	private static String implSuffix = "Impl";
	
	private Controller controller;
	
	// 存储实现类对象
	private static Map<String, AbstractService> implMap = new HashMap<>();
	
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
			implMap.put(implName, (AbstractService) con.newInstance(controller));
			return (T)con.newInstance(controller);
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
}
