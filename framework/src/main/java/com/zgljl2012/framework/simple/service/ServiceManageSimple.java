package com.zgljl2012.framework.simple.service;

import com.zgljl2012.framework.service.Service;
import com.zgljl2012.framework.service.ServiceManage;

public class ServiceManageSimple implements ServiceManage{
	
	private static String implSolder = "impl";
	private static String implSuffix = "Impl";
	
	@SuppressWarnings("unchecked")
	public <T extends Service>T getService(Class<T> service) {
		// TODO Auto-generated method stub
		String name = service.getName();
		int pos = name.lastIndexOf(".");
		String pkName = name.substring(0, pos)+"."+implSolder;
		String clsName= name.substring(pos)+implSuffix;
		name = pkName + clsName;
		try {
			Class<?> cls = Class.forName(name);
			return (T) cls.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

}
