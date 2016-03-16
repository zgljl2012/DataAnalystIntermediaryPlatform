package com.zgljl2012.common.system;

import javax.servlet.ServletContextEvent;

import com.zgljl2012.framework.aop.DynamicProxyAfterListener;
import com.zgljl2012.framework.aop.DynamicProxyBeforeListener;
import com.zgljl2012.framework.controller.Controller;
import com.zgljl2012.framework.service.ServiceManage;
import com.zgljl2012.framework.system.SystemStartupListener;

/**
 * @author 廖金龙
 * @version 2016年3月16日下午7:54:09
 * 系统启动时将进行系统初始化
 */
public class SystemInit //implements SystemStartupListener
{

	//@Override
	public void startup(ServletContextEvent context) {
		// TODO Auto-generated method stub
		Controller controller = (Controller) 
				context.getServletContext().getAttribute("controller");
		ServiceManage sm = controller.getServiceManage();
		controller.getLogger().console("系统初始化...");
		// 设置动态代理前置监听器
		sm.setBeforeListener(new DynamicProxyBeforeListener() {

			@Override
			public void execute(String targetName, String methodName,
					Object[] args) {
				if(methodName == "login") {
					System.out.println("有人登录");
				}
			}
			
		});
		sm.setAfterListener(new DynamicProxyAfterListener(){

			@Override
			public void execute(String targetName, String methodName,
					Object result, Object[] args) {
				
			}
			
		});
	}

}
