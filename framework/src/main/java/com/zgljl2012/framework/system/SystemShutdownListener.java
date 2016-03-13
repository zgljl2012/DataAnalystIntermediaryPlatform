package com.zgljl2012.framework.system;

import javax.servlet.ServletContextEvent;

/**
 * @author 廖金龙
 * @version 2016年3月13日下午5:00:04
 * 系统关闭监听器
 */
public interface SystemShutdownListener {
	
	public void shutdown(ServletContextEvent context);
}
