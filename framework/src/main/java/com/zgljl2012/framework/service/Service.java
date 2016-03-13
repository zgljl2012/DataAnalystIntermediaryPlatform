package com.zgljl2012.framework.service;

import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;
import com.zgljl2012.framework.controller.Controller;

/**
 * 服务
 * @author Administrator
 */
public interface Service {
	
	/**
	 * 获取控制器
	 * @return
	 */
	public Controller getController();
	
}
