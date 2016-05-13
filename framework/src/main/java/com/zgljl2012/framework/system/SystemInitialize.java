package com.zgljl2012.framework.system;

import java.util.Set;

import javax.servlet.ServletContextEvent;

import com.zgljl2012.framework.controller.Controller;

/**
 * @author 廖金龙
 * @version 2016年3月14日下午9:03:47
 * 系统初始化函数
 */
public interface SystemInitialize {
	
	/**
	 * 扫描这个包下的所有文件
	 * @param pkgName
	 */
	public Set<Class<?>> scanner(String pkgName);
	
	/**
	 * 启动所有继承了Startup接口的类
	 */
	void initStartup(String pkgName, Controller controller);
	
	/**
	 * 启动所有继承了Shutdown接口的类
	 */
	void initShutdown(String pkgName, Controller controller);
}
