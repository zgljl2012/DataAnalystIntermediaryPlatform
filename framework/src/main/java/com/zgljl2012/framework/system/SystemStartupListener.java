package com.zgljl2012.framework.system;

import com.zgljl2012.framework.controller.Controller;

/**
 * @author 廖金龙
 * @version 2016年3月13日下午4:56:56
 * 系统启动监听器
 */
public interface SystemStartupListener {
	
	public void startup(Controller controller);
	
}
