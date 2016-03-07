package com.zgljl2012.framework.simple.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.AbstractService;
import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.service.ServiceManage;

public class ServiceManageSimple implements ServiceManage{
	
	private static String implSolder = "impl";
	private static String implSuffix = "Impl";
	
	private Controller controller;
	
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
			Class<?> cls = Class.forName(implName);
			// 获取需要传入Controller参数的构造函数
			Constructor<?> con = cls.getConstructor(Controller.class);
			return (T) con.newInstance(controller);
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
		getService(Class<T> service, Class<Impl> impl) {
		// TODO Auto-generated method stub
		return getService(service, impl.getName());
	}

	@Override
	public Controller getController() {
		// TODO Auto-generated method stub
		return controller;
	}

}
